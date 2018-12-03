package org.titans.dao.aris.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.titans.bean.aris.ArisAttrName;
import org.titans.bean.aris.ArisGrouptblBean;
import org.titans.bean.aris.ModelBean;
import org.titans.dao.aris.IInitDao;

@Repository("initDaoImpl")
public class InitDaoImpl extends BaseDaoImpl implements IInitDao {

    /**
     * 日志对象.
     */
    private static Logger log = Logger.getLogger(FlowInfoDaoImpl.class);

    @Override
    public Map<Integer, String> queryAttrs() {
        Map<Integer, String> attrMap = new HashMap<Integer, String>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(ArisAttrName.class);
        List<ArisAttrName> list = criteria.list();
        for(ArisAttrName arisAttrName : list) {

            attrMap.put(arisAttrName.getAttributeType(), arisAttrName.getAttributeName());
        }
        return attrMap;
    }

    @Override
    public Map<String, Integer> queryAttrTypeNum() {
        Map<String, Integer> attrTypeNumMap = new HashMap<String, Integer>();
        Session session = getSession();
        Criteria criteria = session.createCriteria(ArisAttrName.class);
        List<ArisAttrName> list = criteria.list();
        for(ArisAttrName arisAttrName : list) {

            attrTypeNumMap.put(arisAttrName.getAttributeName(), arisAttrName.getAttributeType());
        }
        return attrTypeNumMap;
    }

}
