package org.titans.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.titans.bean.sys.SysRoleBean;
import org.titans.core.service.impl.BaseServiceImpl;
import org.titans.dao.sys.ISysRoleDao;
import org.titans.service.sys.ISysRoleService;

import com.alibaba.fastjson.JSON;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleBean> implements ISysRoleService {

    private ISysRoleDao sysRoleDao;

    @Resource
    public void setSysRoleDao(ISysRoleDao sysRoleDao) {
        super.setBaseDao(sysRoleDao);
        this.sysRoleDao = sysRoleDao;
    }

    @Override
    public String queryAllSysRoleInfo() {

        List<SysRoleBean> list = sysRoleDao.getAll();
        return JSON.toJSONString(list);
    }

    @Override
    public String queryDetailInfoById(String id) {

        SysRoleBean role = sysRoleDao.queryDetailInfoById(id);
        return JSON.toJSONString(role);
    }

    @Override
    public void removeSysRoleInfo(List<SysRoleBean> sysRoles) {

        for (int i = 0; i < sysRoles.size(); i++) {

            sysRoleDao.deleteSysRoleInfo(sysRoles.get(i));
        }
    }

    @Override
    public SysRoleBean querySysRoleByName(String roleName) {

        SysRoleBean role = sysRoleDao.querySysRoleByName(roleName);
        return role;
    }
}
