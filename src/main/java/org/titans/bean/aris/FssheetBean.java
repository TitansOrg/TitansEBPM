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
@Table(name = "aris_fssheet")
public class FssheetBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 全局GIID.
     */
    private String globalid;
    /**
     * 是否默认.
     */
    private Boolean isdefault;
    /**
     * 集合类.
     */
    private Set<FsnodeBean> fsnodeBeans = new HashSet<FsnodeBean>(0);
    /**
     * 特性类.
     */
    private Set<FssheetAttrBean> fssheetAttrBeans = new HashSet<FssheetAttrBean>(0);


    /**
     * get方法.
     * @return 对应字段
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "fssheetid")
    public Set<FsnodeBean> getFsnodeBeans() {
        return fsnodeBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentitemid")
    public Set<FssheetAttrBean> getFssheetAttrBeans() {
        return fssheetAttrBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 16)
    public String getId() {
        return this.id;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "global_id", unique = true, length = 36)
    public String getGlobalid() {
        return this.globalid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "is_default", precision = 1, scale = 0)
    public Boolean getIsdefault() {
        return this.isdefault;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param globalid the globalid to set
     */
    public void setGlobalid(String globalid) {
        this.globalid = globalid;
    }

    /**
     * @param isdefault the isdefault to set
     */
    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * @param fsnodeBeans the fsnodeBeans to set
     */
    public void setFsnodeBeans(Set<FsnodeBean> fsnodeBeans) {
        this.fsnodeBeans = fsnodeBeans;
    }

    /**
     * @param fssheetAttrBeans the fssheetAttrBeans to set
     */
    public void setFssheetAttrBeans(Set<FssheetAttrBean> fssheetAttrBeans) {
        this.fssheetAttrBeans = fssheetAttrBeans;
    }

}