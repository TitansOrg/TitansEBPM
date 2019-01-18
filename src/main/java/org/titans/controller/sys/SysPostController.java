package org.titans.controller.sys;

import java.util.ArrayList;
import java.util.List;

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
import org.titans.bean.sys.SysPostBean;
import org.titans.service.sys.ISysDeptService;
import org.titans.service.sys.ISysPostService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "/post")
public class SysPostController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(SysPostController.class);

    @Autowired
    private ISysPostService sysPostService;

    @AuthenPassport
    @RequestMapping(value = "sysPostList")
    public ModelAndView sysPostList() {
        
        return new ModelAndView("sys/post/sysPostList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getSysPostList")
    public List<SysPostBean> getSysPostList() {

        List<SysPostBean> list = sysPostService.getAll();
        return list;
    }

    @AuthenPassport
    @RequestMapping(value = "sysPostDetail")
    public ModelAndView sysPostDetail(HttpServletRequest request) {

        return new ModelAndView("sys/post/sysPostDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public SysPostBean queryDetailInfoById(String id, HttpServletRequest request) {

        SysPostBean bean = sysPostService.queryDetailInfoById(id);
        return bean;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody SysPostBean sysPost) {

        boolean result = true;
        try {

            sysPostService.saveOrUpdate(sysPost);
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(sysPost) + "时发生异常，" + e.getMessage(), e);
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

            List<SysPostBean> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseArray(ids);
            for (int i=0; i< jsonArray.size(); i++) {

                SysPostBean bean = new SysPostBean();
                bean.setId(new Long(jsonArray.getString(i)));
                list.add(bean);
            }
            sysPostService.removeSysPostInfo(list);
        } catch (Exception e) {

            log.error("删除数据" + JSON.toJSONString(ids) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
}
