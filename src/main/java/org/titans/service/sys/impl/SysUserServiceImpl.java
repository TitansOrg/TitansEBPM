package org.titans.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysUserBean;
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

    public String checkUserLogin(String userCode, String password) {

        SysUserBean user = sysUserDao.querySysUserByCode(userCode, password);
        
        return JSON.toJSONString(user);
    }

    @Override
    public String queryAllSysUserInfo() {

        List<SysUserBean> list = sysUserDao.queryAllSysUserInfo();
        return JSON.toJSONString(list);
    }

    @Override
    public String queryDetailInfoById(String id) {

        SysUserBean sysUserBean = sysUserDao.queryDetailInfoById(id);
        return JSON.toJSONString(sysUserBean, SerializerFeature.DisableCircularReferenceDetect);
    }

    @Override
    public void saveOrUpdateSysUserInfo(SysUserBean sysUser) {

        sysUserDao.saveOrUpdateSysUserInfo(sysUser);
    }

    @Override
    public void removeSysUserInfo(List<SysUserBean> sysUsers) {

        for (int i = 0; i < sysUsers.size(); i++) {

            sysUserDao.deleteSysUserInfo(sysUsers.get(i));
        }
    }
}
