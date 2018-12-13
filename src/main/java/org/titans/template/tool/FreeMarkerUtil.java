package org.titans.template.tool;

import java.io.File;
import java.io.PrintWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtil {

    public static Template getTemplate(String name) throws Exception {

        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "/org/titans/template/ftl");
        Template temp = cfg.getTemplate(name);
        return temp;
    }

    public static void print(String tempName, Object param, String path) throws Exception {

        Template temp = getTemplate(tempName);
        File file = new File(path);
        if (!file.getParentFile().exists()) {

            file.getParentFile().mkdirs();
        }
        temp.process(param, new PrintWriter(file));
    }

    private static ApplicationContext application = new ClassPathXmlApplicationContext(new String[] {

        "applicationContext.xml",
    });

    public static void main(String[] args) throws Exception {

        String tableName = "sys_dept";
        CodeGenerateUtil.createBeanFile(tableName, application);
        CodeGenerateUtil.createDaoFile(tableName);
        CodeGenerateUtil.createServiceFile(tableName);
        CodeGenerateUtil.createControllerFile(tableName);
        CodeGenerateUtil.createListJspFile(tableName, application);
        CodeGenerateUtil.createDetailJspFile(tableName, application);
    }
}
