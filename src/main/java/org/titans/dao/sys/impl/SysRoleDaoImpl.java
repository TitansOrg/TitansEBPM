package org.titans.dao.sys.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysRoleBean;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysRoleDao;

@Repository
public class SysRoleDaoImpl extends BaseDaoImpl implements ISysRoleDao {

    @Override
    public List<SysRoleBean> queryAllSysRoleInfo() {

        Session session = getSession();
        Criteria criteria = session.createCriteria(SysRoleBean.class);
        return criteria.list();
    }

    @Override
    public SysRoleBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysRoleBean) session.get(SysRoleBean.class, new Long(id));
    }

    @Override
    public void saveOrUpdateSysRoleInfo(SysRoleBean sysRole) {

        Session session = getSession();
        session.saveOrUpdate(sysRole);
    }

    @Override
    public void deleteSysRoleInfo(SysRoleBean sysRole) {

        Session session = getSession();
        session.delete(sysRole);
    }
}
