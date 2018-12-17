package org.titans.dao.sys.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysPostBean;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysPostDao;

@Repository
public class SysPostDaoImpl extends BaseDaoImpl implements ISysPostDao {

    @Override
    public List<SysPostBean> queryAllSysPostInfo() {

        Session session = getSession();
        Criteria criteria = session.createCriteria(SysPostBean.class);
        return criteria.list();
    }

    @Override
    public SysPostBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysPostBean) session.get(SysPostBean.class, new Long(id));
    }

    @Override
    public void saveOrUpdateSysPostInfo(SysPostBean sysPost) {

        Session session = getSession();
        session.saveOrUpdate(sysPost);
    }

    @Override
    public void deleteSysPostInfo(SysPostBean sysPost) {

        Session session = getSession();
        session.delete(sysPost);
    }
}
