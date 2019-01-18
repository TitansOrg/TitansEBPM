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
import org.titans.bean.sys.SysUserBean;
import org.titans.service.sys.ISysUserService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "/user")
public class SysUserController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private ISysUserService sysUserService;

    @AuthenPassport
    @RequestMapping(value = "sysUserList")
    public ModelAndView sysUserList() {
        
        return new ModelAndView("sys/user/sysUserList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getSysUserList")
    public String getSysUserList() {

        String str = sysUserService.queryAllSysUserInfo();
        return str;
    }

    @AuthenPassport
    @RequestMapping(value = "sysUserDetail")
    public ModelAndView sysUserDetail(HttpServletRequest request) {

        return new ModelAndView("sys/user/sysUserDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public Object queryDetailInfoById(String id) {

        String json = sysUserService.queryDetailInfoById(id);
        return json;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody SysUserBean sysUser) {

        boolean result = true;
        try {

            sysUserService.saveOrUpdate(sysUser);
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(sysUser) + "时发生异常，" + e.getMessage(), e);
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

            List<SysUserBean> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseArray(ids);
            for (int i=0; i< jsonArray.size(); i++) {

                SysUserBean bean = new SysUserBean();
                bean.setId(new Long(jsonArray.getString(i)));
                list.add(bean);
            }
            sysUserService.removeSysUserInfo(list);
        } catch (Exception e) {

            log.error("删除数据" + JSON.toJSONString(ids) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
    
   
}
