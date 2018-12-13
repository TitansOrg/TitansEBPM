package org.titans.dao.sys.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysDeptBean;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysDeptDao;

@Repository
public class SysDeptDaoImpl extends BaseDaoImpl implements ISysDeptDao {

    @Override
    public List<SysDeptBean> queryAllSysDeptInfo() {

        Session session = getSession();
        Criteria criteria = session.createCriteria(SysDeptBean.class);
        return criteria.list();
    }

    @Override
    public SysDeptBean queryDetailInfoById(String id) {

        Session session = getSession();
        return (SysDeptBean) session.get(SysDeptBean.class, new Long(id));
    }

    @Override
    public void saveOrUpdateSysDeptInfo(SysDeptBean sysDept) {

        Session session = getSession();
        session.saveOrUpdate(sysDept);
    }

    @Override
    public void deleteSysDeptInfo(SysDeptBean sysDept) {

        Session session = getSession();
        session.delete(sysDept);
    }
}
