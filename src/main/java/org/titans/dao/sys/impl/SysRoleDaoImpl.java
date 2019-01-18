package org.titans.dao.sys.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysRoleBean;
import org.titans.core.dao.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysRoleDao;

@Repository
public class SysRoleDaoImpl extends BaseDaoImpl<SysRoleBean> implements ISysRoleDao {

    @Override
    public SysRoleBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysRoleBean) session.get(SysRoleBean.class, new Long(id));
    }

    @Override
    public void deleteSysRoleInfo(SysRoleBean sysRole) {

        Session session = getSession();
        session.delete(sysRole);
    }
}
