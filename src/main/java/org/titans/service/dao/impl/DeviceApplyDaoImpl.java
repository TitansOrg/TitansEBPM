package org.titans.service.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.titans.bean.device.DeviceApplyBean;
import org.titans.service.dao.IDeviceApplyDao;

@Repository
public class DeviceApplyDaoImpl implements IDeviceApplyDao {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public List<DeviceApplyBean> queryDeviceApplyList() {

        Session session = sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(DeviceApplyBean.class);
        return criteria.list();
    }

    @Override
    public Serializable saveDeviceApp(DeviceApplyBean deviceApplyBean) {

        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(deviceApplyBean);
        return session.save(deviceApplyBean);
    }

    @Override
    public void updateDeviceApply(DeviceApplyBean deviceApplyBean) {

        Session session = sessionFactory.getCurrentSession();
        session.update(deviceApplyBean); 
    }

    @Override
    public DeviceApplyBean queryDeviceApplyById(Serializable id) {

        Session session = sessionFactory.getCurrentSession();
        return (DeviceApplyBean) session.get(DeviceApplyBean.class, id);
    }
}
