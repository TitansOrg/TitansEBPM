package org.titans.test;

import org.titans.bean.sys.SysUserBean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.*;

public class Test1 {
    
    @Test
    public void test1(){
        String aa = "{\"sysUser\" : [{\"id\" : \"2\",\"usercode\" : \"wuhui1\",\"username\" : \"吴晖\",\"password\" : \"123456\",\"createTime\" : \"2018-12-01\",\"updateTime\" : \"2018-12-01\"}],\"userRoles\" : [\"2\", \"3\"]}";
        JSONObject parseObject = JSON.parseObject(aa);
        JSONArray sysUserArray = (JSONArray) parseObject.get("sysUser");
        Object o = sysUserArray.get(0);
        JSONObject jsonObject2=JSONObject.parseObject(o.toString());
        SysUserBean stu2=(SysUserBean)JSONObject.toJavaObject(jsonObject2, SysUserBean.class);
        System.out.println(stu2.getId());
    }

    public static void main(String[] args) {
        
    }

}
