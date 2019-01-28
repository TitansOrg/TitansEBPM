package org.titans.core.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.titans.core.dao.IBaseDao;
import org.titans.core.page.PageResult;
import org.titans.core.utils.QueryHelper;

import com.alibaba.fastjson.JSON;

/**
 * 所有dao通用操作，所有的daoImpl继承此类
 * @author Administrator
 *
 */

public class BaseDaoImpl<T> implements IBaseDao<T> {
     
    // 得到当前操作的实际bean的类型
    private Class<T> clazz;
    // 获取类名称
    private String className;
    // 容器注入
    @Autowired
    public SessionFactory sessionFactory;
    
    private Session session;
    
    // 反射泛型
    public BaseDaoImpl(){

        Type type = this.getClass().getGenericSuperclass();
        // 转换为参数化类型
        ParameterizedType pt = (ParameterizedType) type;  // BaseDao<Emp>
        // 得到实际类型
        Type types[] = pt.getActualTypeArguments();
        // 获取实际类型
        clazz = (Class<T>) types[0];
        
        className = clazz.getSimpleName();//例如：Emp
    }
    
    public Session getSession(){
        session = sessionFactory.getCurrentSession();
        if (null== session){

             session=sessionFactory.openSession();
        }
        return session;
    }
    
    @Override
    public void saveOrUpdate(T t) {

        getSession().saveOrUpdate(t);
    }

    @Override
    public void delete(Serializable id) {
        getSession()
        .delete(
                getSession().load(clazz, id)
        );
        
    }

    @Override
    public T findById(Serializable id) {
        T t = (T) getSession().get(clazz, id);
        return t;
    }

    @Override
    public List<T> getAll() {
        List<T> list = getSession().createQuery("from " + className).list();
        JSON.toJSONString(list);
        return list;
    }

    @Override
    public List<T> findObjects(String hql, List<Object> parameters) {
        Query query = getSession().createQuery(hql);
        if (parameters != null) {
            for (int i = 0; i < parameters.size(); i++) {

                query.setParameter(i, parameters.get(i));
            }
        }
        return query.list();
    }

    @Override
    public List<T> findObjects(QueryHelper queryHelper) {

        Query query = getSession().createQuery(queryHelper.getQueryListHql());
        List<Object> parameters = queryHelper.getParameters();
        if (parameters != null) {
            for (int i = 0; i < parameters.size(); i++) {

                query.setParameter(i, parameters.get(i));
            }
        }
        return query.list();
    }


}
