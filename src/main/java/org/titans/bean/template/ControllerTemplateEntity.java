package org.titans.bean.template;

public class ControllerTemplateEntity {

    /**
     * 模块.
     */
    private String module;

    /**
     * 功能名.
     */
    private String function;

    private String className;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
