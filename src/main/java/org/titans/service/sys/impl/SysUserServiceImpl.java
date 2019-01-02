package org.titans.service.sys.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysUserBean;
import org.titans.bean.sys.SysUserRole;
import org.titans.dao.sys.ISysUserDao;
import org.titans.dao.sys.ISysUserRoleDao;
import org.titans.service.sys.ISysUserService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao sysUserDao;
    
    @Autowired
    private ISysUserRoleDao sysUserRoleDao;

    public SysUserBean checkUserLogin(String userCode, String password) {

        SysUserBean user = sysUserDao.querySysUserByCode(userCode, password);
        return user;
    }

    @Override
    public List<SysUserBean> queryAllSysUserInfo() {

        return sysUserDao.queryAllSysUserInfo();
    }

    @Override
    public String queryDetailInfoById(String id) {
        SysUserBean sysUserBean = sysUserDao.queryDetailInfoById(id);
        sysUserBean.getUserRoleSet();
        return JSON.toJSONString(sysUserBean, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public void saveOrUpdateSysUserInfo(SysUserBean sysUser) {
        //先清空原来的角色
        if(sysUser.getId() != null && sysUser.getUserRoleSet().size() > 0 ){
            
            sysUserRoleDao.removeSysUserRole(sysUser.getId().toString());
        }
        sysUserDao.saveOrUpdateSysUserInfo(sysUser);
    }

    @Override
    public void removeSysUserInfo(List<SysUserBean> sysUsers) {

        for (int i = 0; i < sysUsers.size(); i++) {

            sysUserDao.deleteSysUserInfo(sysUsers.get(i));
        }
    }
}
