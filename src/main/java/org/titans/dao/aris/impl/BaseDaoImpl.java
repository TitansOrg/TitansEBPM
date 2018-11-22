package org.titans.dao.aris.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 所有DAO实现类的基类.
 */
public class BaseDaoImpl {

    /**
     * 获取session.
     * @return Session 会话
     */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取session.
     * @return Session 会话
     */
    protected Session getSession() {

        return sessionFactory.getCurrentSession();
    }
}
