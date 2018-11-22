package org.titans.dao.aris.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;
import org.titans.bean.aris.ArisGrouptblBean;
import org.titans.bean.aris.ModelBean;
import org.titans.dao.aris.IFlowInfoDao;

/**
 * ARIS系统数据同步服务端持久层接口实现类.
 */
@Repository("flowInfoDaoImpl")
public class FlowInfoDaoImpl extends BaseDaoImpl implements IFlowInfoDao {

    /**
     * 日志对象.
     */
    private static Logger log = Logger.getLogger(FlowInfoDaoImpl.class);

    @Override
    public ModelBean queryEbpmModelBean(String modelId) {

        ModelBean modelBean = (ModelBean) getSession().get(ModelBean.class, modelId);
        return modelBean;
    }

    @Override
    public List<Map<String, String>> queryModelDetailInfo(String modelId, String symbolType) {

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        String sql = "select b.attribute_name,"
                          + "a.long_value,"
                          + "a.plain_text_clob,"
                          + "a.double_value,"
                          + "a.discriminator "
                      + "from aris_model_attr a,"
                           + "aris_attr_name b,"
                           + "aris_model c "
                      + "where c.id='" + modelId + "' "
                        + "and b.attribute_typeguid = a.type_guid "
                        + "and b.belong_type='model' "
                        + "and b.symbol_type='" + symbolType + "' "
                        + "and c.id=a.parent_item_id "
                      + "union all "
                      + "select b.attribute_name,"
                             + "a.long_value,"
                             + "a.plain_text_clob,"
                             + "a.double_value,"
                             + "a.discriminator "
                      + "from aris_model_attr a,"
                           + "aris_attr_name b,"
                           + "aris_model c "
                      + "where c.id='" + modelId + "' "
                        + "and b.attribute_type = a.attr_type_num "
                        + "and a.type_guid is null "
                        + "and b.belong_type='model' "
                        + "and b.symbol_type='" + symbolType + "' "
                        + "and c.id=a.parent_item_id";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.addScalar("attribute_name", StringType.INSTANCE);
        query.addScalar("long_value", LongType.INSTANCE);
        query.addScalar("plain_text_clob", StringType.INSTANCE);
        query.addScalar("double_value", StringType.INSTANCE);
        query.addScalar("discriminator", StringType.INSTANCE);
        List list = query.list();
        Iterator iter = list.iterator();
        while (iter.hasNext()) {

            Object[] objs = (Object[]) iter.next();
            String name = (String) objs[0];
            String val = "";
            String discriminator = (String) objs[4];
            if ("1".equals(discriminator)) {

                // 文本
                val = (String) objs[2];
            } else if ("2".equals(discriminator)) {

                // 时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                val = format.format(new Date((Long) objs[1]));
            } else if ("3".equals(discriminator)) {

                val = "";
            } else if ("4".equals(discriminator)) {

                // 时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                val = format.format(new Date((Long) objs[1]));
            } else if ("5".equals(discriminator)) {

                val = "";
            } else if ("6".equals(discriminator)) {

                // 数字long
                val = objs[1].toString();
            }  else if ("7".equals(discriminator)) {

                // 数字double
                val = objs[3].toString();
            }
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", name);
            map.put("val", val);
            result.add(map);
        }
        return result;
    }

    @Override
    public List<Map<String, String>> queryObjDetailInfo(String objId, String objType) {

        List<Map<String, String>> result = new ArrayList<Map<String, String>>();
        String sql = "select c.attribute_name,"
                          + "a.long_value,"
                          + "a.plain_text_clob,"
                          + "a.double_value,"
                          + "a.discriminator "
                   + "from aris_definition_attr a,"
                        + "aris_definition b,"
                        + "aris_attr_name c "
                   + "where b.id = :objId "
                     + "and c.symbol_type = :objType "
                     + "and c.belong_type = 'object' "
                     + "and a.parent_item_id = b.id "
                     + "and a.type_guid = c.attribute_typeguid "
                   + "union all "
                   + "select c.attribute_name, "
                          + "a.long_value, "
                          + "a.plain_text_clob, "
                          + "a.double_value,"
                          + "a.discriminator "
                   + "from aris_definition_attr a,"
                        + "aris_definition b,"
                        + "aris_attr_name c "
                   + "where b.id = :objId "
                     + "and c.symbol_type = :objType "
                     + "and c.belong_type = 'object' "
                     + "and a.parent_item_id = b.id "
                     + "and c.attribute_type = a.attr_type_num";
                   // + "order by c.attribute_index";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setString("objId", objId);
        query.setString("objType", objType);
        query.addScalar("attribute_name", StringType.INSTANCE);
        query.addScalar("long_value", LongType.INSTANCE);
        query.addScalar("plain_text_clob", StringType.INSTANCE);
        query.addScalar("double_value", StringType.INSTANCE);
        query.addScalar("discriminator", StringType.INSTANCE);
        List list = query.list();
        Iterator iter = list.iterator();
        while (iter.hasNext()) {

            Map<String, String> map = new HashMap<String, String>();
            Object[] objs = (Object[]) iter.next();
            String name = (String) objs[0];
            String discriminator = (String) objs[4];
            String val = "";
            if ("1".equals(discriminator)) {

                // 文本
                val = (String) objs[2];
            } else if ("2".equals(discriminator)) {

                // 时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                val = format.format(new Date((Long) objs[1]));
            } else if ("3".equals(discriminator)) {

                val = "";
            } else if ("4".equals(discriminator)) {

                // 时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                val = format.format(new Date((Long) objs[1]));
            } else if ("5".equals(discriminator)) {

                val = "";
            } else if ("6".equals(discriminator)) {

                // 数字long
                val = objs[1].toString();
            } else if ("7".equals(discriminator)) {

                // 数字double
                val = (String) objs[3];
            }
            map.put("name", name);
            map.put("val", val);
            result.add(map);
        }
        return result;
    }

    @Override
    public ArisGrouptblBean queryGrouptblById(String id) {

        Session session = getSession();
        ArisGrouptblBean arisGrouptbl = (ArisGrouptblBean) session.get(ArisGrouptblBean.class, id);
        return arisGrouptbl;
    }

    @Override
    public List<ArisGrouptblBean> queryGrouptblByParentId(String parentId) {

        Session session = getSession();
        Criteria criteria = session.createCriteria(ArisGrouptblBean.class);
        criteria.add(Restrictions.eq("parentgroupid", parentId));
        return criteria.list();
    }

    @Override
    public List<ModelBean> queryModelByGroupId(String groupId) {

        Session session = getSession();
        Criteria criteria = session.createCriteria(ModelBean.class);
        criteria.add(Restrictions.eq("groupid", groupId));
        return criteria.list();
    }
}
