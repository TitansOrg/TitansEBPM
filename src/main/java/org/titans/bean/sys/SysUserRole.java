package org.titans.bean.sys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity()
@Table(name= "sys_user_role")
public class SysUserRole  {

    @Id
    @GeneratedValue(generator = "uuid") @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    
    @Column(name = "sys_user_id", length = 32)
    private String userId;

    @Column(name = "sys_role_id", length = 32)
    private String roleId;
    
    //private  SysUserBean sysUserBean;
   
    public String getId() {
        return id;
    }
    

    
    public String getUserId() {
        return userId;
    }
   
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    public String getRoleId() {
        return roleId;
    }
   
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
   
   

  
    
    
}
