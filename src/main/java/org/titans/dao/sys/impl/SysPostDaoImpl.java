package org.titans.dao.sys.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysPostBean;
import org.titans.core.dao.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysPostDao;

@Repository
public class SysPostDaoImpl extends BaseDaoImpl<SysPostBean> implements ISysPostDao {

    @Override
    public SysPostBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysPostBean) session.get(SysPostBean.class, new Long(id));
    }

    @Override
    public void deleteSysPostInfo(SysPostBean sysPost) {

        Session session = getSession();
        session.delete(sysPost);
    }
}
