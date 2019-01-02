package org.titans.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysRoleBean;
import org.titans.dao.sys.ISysRoleDao;
import org.titans.service.sys.ISysRoleService;

import com.alibaba.fastjson.JSON;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private ISysRoleDao sysRoleDao;

    @Override
    public String queryAllSysRoleInfo() {

        List<SysRoleBean> list = sysRoleDao.queryAllSysRoleInfo();
        return JSON.toJSONString(list);
    }

    @Override
    public String queryDetailInfoById(String id) {

        SysRoleBean role = sysRoleDao.queryDetailInfoById(id);
        return JSON.toJSONString(role);
    }

    @Override
    public void saveOrUpdateSysRoleInfo(SysRoleBean sysRole) {

        sysRoleDao.saveOrUpdateSysRoleInfo(sysRole);
    }

    @Override
    public void removeSysRoleInfo(List<SysRoleBean> sysRoles) {

        for (int i = 0; i < sysRoles.size(); i++) {

            sysRoleDao.deleteSysRoleInfo(sysRoles.get(i));
        }
    }
}
