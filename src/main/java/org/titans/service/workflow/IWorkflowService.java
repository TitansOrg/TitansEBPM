package org.titans.service.workflow;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface IWorkflowService {

    List<Map<String, String>> getAllWorkflowList();

    void createDeploymentWorkflow(String workflowName, CommonsMultipartFile file) throws Exception;

    ProcessInstance startProcessInstance(String processDefinitionKey, Map<String, Object> param);

    List<String> queryProcessRoleByKey(String processDefinitionKey);

    List<Map<String, Object>> queryMyTaskList(String usercode);

    List<String> queryTaskBranchInfo(String taskId);

    Map<String, Object> queryCurrentTaskCoording(String taskId);

    /**使用部署对象ID和资源图片名称，获取图片的输入流*/
    InputStream queryDiagramInputStream(String taskId);

    void saveSubmitTask(String userId, String taskId, String brach, String note);

    List<Comment> queryHisCommentByTaskId(String taskId);
}
