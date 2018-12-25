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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 部门管理表.
 */
@Entity
@Table(name = "sys_dept")
public class SysDeptBean {

    /**
     * 表主键.
     */
    private Long id;

    /**
     * 部门编号.
     */
    private String code;

    /**
     * 部门名称.
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

    /**
     * 拥有岗位.
     */
    private List<SysPostBean> sysPostList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Column(name = "code")
    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
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

    public void setSysPostList(List<SysPostBean> sysPostList) {
        this.sysPostList = sysPostList;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "deptId")
    public List<SysPostBean> getSysPostList() {

        return sysPostList;
    }
    
}
