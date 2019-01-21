package org.titans.dao.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.sys.SysDeptBean;
import org.titans.core.dao.impl.BaseDaoImpl;
import org.titans.dao.sys.ISysDeptDao;

@Repository
public class SysDeptDaoImpl extends BaseDaoImpl<SysDeptBean> implements ISysDeptDao {

    @Override
    public void deleteSysDeptInfo(SysDeptBean sysDept) {

        Session session = getSession();
        session.delete(sysDept);
    }

    @Override
    public List<Map<String, String>> getAllDeptInfo() {

        List<Map<String, String>> depts = new ArrayList<Map<String, String>>();
        Session session = getSession();  
        String hql = "select id,name from SysDeptBean u";  
        Query query = session.createQuery(hql);  
        List<SysDeptBean> list = query.list(); 
        for(Object obj : list){  
            Map<String, String> map = new HashMap<String, String>();
            Object[] arrObj = (Object[])obj;  
            map.put("id", "" + arrObj[0]);
            map.put("name", "" + arrObj[1]);
            depts.add(map);
        }  
        return depts;
    }
}
