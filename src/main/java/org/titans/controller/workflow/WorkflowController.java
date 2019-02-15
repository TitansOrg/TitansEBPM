package org.titans.controller.workflow;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.task.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.sys.SysUserBean;
import org.titans.service.workflow.IWorkflowService;
import org.titans.util.SessionUtil;

@Controller
@RequestMapping(value = "/workflow")
public class WorkflowController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(WorkflowController.class);

    @Autowired
    private IWorkflowService workflowService;

    @AuthenPassport
    @RequestMapping(value = "processList")
    public ModelAndView processList() {

        return new ModelAndView("workflow/processList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getProcessList")
    public List<Map<String, String>> getProcessList() {

        List<Map<String, String>> list = workflowService.getAllWorkflowList();
        return list;
    }

    /**
     * 进入部署流程页面.
     * @return 部署流程页面
     */
    @AuthenPassport
    @RequestMapping(value = "/processDetail")
    public ModelAndView processDetail() {

        return new ModelAndView("/workflow/processDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/deployWorkflow")
    public String deployWorkflow(@RequestParam("file") CommonsMultipartFile file, String workflowName) {

        String result = "";
        try {

            workflowService.createDeploymentWorkflow(workflowName, file);
            result = "部署成功";
        } catch (Exception e) {

            result = "部署流程时发生异常，异常原因：" + e.getMessage();
            log.error(result, e);
        }
        return result;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/myTaskListPage")
    public ModelAndView myTaskListPage() {

        return new ModelAndView("/portal/portal");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/getMyTaskList")
    public List<Map<String, Object>> getMyTaskList(HttpServletRequest request) {

        SysUserBean user = SessionUtil.getCurrentUser(request);
        List<Map<String, Object>> list = workflowService.queryMyTaskList(user.getUsercode());
        return list;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/queryTaskBranchInfo")
    public List<String> queryTaskBranchInfo(String taskId) {

        List<String> list = workflowService.queryTaskBranchInfo(taskId);
        return list;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/queryCurrentTaskCoording")
    public Map<String, Object> queryCurrentTaskCoording(String taskId) {

        Map<String, Object> result = workflowService.queryCurrentTaskCoording(taskId);
        return result;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/processDiagram")
    public ModelAndView processDiagram(String taskId) {

        return new ModelAndView("/workflow/processDiagram");
    }
    
    @AuthenPassport
    @RequestMapping(value = "/queryCurrentDiagram")
    public void queryCurrentDiagram(String taskId, HttpServletResponse response) {

        InputStream in = null;
        OutputStream out = null;
        
        try {

            in = workflowService.queryDiagramInputStream(taskId);
            out = response.getOutputStream();
            for (int b = -1; (b = in.read()) != -1;) {

                out.write(b);
            }
            out.close();
            in.close();
        } catch (Exception e) {

            log.error("查询流程图时发生异常，原因：" + e.getMessage(), e);
        } finally {

            if (in != null) {
                
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
            if (out != null) {
                
                try {
                    out.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/submitTask")
    public Object submitTask(HttpServletRequest request, String taskId, String branch, String note) {

        boolean result = true;
        try {

            SysUserBean user = SessionUtil.getCurrentUser(request);
            workflowService.saveSubmitTask(user.getUsercode(), taskId, branch, note);
        } catch (Exception e) {

            log.error("任务提交失败，原因：" + e.getMessage(), e);
            result = false;
        }
        return result;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/processHisComment")
    public ModelAndView processHisComment() {

        return new ModelAndView("/workflow/processHisComment");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "/queryProcessHisComment")
    public List<Comment> queryProcessHisComment(String taskId) {

        List<Map<String, Object>> result = new ArrayList<>();
        List<Comment> list = workflowService.queryHisCommentByTaskId(taskId);
        for (int i = 0; i < list.size(); i++) {
//
            Map<String, Object> map = new HashMap<>();
            Comment c = list.get(i);
//            map.put("id", c.getId());
//            map.put("type", c.getId());
//            map.put("time", c.getId());
//            map.put("userId", c.getId());
            map.put("taskId", c.getTaskId());
//            map.put("procInstId", c.getId());
//            map.put("actionId", c.getId());
//            map.put("message", c.getId());
            result.add(map);
        }
        return list;
    }
}
