package org.titans.bean.sys;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色信息表.
 */
@Entity
@Table(name = "sys_role")
public class SysRoleBean {

    /**
     * 表主键.
     */
    private Long id;

    /**
     * 角色名称.
     */
    private String name;

    /**
     * 所属部门ID.
     */
    private SysDeptBean sysDept;

    /**
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;

    private List<SysUserBean> users = new ArrayList<>();

    @ManyToMany(targetEntity = SysUserBean.class, fetch = FetchType.LAZY)
    @JoinTable(name="sys_user_role",
        joinColumns={@JoinColumn(name="role_id",referencedColumnName="id")},
        inverseJoinColumns={@JoinColumn(name="user_id",referencedColumnName="id")}
    )
    public List<SysUserBean> getUsers() {
        return users;
    }

    public void setUsers(List<SysUserBean> users) {
        this.users = users;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "name")
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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

    @ManyToOne(cascade = CascadeType.MERGE, fetch=FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    public SysDeptBean getSysDept() {

        return sysDept;
    }

    public void setSysDept(SysDeptBean sysDept) {

        this.sysDept = sysDept;
    }
}
