package org.titans.dao.sys.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysUserBean;
import org.titans.core.dao.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysUserDao;

@Repository
public class SysUserDaoImpl extends BaseDaoImpl<SysUserBean> implements ISysUserDao {

    @Override
    public SysUserBean querySysUserByCode(String userCode, String password) {

        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserBean.class);
        criteria.add(Restrictions.eq("usercode", userCode));
        criteria.add(Restrictions.eq("password", password));
        SysUserBean bean = (SysUserBean) criteria.uniqueResult();
        return bean;
    }

    @Override
    public SysUserBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysUserBean) session.get(SysUserBean.class, new Long(id));
    }

    @Override
    public void deleteSysUserInfo(SysUserBean sysUser) {

        Session session = getSession();
        session.delete(sysUser);
    }
}
