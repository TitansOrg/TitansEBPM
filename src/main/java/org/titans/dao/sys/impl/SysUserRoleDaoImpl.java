package org.titans.dao.sys.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysUserRoleDao;

@Repository
public class SysUserRoleDaoImpl extends BaseDaoImpl implements ISysUserRoleDao {

    @Override
    public void removeSysUserRole(String userId) {
        Session session = getSession();
        String  hql=  "delete SysUserRole where userId = :userId"; 
        Query query = session.createQuery(hql);
        query.setParameter("userId", userId).executeUpdate();
    }
}
