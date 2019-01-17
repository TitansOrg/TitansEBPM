package org.titans.core.utils;

import java.util.ArrayList;
import java.util.List;

public class QueryHelper {

    private List<Object> parameters;
    
    //from 语句
    private String fromClause = "";
    
    // where语句
    private String whereClause = "";
    
    // order by语句
    private String orderByClause = "";
    
    //排序顺序
    public static String ORDER_BY_DESC = "desc";
    public static String ORDER_BY_ASC = "asc";
    
    /**
     * 构造from子句.
     * @param clazz 实体类
     * @param alias 实体类对应的别名
     */
    public QueryHelper(Class clazz ,String alias) {
        fromClause = "From " + clazz.getSimpleName();
        if (!"".equals(alias)) {

            fromClause += " " + alias;
        }
    }
    
    /**
     * 构造where子句.
     * @param condition 查询条件语句： 例如 i.title like ?
     * @param params 查询条件语句中?对应的查询条件值：例如 %标题%
     */
    public void addCondition(String condition, Object... params) {
        if (whereClause.length() > 1) { // 非第一个查询条件

            whereClause += " and " + condition;
        } else { // 第一个查询条件

            whereClause = " where " + condition;
        }
        // 设置查询条件值到查询条件值集合中
        if (parameters == null) {
            parameters = new ArrayList<Object>();
        }
        if (params != null) {
            for (Object param : params) {
                parameters.add(param);
            }
        }
        
    }
    /**
     * 构造order by子句.
     * @param property 排序属性,如  i.createTime
     * @param order 排序顺序，如：DESC ASC
     */
    public void addOrderByProperty(String property, String order) {
        if (orderByClause.length() > 1) { // 非第一个排序属性

            orderByClause += "," + property + " " + order;
        } else { // 第一个排序属性

            orderByClause = " order by " + property + " " + order;
        }
        
    }
    
    
    // 查询hql语句
    public String getQueryListHql(){
        
        return fromClause + whereClause + orderByClause;
    }
    
    // 查询hql语句中?对应的查询值集合
    public List<Object> getParameters() {
        
        return parameters;
    }
}
