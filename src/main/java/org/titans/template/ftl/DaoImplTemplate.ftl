package org.titans.dao.${module}.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.${module}.${className}Bean;
import org.titans.dao.aris.impl.BaseDaoImpl;
import org.titans.dao.${module}.I${className}Dao;

@Repository
public class ${className}DaoImpl extends BaseDaoImpl implements I${className}Dao {

    @Override
    public List<${className}Bean> queryAll${className}Info() {

        Session session = getSession();
        Criteria criteria = session.createCriteria(${className}Bean.class);
        return criteria.list();
    }

    @Override
    public ${className}Bean queryDetailInfoById(String id) {

        Session session = getSession();
        return (${className}Bean) session.get(${className}Bean.class, new Long(id));
    }

    @Override
    public void saveOrUpdate${className}Info(${className}Bean ${className?uncap_first}) {

        Session session = getSession();
        session.saveOrUpdate(${className?uncap_first});
    }

    @Override
    public void delete${className}Info(${className}Bean ${className?uncap_first}) {

        Session session = getSession();
        session.delete(${className?uncap_first});
    }
}
