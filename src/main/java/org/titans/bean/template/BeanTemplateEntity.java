package org.titans.bean.template;

import java.util.ArrayList;
import java.util.List;

public class BeanTemplateEntity {

    /**
     * 模块.
     */
    private String module;

    /**
     * 表名.
     */
    private String tableName;

    /**
     * 类名.
     */
    private String className;

    /**
     * 表说明.
     */
    private String tableDesc;

    /**
     * 成员名称.
     */
    private List<ClassMemberBean> members = new ArrayList<>();

    public String getClassName() {

        return className;
    }

    public void setClassName(String className) {

        this.className = className;
    }

    public List<ClassMemberBean> getMembers() {

        return members;
    }

    public void setMembers(List<ClassMemberBean> members) {

        this.members = members;
    }

    public String getTableName() {

        return tableName;
    }

    public void setTableName(String tableName) {

        this.tableName = tableName;
    }

    public String getTableDesc() {

        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {

        this.tableDesc = tableDesc;
    }

    public String getModule() {

        return module;
    }

    public void setModule(String module) {

        this.module = module;
    }
}
