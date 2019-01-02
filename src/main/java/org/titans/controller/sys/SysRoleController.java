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
import org.titans.bean.sys.SysRoleBean;
import org.titans.service.sys.ISysRoleService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping(value = "/role")
public class SysRoleController {

    /**
     * 日志对象.
     */
    private Logger log = LoggerFactory.getLogger(SysRoleController.class);

    @Autowired
    private ISysRoleService sysRoleService;

    @AuthenPassport
    @RequestMapping(value = "sysRoleList")
    public ModelAndView sysRoleList() {
        
        return new ModelAndView("sys/role/sysRoleList");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "getSysRoleList")
    public String getSysRoleList() {

        String json = sysRoleService.queryAllSysRoleInfo();
        return json;
    }

    @AuthenPassport
    @RequestMapping(value = "sysRoleDetail")
    public ModelAndView sysRoleDetail(HttpServletRequest request) {

        return new ModelAndView("sys/role/sysRoleDetail");
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "queryDetailInfoById")
    public String queryDetailInfoById(String id) {

        String json = sysRoleService.queryDetailInfoById(id);
        return json;
    }

    @AuthenPassport
    @ResponseBody
    @RequestMapping(value = "saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody SysRoleBean sysRole) {

        boolean result = true;
        try {

            sysRoleService.saveOrUpdateSysRoleInfo(sysRole);
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(sysRole) + "时发生异常，" + e.getMessage(), e);
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

            List<SysRoleBean> list = new ArrayList<>();
            JSONArray jsonArray = JSON.parseArray(ids);
            for (int i=0; i< jsonArray.size(); i++) {

                SysRoleBean bean = new SysRoleBean();
                bean.setId(new Long(jsonArray.getString(i)));
                list.add(bean);
            }
            sysRoleService.removeSysRoleInfo(list);
        } catch (Exception e) {

            log.error("删除数据" + JSON.toJSONString(ids) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }
}
