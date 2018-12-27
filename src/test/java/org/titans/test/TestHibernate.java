package org.titans.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.titans.bean.sys.SysUserBean;
import org.titans.bean.sys.SysUserRole;
import org.titans.service.sys.ISysUserService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class TestHibernate {
    private static ApplicationContext ac = new ClassPathXmlApplicationContext("/applicationContext.xml");
    
    /**
     * 测试一对多
     */
    @Test
    public  void testOne2N(){
        System.out.println(ac);
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("ebpmSessionFactory");
        Session session = sessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        //SysUserBean sysUser = (SysUserBean) session.get(SysUserBean.class, 1l);
        SysUserBean sysUser = new SysUserBean();
        sysUser.setUsername("liyan");
        sysUser.setPassword("123456");
        System.out.println(sysUser.getUsername());
        JSONArray roleIds = new JSONArray();
        roleIds.add("2");
        roleIds.add("3");
        // 保存角色
        if (roleIds.size() > 0) {
            for(int i = 0;i<roleIds.size();i++) {
                Object roleId = roleIds.get(i);
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setRoleId(roleId.toString());
                //sysUserRole.setSysUserBean(sysUser);
                sysUser.getUserRoleSet().add(sysUserRole);
            }
        }
        session.save(sysUser);
        beginTransaction.commit();
        session.close();
    }
    
    @Test
    public void testGetRoles(){
        System.out.println(ac);
        SessionFactory sessionFactory = (SessionFactory) ac.getBean("ebpmSessionFactory");
        Session session = sessionFactory.openSession();
        Transaction beginTransaction = session.beginTransaction();
        SysUserBean sysUser = (SysUserBean) session.get(SysUserBean.class, 27l);
        Set<SysUserRole> userRoleSet = sysUser.getUserRoleSet();
        for(SysUserRole sysUserRole : userRoleSet) {
            System.out.println(sysUserRole.getRoleId());
            System.out.println(sysUserRole.getUserId());
        }
        String jsonString = JSON.toJSONString(sysUser, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(jsonString);
    }
    
    
    
   
}
