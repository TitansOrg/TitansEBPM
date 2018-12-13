package org.titans.bean.template;

import java.util.ArrayList;
import java.util.List;

public class JspTemplateEntity {

    private String className;

    private String module;

    private String function;

    private String tableDesc;

    private List<ClassMemberBean> members = new ArrayList<>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getTableDesc() {
        return tableDesc;
    }

    public void setTableDesc(String tableDesc) {
        this.tableDesc = tableDesc;
    }

    public List<ClassMemberBean> getMembers() {
        return members;
    }

    public void setMembers(List<ClassMemberBean> members) {
        this.members = members;
    }
}
