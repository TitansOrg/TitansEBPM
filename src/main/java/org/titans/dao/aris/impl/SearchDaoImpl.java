package org.titans.dao.aris.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.titans.bean.aris.ModelAttrBean;
import org.titans.bean.aris.ModelBean;
import org.titans.dao.aris.ISearchDao;
/**
 * ARIS全局查询服务端持久层接口实现类.
 */
@Repository("searchDaoImpl")
public class SearchDaoImpl extends BaseDaoImpl implements ISearchDao {

    /**
     * 日志对象.
     */
    private static Logger log = Logger.getLogger(FlowInfoDaoImpl.class);

    @Override
    public List<ModelAttrBean> queryModelIds(String keyWord) {

        Session session = getSession();
        Criteria criteria = session.createCriteria(ModelAttrBean.class);
        criteria.add(Restrictions.eq("attrtypenum", Long.valueOf("1")));
        criteria.add(Restrictions.like("plaintextfragment", '%'+keyWord+"%"));
        List<ModelAttrBean> list = criteria.list();
        return list;
    }


    @Override
    public List<ModelBean> queryAllFileInfo(List<String> modelIds) {
        Session session = getSession();
        Criteria criteria = session.createCriteria(ModelBean.class);
        criteria.add(Restrictions.in("id", modelIds));
        List<ModelBean> list = criteria.list();
        return list;
    }
}
