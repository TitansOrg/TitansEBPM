package org.titans.service.sys.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysUserBean;
import org.titans.dao.sys.ISysUserDao;
import org.titans.service.sys.ISysUserService;

@Service
public class ISysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserDao sysUserDao;

    public SysUserBean checkUserLogin(String userCode, String password) {

        SysUserBean user = sysUserDao.querySysUserByCode(userCode, password);
        return user;
    }
}
