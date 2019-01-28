package org.titans.controller.sys;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.titans.annotation.AuthenPassport;
import org.titans.bean.sys.SysUserBean;
import org.titans.service.sys.ISysUserService;
import org.titans.util.ExcelUtil;
import org.titans.util.Result;

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
    
    // 导出用户列表到excel
    @AuthenPassport
    @RequestMapping(value = "exportExcel")
    public void exportExcel(HttpServletResponse response) throws ServiceException {
        List<SysUserBean> userList = sysUserService.getAll();
        // 2导出
        try {
            // 生成低版本让高级低级版本都能打开
            // new String 防止除IE外的浏览器中文乱码
            response.setContentType("application/x-execl");
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
            ServletOutputStream outputStream = response.getOutputStream();
            sysUserService.exportExcel(userList, outputStream);
            if (outputStream != null) {
                outputStream.close();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @AuthenPassport
    @RequestMapping(value = "importDetail")
    public ModelAndView importDetail(HttpServletRequest request) {

        return new ModelAndView("sys/user/importDetail");
    }

    @AuthenPassport
    @RequestMapping(value = "importExcel")
    @ResponseBody
    public boolean uploadFlatness(@RequestParam("file") MultipartFile file,
            HttpServletRequest request) throws IOException {
        boolean result = true;
        try {

            sysUserService.saveExcel(file);
        } catch (Exception e) {

            log.error("保存或更新数据" + JSON.toJSONString(file) + "时发生异常，" + e.getMessage(), e);
            result = false;
        }
        return result;
    }

}
