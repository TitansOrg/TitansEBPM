package org.titans.controller.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.sys.SysDeptBean;
import org.titans.service.sys.ISysDeptService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "/dept")
public class SysDeptController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(SysDeptController.class);

    @Autowired
    private ISysDeptService sysDeptService;

    @AuthenPassport
    @RequestMapping(value = "sysDeptList")
    public ModelAndView sysDeptList() {
        
        return new ModelAndView("sys/dept/sysDeptList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getSysDeptList")
    public List<SysDeptBean> getSysDeptList() {

        List<SysDeptBean> list = sysDeptService.getAll();
        return list;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getAllDept")
    public List<Map<String, String>> getAllDept() {

        List<Map<String, String>> allDeptInfo = sysDeptService.getAllDeptInfo();
        return allDeptInfo;
    }
    
    @AuthenPassport
    @RequestMapping(value = "sysDeptDetail")
    public ModelAndView sysDeptDetail(HttpServletRequest request) {

        return new ModelAndView("sys/dept/sysDeptDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public SysDeptBean queryDetailInfoById(String id) {

        SysDeptBean bean = sysDeptService.findById(new Long(id));
        return bean;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody SysDeptBean sysDept) {

        boolean result = true;
        try {

            sysDeptService.saveOrUpdate(sysDept);
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(sysDept) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "removeData")
    public boolean removeData(String ids) {

        boolean result = true;
        try {

            List<SysDeptBean> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseArray(ids);
            for (int i=0; i< jsonArray.size(); i++) {

                SysDeptBean bean = new SysDeptBean();
                bean.setId(new Long(jsonArray.getString(i)));
                list.add(bean);
            }
            sysDeptService.removeSysDeptInfo(list);
        } catch (Exception e) {

            log.error("删除数据" + JSON.toJSONString(ids) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
}
