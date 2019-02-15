package org.titans.service.workflow.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.delegate.ActivityBehavior;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.titans.bean.sys.SysRoleBean;
import org.titans.bean.sys.SysUserBean;
import org.titans.service.sys.ISysRoleService;
import org.titans.service.workflow.IWorkflowService;

@Service
public class WorkflowServiceImpl implements IWorkflowService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private FormService formService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Override
    public List<Map<String, String>> getAllWorkflowList() {

        List<Map<String, String>> result = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ProcessDefinition> list = repositoryService
            .createProcessDefinitionQuery().orderByProcessDefinitionName().asc().list();
        for (int i = 0; i < list.size(); i++) {

            ProcessDefinition proc = list.get(i);
            Map<String, String> map = new HashMap<>();
            map.put("id", proc.getId());
            map.put("workflowName", proc.getName());
            map.put("key", proc.getKey());
            map.put("version", proc.getVersion() + "");
            map.put("resourceName", proc.getResourceName());
            map.put("diagramResourceName", proc.getDiagramResourceName());
            String deploymentId = proc.getDeploymentId();
            map.put("deploymentId", deploymentId);
            Deployment deployment = repositoryService.createDeploymentQuery()
                .deploymentId(deploymentId).singleResult();
            map.put("deployName", deployment.getName());
            map.put("deployTime", format.format(deployment.getDeploymentTime()));
            result.add(map);
        }
        return result;
    }

    @Override
    public void createDeploymentWorkflow(String workflowName, CommonsMultipartFile file) throws Exception {

        if (StringUtils.isBlank(workflowName)) {

            workflowName = file.getOriginalFilename();
        }
        ZipInputStream zipInputStream = null;
        try {

            zipInputStream = new ZipInputStream(file.getInputStream());
            repositoryService.createDeployment().name(workflowName).addZipInputStream(zipInputStream).deploy();
        } catch (Exception e) {

            throw e;
        } finally {

            if (zipInputStream != null) {

                zipInputStream.close();
            }
        }
    }

    @Override
    public List<String> queryProcessRoleByKey(String processDefinitionKey) {

        List<String> result = new ArrayList<>();
        ProcessDefinition pd = repositoryService.createProcessDefinitionQuery()
            .processDefinitionKey(processDefinitionKey).latestVersion().singleResult();
        ProcessDefinitionEntity pde = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(pd.getId());
        List<ActivityImpl> list = pde.getActivities();
        for (int i = 0; i < list.size(); i++) {

            ActivityImpl activiti = list.get(i);
            ActivityBehavior ab = activiti.getActivityBehavior();
            if (ab instanceof UserTaskActivityBehavior) {

                UserTaskActivityBehavior uab = (UserTaskActivityBehavior) ab;
                Set<Expression> set = uab.getTaskDefinition().getCandidateUserIdExpressions();
                if (set.size() > 0) {

                    Iterator<Expression> iter = set.iterator();
                    while (iter.hasNext()) {

                        Expression expression = iter.next();
                        String role = expression.getExpressionText();
                        result.add(role.substring(2, role.length() - 1));
                    }
                } else {

                    result.add("系统管理员");
                }
            }
        }
        return result;
    }

    @Override
    public ProcessInstance startProcessInstance(String processDefinitionKey, Map<String, Object> param) {

        // 查询各个任务关卡审批角色如${系统管理员}
        List<String> list = queryProcessRoleByKey(processDefinitionKey);
        // 设置流程参数，审批人
        for (String roleName : list) {

            SysRoleBean role = sysRoleService.querySysRoleByName(roleName);
            List<SysUserBean> users = role.getUsers();
            String userCodes = "";
            for (int i=0;i<users.size();i++) {

                userCodes = userCodes + "," + users.get(i).getUsercode();
            }
            if (!"".equals(userCodes)) {

                param.put(roleName, userCodes.substring(1));
            } else {

                param.put(roleName, "shangjc");
            }
        }
        // 启动流程
        ProcessInstance processInstance = (ExecutionEntity) runtimeService
            .startProcessInstanceByKey(processDefinitionKey, param);
        return processInstance;
    }

    @Override
    public List<Map<String, Object>> queryMyTaskList(String usercode) {

        List<Map<String, Object>> result = new ArrayList<>();
        List<Task> list = taskService.createTaskQuery()
            .taskCandidateUser(usercode)
            .orderByTaskCreateTime().asc()
            .list();
        for (Task task : list) {

            Map<String, Object> map = new HashMap<>();
            map.put("taskId", task.getId());
            map.put("taskName", task.getName());
            map.put("createTime", task.getCreateTime());
            map.put("processId", task.getProcessInstanceId());
            map.put("execId", task.getExecutionId());
            map.put("defId", task.getProcessDefinitionId());
            // getProcessVariables().get("businessKey")
            String businessKey = (String) runtimeService.getVariable(task.getExecutionId(), "businessKey");
            map.put("businessKey", businessKey);
            result.add(map);
        }
        return result;
    }

    @Override
    public List<String> queryTaskBranchInfo(String taskId) {

        List<String> list = new ArrayList<String>();
        // 1:使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        // 2：获取流程定义ID
        String processDefinitionId = task.getProcessDefinitionId();
        // 3：查询ProcessDefinitionEntiy对象
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity) repositoryService
            .getProcessDefinition(processDefinitionId);
        // 使用任务对象Task获取流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        // 使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()
            .processInstanceId(processInstanceId)
            .singleResult();
        // 获取当前活动的id
        String activityId = pi.getActivityId();
        // 4：获取当前的活动
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);
        // 5：获取当前活动完成之后连线的名称
        List<PvmTransition> pvmList = activityImpl.getOutgoingTransitions();
        for (PvmTransition pvm:pvmList) {

            String name = (String) pvm.getProperty("name");
            if (StringUtils.isNotBlank(name)) {

                list.add(name);
            } else {

                list.add("提交");
            }
        }
        return list;
    }

    @Override
    public InputStream queryDiagramInputStream(String taskId) {

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processDefinitionId = task.getProcessDefinitionId();
        ProcessDefinition processDefinition = repositoryService.getProcessDefinition(processDefinitionId);
        String deploymentId = processDefinition.getDeploymentId();
        String imageName = processDefinition.getDiagramResourceName();
        return repositoryService.getResourceAsStream(deploymentId, imageName);
    }

    @Override
    public Map<String, Object> queryCurrentTaskCoording(String taskId) {

        // 存放坐标
        Map<String, Object> map = new HashMap<String,Object>();
        // 使用任务ID，查询任务对象
        Task task = taskService.createTaskQuery()//
                    .taskId(taskId)//使用任务ID查询
                    .singleResult();
        // 获取流程定义的ID
        String processDefinitionId = task.getProcessDefinitionId();
        // 获取流程定义的实体对象（对应.bpmn文件中的数据）
        ProcessDefinitionEntity processDefinitionEntity = (ProcessDefinitionEntity)repositoryService.getProcessDefinition(processDefinitionId);
        // 流程实例ID
        String processInstanceId = task.getProcessInstanceId();
        // 使用流程实例ID，查询正在执行的执行对象表，获取当前活动对应的流程实例对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery()//创建流程实例查询
                    .processInstanceId(processInstanceId)//使用流程实例ID查询
                    .singleResult();
        // 获取当前活动的ID
        String activityId = pi.getActivityId();
        // 获取当前活动对象
        ActivityImpl activityImpl = processDefinitionEntity.findActivity(activityId);//活动ID
        // 获取坐标
        map.put("x", activityImpl.getX());
        map.put("y", activityImpl.getY());
        map.put("width", activityImpl.getWidth());
        map.put("height", activityImpl.getHeight());
        return map;
    }

    @Override
    public void saveSubmitTask(String userId, String taskId, String branch, String note) {

        // 查询任务对象
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = task.getProcessInstanceId();
        // 设置批注
        Authentication.setAuthenticatedUserId(userId);
        taskService.addComment(taskId, processInstanceId, note);
        /**
         * 2：如果连线的名称是“提交”，那么就不需要设置，如果不是，就需要设置流程变量
         * 在完成任务之前，设置流程变量，按照连线的名称，去完成任务
         * 流程变量的名称：outcome
         * 流程变量的值：连线的名称
         */
        Map<String, Object> variables = new HashMap<String,Object>();
        if (branch != null && !branch.equals("提交")) {

            variables.put("outcome", branch);
        }
        //3：使用任务ID，完成当前人的个人任务，同时设置流程变量
        taskService.complete(taskId, variables);
    }

    @Override
    public List<Comment> queryHisCommentByTaskId(String taskId) {

        HistoricTaskInstance task = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        List<Comment> list = taskService.getProcessInstanceComments(task.getProcessInstanceId());
        return list;
    }
}
