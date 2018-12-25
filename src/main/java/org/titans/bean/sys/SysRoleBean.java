package org.titans.bean.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
     * 创建时间.
     */
    private Date createTime;

    /**
     * 更新时间.
     */
    private Date updateTime;


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
}
