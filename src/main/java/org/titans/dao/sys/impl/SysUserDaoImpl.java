package org.titans.dao.sys.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.titans.bean.sys.SysUserBean;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysUserDao;

@Repository
@Transactional
public class SysUserDaoImpl extends BaseDaoImpl implements ISysUserDao {

    @Override
    public SysUserBean querySysUserByCode(String userCode, String password) {

        Session session = getSession();
        Criteria criteria = session.createCriteria(SysUserBean.class);
        criteria.add(Restrictions.eq("usercode", userCode));
        criteria.add(Restrictions.eq("password", password));
        SysUserBean bean = (SysUserBean) criteria.uniqueResult();
        return bean;
    }
}
