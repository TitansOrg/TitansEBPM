package org.titans.core.service.impl;

import java.io.Serializable;
import java.util.List;

import org.titans.core.dao.IBaseDao;
import org.titans.core.service.BaseService;
import org.titans.core.utils.QueryHelper;

public class BaseServiceImpl<T> implements BaseService<T> {

    private IBaseDao<T> baseDao;
    
    public BaseServiceImpl(){

    }
    /**
     * @param baseDao the baseDao to set
     */
    public void setBaseDao(IBaseDao<T> baseDao) {
        
        this.baseDao = baseDao;
    }

    
    @Override
    public void saveOrUpdate(T t) {
        baseDao.saveOrUpdate(t);
    }

    @Override
    public void delete(Serializable id) {
        baseDao.delete(id);
    }

    @Override
    public T findById(Serializable id) {
        return baseDao.findById(id);
    }

    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }


    @Override
    public List<T> findObjects(String hql, List<Object> parameters) {

        return baseDao.findObjects(hql, parameters);
    }

    @Override
    public List<T> findObjects(QueryHelper queryHelper) {
        return baseDao.findObjects(queryHelper);
    }

}
