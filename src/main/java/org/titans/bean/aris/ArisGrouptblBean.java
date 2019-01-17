package org.titans.bean.aris;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 实体类.
 */
@Entity
@Table(name = "aris_grouptbl")
public class ArisGrouptblBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 外键.
     */
    private String parentgroupid;
    /**
     * 全局ID.
     */
    private String globalId;
    /**
     * 最后更改.
     */
    private Long lastUpdated;
    /**
     * 特性明细表集合.
     */
    private Set<ArisGroupAttrBean> arisGroupAttrBeans = new HashSet<ArisGroupAttrBean>(0);

    /**
     * get方法.
     * @return 对应字段
     */
    @Id
    @Column(name = "ID", unique = true, nullable = false, length = 16)
    public String getId() {
        return id;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "parent_group_id", nullable = true, length = 16)
    public String getParentgroupid() {
        return parentgroupid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "global_id", nullable = true, length = 36)
    public String getGlobalId() {
        return globalId;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "last_updated", nullable = true, length = 20)
    public Long getLastUpdated() {
        return lastUpdated;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentitemid")
    public Set<ArisGroupAttrBean> getArisGroupAttrBeans() {
        return arisGroupAttrBeans;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param parentgroupid the parentgroupid to set
     */
    public void setParentgroupid(String parentgroupid) {
        this.parentgroupid = parentgroupid;
    }

    /**
     * @param globalId the globalId to set
     */
    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @param arisGroupAttrBeans the arisGroupAttrBeans to set
     */
    public void setArisGroupAttrBeans(Set<ArisGroupAttrBean> arisGroupAttrBeans) {
        this.arisGroupAttrBeans = arisGroupAttrBeans;
    }

}
