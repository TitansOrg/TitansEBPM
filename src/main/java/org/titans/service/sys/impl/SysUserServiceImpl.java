package org.titans.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysDeptBean;
import org.titans.bean.sys.SysUserBean;
import org.titans.core.service.impl.BaseServiceImpl;
import org.titans.dao.sys.ISysPostDao;
import org.titans.dao.sys.ISysUserDao;
import org.titans.dao.sys.ISysUserRoleDao;
import org.titans.service.sys.ISysUserService;
import org.titans.util.ExcelUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUserBean> implements ISysUserService {

    @Autowired
    private ISysUserDao sysUserDao;

    @Resource
    public void setSysUserDao(ISysUserDao sysUserDao) {
        super.setBaseDao(sysUserDao);
        this.sysUserDao = sysUserDao;
    }
    public String checkUserLogin(String userCode, String password) {

        SysUserBean user = sysUserDao.querySysUserByCode(userCode, password);
        
        return JSON.toJSONString(user);
    }

    @Override
    public String queryAllSysUserInfo() {

        List<SysUserBean> list = sysUserDao.getAll();
        return JSON.toJSONString(list);
    }

    @Override
    public String queryDetailInfoById(String id) {

        SysUserBean sysUserBean = sysUserDao.queryDetailInfoById(id);
        return JSON.toJSONString(sysUserBean, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public void removeSysUserInfo(List<SysUserBean> sysUsers) {

        for (int i = 0; i < sysUsers.size(); i++) {

            sysUserDao.deleteSysUserInfo(sysUsers.get(i));
        }
    }
    @Override
    public void exportExcel(List<SysUserBean> userList, ServletOutputStream outputStream) {

        ExcelUtil.exportExcel(userList, outputStream);
    }
}
