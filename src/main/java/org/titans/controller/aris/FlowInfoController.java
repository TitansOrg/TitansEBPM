package org.titans.controller.aris;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.service.aris.IFlowInfoService;

/**
 * 流程图显示.
 */
@Controller
@RequestMapping(value = "/flowInfo")
public class FlowInfoController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(FlowInfoController.class);

    /**
     * DI注入数据同步模块服务层对象.
     */
    @Autowired
    private IFlowInfoService flowInfoService;

    /**
     * 查询流程管理平台中指定的模型信息.
     * @throws Exception 发布异常
     */
    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryEbpmModelBean")
    public Object queryEbpmModelBean(String modelId) {

        String json = "";
        try {

            modelId = URLDecoder.decode(modelId, "utf-8");
            json = flowInfoService.queryEbpmModelBean(modelId);
        } catch (Exception e) {

            log.error("查询流程管理平台中指定的模型信息发生异常：" + e.getMessage(), e);
        }
        return json;
    }

    /**
     * 查询指定流程所有属性.
     * @throws Exception Exception
     */
    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryModelDetailInfo")
    public Object queryModelDetailInfo(String modelId) {

        List<Map<String, String>> map = new ArrayList<>();
        try {

            modelId = URLDecoder.decode(modelId, "utf-8");
            map = flowInfoService.queryModelDetailInfo(modelId);
        } catch (Exception e) {

            log.error("查询指定流程所有属性时发生异常：" + e.getMessage(), e);
        }
        return map;
    }

    /**
     * 查询指定流程中对象所有属性.
     * @param guid 对象ID
     * @param objType 对象类型
     * @return 对象详细信息
     * @throws Exception Exception
     */
    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryObjDetailInfo")
    public Object queryObjDetailInfo(String guid, String objType) {

        List<Map<String, String>> list = new ArrayList<>();
        try {

            guid = URLDecoder.decode(guid, "utf-8");
            list = flowInfoService.queryObjDetailInfo(guid, objType);
        } catch (Exception e) {

            log.error("查询指定流程中对象所有属性时发生异常：" + e.getMessage(), e);
        }
        return list;
    }

    /**
     * 响应显示流程图详细内容页面跳转方法.
     * @return 直接跳转到流程详细信息页面
     * @throws Exception Exception
     */
    @AuthenPassport
    @RequestMapping(value = "flowDetail")
    public ModelAndView flowDetail(String modelId) {

        return new ModelAndView("/flowView/flowView");
    }

    /**
     * 获取文件个路径信息.
     * @return 文件根路径信息
     */
    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getFileRootPath")
    public List<Map<String, String>> getFileRootPath(String id) {

        List<Map<String, String>> result = new ArrayList<>();
        if (id == null) {

            Map<String, String> rootPath = flowInfoService.queryFileRootPath();
            result.add(rootPath);
        } else {

            result = flowInfoService.queryFileInfoByParentId(id);
        }
        return result;
    }
}
