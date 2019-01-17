package org.titans.core.dao;

import java.io.Serializable;
import java.util.List;

import org.titans.core.utils.QueryHelper;

/**
 * 所有dao的通用操作接口定义.
 */
public interface IBaseDao<T> {

	/**
	 * 保存员工
	 * @param emp
	 */
	void saveOrUpdate(T t);

	/**
	 * 根据主键删除
	 * @param id
	 */
	void delete(Serializable id);

	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	T findById(Serializable id);

	/**
	 * 查询全部
	 * @return
	 */
	List<T> getAll();

	
	List<T> findObjects(String hql, List<Object> parameters);
	
	List<T> findObjects(QueryHelper queryHelper);

}
