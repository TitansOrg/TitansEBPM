package org.titans.template.tool;

import java.io.File;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.titans.bean.template.BeanTemplateEntity;
import org.titans.bean.template.ClassMemberBean;
import org.titans.bean.template.ControllerTemplateEntity;
import org.titans.bean.template.DaoTemplateEntity;
import org.titans.bean.template.JspTemplateEntity;
import org.titans.bean.template.ServiceTemplateEntity;

public class CodeGenerateUtil {

    public static void createBeanFile(String tableName, ApplicationContext application) throws Exception {

        BeanTemplateEntity bean = new BeanTemplateEntity();
        bean.setTableName(tableName);
        // 类名
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        // 表描述
        String tableDesc = TableStructureUtil.getTableDesc(tableName, application);
        bean.setTableDesc(tableDesc);
        // 成员
        List<ClassMemberBean> members = TableStructureUtil.getClassMembers(tableName, application);
        bean.setMembers(members);
        String path = new File("").getAbsolutePath() + "/src/main/java/org/titans/bean/"+ bean.getModule() + "/" + bean.getClassName() +"Bean.java";
        FreeMarkerUtil.print("BeanTemplate.ftl", bean, path);
    }

    public static void createDaoFile(String tableName) throws Exception {

        DaoTemplateEntity bean = new DaoTemplateEntity();
        // 类名
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        String path = new File("").getAbsolutePath() + "/src/main/java/org/titans/dao/"
            + bean.getModule() + "/I" + bean.getClassName() +"Dao.java";
        FreeMarkerUtil.print("IDaoTemplate.ftl", bean, path);
        path = new File("").getAbsolutePath() + "/src/main/java/org/titans/dao/"
            + bean.getModule() + "/impl/" + bean.getClassName() +"DaoImpl.java";
        FreeMarkerUtil.print("DaoImplTemplate.ftl", bean, path);
    }

    public static void createServiceFile(String tableName) throws Exception {

        ServiceTemplateEntity bean = new ServiceTemplateEntity();
        // 类名
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        String path = new File("").getAbsolutePath() + "/src/main/java/org/titans/service/"
            + bean.getModule() + "/I" + bean.getClassName() +"Service.java";
        FreeMarkerUtil.print("IServiceTemplate.ftl", bean, path);
        path = new File("").getAbsolutePath() + "/src/main/java/org/titans/service/"
            + bean.getModule() + "/impl/" + bean.getClassName() +"ServiceImpl.java";
        FreeMarkerUtil.print("ServiceImplTemplate.ftl", bean, path);
    }

    public static void createControllerFile(String tableName) throws Exception {

        ControllerTemplateEntity bean = new ControllerTemplateEntity();
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        bean.setFunction(str[1]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        String path = new File("").getAbsolutePath() + "/src/main/java/org/titans/controller/"
                + bean.getModule() + "/"+ bean.getClassName() +"Controller.java";
        FreeMarkerUtil.print("ControllerTemplate.ftl", bean, path);
    }

    public static void createListJspFile(String tableName, ApplicationContext application) throws Exception {

        JspTemplateEntity bean = new JspTemplateEntity();
        // 类名
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        bean.setFunction(str[1]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        // 表描述
        String tableDesc = TableStructureUtil.getTableDesc(tableName, application);
        bean.setTableDesc(tableDesc);
        // 成员
        List<ClassMemberBean> members = TableStructureUtil.getClassMembers(tableName, application);
        bean.setMembers(members);
        
        String fileName = bean.getClassName().substring(0, 1).toLowerCase() + bean.getClassName().substring(1);
        
        String path = new File("").getAbsolutePath() + "/src/main/webapp/WEB-INF/views/"
            + bean.getModule() + "/" + bean.getFunction() + "/" + fileName + "List.jsp";
        FreeMarkerUtil.print("ListJspTemplate.ftl", bean, path);
        
    }

    public static void createDetailJspFile(String tableName, ApplicationContext application) throws Exception {

        JspTemplateEntity bean = new JspTemplateEntity();
        // 类名
        String className = "";
        String[] str = tableName.split("_");
        bean.setModule(str[0]);
        bean.setFunction(str[1]);
        for (int i = 0; i < str.length; i++) {

            className = className + str[i].substring(0, 1).toUpperCase() + str[i].substring(1);
        }
        bean.setClassName(className);
        // 表描述
        String tableDesc = TableStructureUtil.getTableDesc(tableName, application);
        bean.setTableDesc(tableDesc);
        // 成员
        List<ClassMemberBean> members = TableStructureUtil.getClassMembers(tableName, application);
        bean.setMembers(members);
        
        String fileName = bean.getClassName().substring(0, 1).toLowerCase() + bean.getClassName().substring(1);
        
        String path = new File("").getAbsolutePath() + "/src/main/webapp/WEB-INF/views/"
            + bean.getModule() + "/" + bean.getFunction() + "/" + fileName + "Detail.jsp";
        FreeMarkerUtil.print("DetailJspTemplate.ftl", bean, path);
    }
}
