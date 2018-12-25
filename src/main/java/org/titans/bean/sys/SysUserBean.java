package org.titans.bean.sys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户管理表.
 */
@Entity
@Table(name = "sys_user")
public class SysUserBean {

    /**
     * 表主键.
     */
    private Long id;

    /**
     * 用户账号.
     */
    private String usercode;

    /**
     * 用户名称.
     */
    private String username;

    /**
     * 用户密码.
     */
    private String password;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

    private Set<SysUserRole> userRoleSet = new HashSet<SysUserRole>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "usercode")
    public String getUsercode() {

        return usercode;
    }

    public void setUsercode(String usercode) {

        this.usercode = usercode;
    }

    @Column(name = "username")
    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    @Column(name = "create_time")
    public Date getCreateTime() {

        return createTime;
    }

    public void setCreateTime(Date createTime) {

        this.createTime = createTime;
    }

    @Column(name = "update_time")
    public Date getUpdateTime() {

        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {

        this.updateTime = updateTime;
    }

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="sys_user_id")
    @JsonIgnore
    public Set<SysUserRole> getUserRoleSet() {
        return userRoleSet;
    }

    public void setUserRoleSet(Set<SysUserRole> userRoleSet) {
        this.userRoleSet = userRoleSet;
    }
    
}
