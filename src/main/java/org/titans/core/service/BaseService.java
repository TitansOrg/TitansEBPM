package org.titans.core.service;

import java.io.Serializable;
import java.util.List;

import org.titans.core.utils.QueryHelper;



public interface BaseService<T> {
	/**
	 * 保存.
	 * @param emp
	 */
	void saveOrUpdate(T t);

	/**
	 * 根据主键删除.
	 * @param id
	 */
	void delete(Serializable id);

	/**
	 * 根据主键查询.
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	/**
	 * 查询全部.
	 * @return
	 */
	List<T> getAll();

	@Deprecated
	List<T> findObjects(String hql, List<Object> parameters);
	
	//查询助手查询
	List<T> findObjects(QueryHelper queryHelper);
	
	//分页查询
}
