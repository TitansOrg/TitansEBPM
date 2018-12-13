package org.titans.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysUserBean;
import org.titans.dao.sys.ISysUserDao;
import org.titans.service.sys.ISysUserService;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao sysUserDao;

    public SysUserBean checkUserLogin(String userCode, String password) {

        SysUserBean user = sysUserDao.querySysUserByCode(userCode, password);
        return user;
    }

    @Override
    public List<SysUserBean> queryAllSysUserInfo() {

        return sysUserDao.queryAllSysUserInfo();
    }

    @Override
    public SysUserBean queryDetailInfoById(String id) {

        return sysUserDao.queryDetailInfoById(id);
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
