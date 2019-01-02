package org.titans.bean.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 用户管理表.
 */
@Entity
@Table(name = "sys_user")
public class SysUserBean {

    /**
     * 表主键.
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户账号.
     */
    @Column(name = "usercode")
    private String usercode;

    /**
     * 用户名称.
     */
    @Column(name = "username")
    private String username;

    /**
     * 用户密码.
     */
    @Column(name = "password")
    private String password;

    /**
     * 创建时间.
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间.
     */
    @Column(name = "update_time")
    private Date updateTime;

    @ManyToMany(targetEntity = SysRoleBean.class, fetch = FetchType.LAZY)
    @JoinTable(name="sys_user_role",
        joinColumns={@JoinColumn(name="user_id",referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="role_id",referencedColumnName="id")}
    )
    private List<SysRoleBean> roles = new ArrayList<>();

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

   
    public String getUsercode() {

        return usercode;
    }

    public void setUsercode(String usercode) {

        this.usercode = usercode;
    }

   
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    
    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    
    public Date getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }

    public List<SysRoleBean> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRoleBean> roles) {
        this.roles = roles;
    }
}
