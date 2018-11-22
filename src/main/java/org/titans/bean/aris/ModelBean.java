package org.titans.bean.aris;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 描述:ARIS_MODEL实体类 .
 */
@Entity
@Table(name = "aris_model")
public class ModelBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 最后更新日期.
     */
    private BigDecimal lastupdated;
    /**
     * 全局ID.
     */
    private String globalid;
    /**
     * 类型号.
     */
    private Long typenum;
    /**
     * 文件夹ID.
     */
    private String groupid;
    /**
     * 标示符.
     */
    private Long flags;
    /**
     * 比例.
     */
    private Integer scale;
    /**
     * 顺序.
     */
    private Long maxzorder;
    /**
     * 打印缩放.
     */
    private Integer printscale;
    /**
     * 单元格大小.
     */
    private Integer gridsize;
    /**
     * 背景色.
     */
    private Long backgroundcolor;
    /**
     * attrhandling.
     */
    private Integer attrhandling;
    /**
     * refglobalid.
     */
    private String refglobalid;
    /**
     * bizmodelid.
     */
    private String bizmodelid;
    /**
     * arcradius.
     */
    private Long arcradius;
    /**
     * curveradius.
     */
    private Long curveradius;
    /**
     * typguid.
     */
    private String typguid;
    /**
     * templateguid.
     */
    private String templateguid;
    /**
     * lockowner.
     */
    private String lockowner;
    /**
     * 模型特定集合.
     */
    private Set<ModelAttrBean> modelAttrBeans = new HashSet<ModelAttrBean>(0);
    /**
     * 泳道集合.
     */
    private Set<LaneBean> laneBeans = new HashSet<LaneBean>(0);
    /**
     * 关联关系集合.
     */
    private Set<OccBean> occBeans = new HashSet<OccBean>(0);
//    private Set<AttrOccBean> attrOccBeans = new HashSet<AttrOccBean>(0);

    /**
     * 重写.
     * @return 字符串
     */
    @Override
    public String toString() {

        String str = "";
        try {

            Field[] f = this.getClass().getDeclaredFields();
            for (int i = 0; i < f.length; i++) {

                f[i].setAccessible(true);
                str = str + f[i].getName() + "=[" + f[i].get(this) + "]\n";
            }
        } catch (Exception e) {

            e.printStackTrace();
            str = e.getMessage();
        }
        return str;
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modelid")
//    public Set<AttrOccBean> getAttrOccBeans() {
//        return attrOccBeans;
//    }
//
//    public void setAttrOccBeans(Set<AttrOccBean> attrOccBeans) {
//        this.attrOccBeans = attrOccBeans;
//    }


    /**
     * get方法.
     * @return 对应字段
     */
    @OrderBy("zorder asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modelid")
    public Set<OccBean> getOccBeans() {
        return occBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @OrderBy("attrtypenum asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentitemid")
    public Set<ModelAttrBean> getModelAttrBeans() {
        return modelAttrBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @OrderBy("startborder asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "modelid")
    public Set<LaneBean> getLaneBeans() {
        return laneBeans;
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
    @Column(name = "last_updated", precision = 20, scale = 0)
    public BigDecimal getLastupdated() {
        return this.lastupdated;
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
    @Column(name = "type_num", precision = 10, scale = 0)
    public Long getTypenum() {
        return this.typenum;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "group_id", nullable = false, length = 16)
    public String getGroupid() {
        return this.groupid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "flags", precision = 10, scale = 0)
    public Long getFlags() {
        return this.flags;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "scale", precision = 5, scale = 0)
    public Integer getScale() {
        return this.scale;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "max_z_order", precision = 10, scale = 0)
    public Long getMaxzorder() {
        return this.maxzorder;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "print_scale", precision = 5, scale = 0)
    public Integer getPrintscale() {
        return this.printscale;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "grid_size", precision = 5, scale = 0)
    public Integer getGridsize() {
        return this.gridsize;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "background_color", precision = 10, scale = 0)
    public Long getBackgroundcolor() {
        return this.backgroundcolor;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "attr_handling", precision = 5, scale = 0)
    public Integer getAttrhandling() {
        return this.attrhandling;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "ref_global_id", length = 36)
    public String getRefglobalid() {
        return this.refglobalid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "biz_model_id", length = 16)
    public String getBizmodelid() {
        return bizmodelid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "arc_radius", precision = 10, scale = 0)
    public Long getArcradius() {
        return this.arcradius;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "curve_radius", precision = 10, scale = 0)
    public Long getCurveradius() {
        return this.curveradius;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "typ_guid", length = 36)
    public String getTypguid() {
        return this.typguid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "template_guid", length = 36)
    public String getTemplateguid() {
        return this.templateguid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "lock_owner", length = 16)
    public String getLockowner() {
        return this.lockowner;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param lastupdated the lastupdated to set
     */
    public void setLastupdated(BigDecimal lastupdated) {
        this.lastupdated = lastupdated;
    }

    /**
     * @param globalid the globalid to set
     */
    public void setGlobalid(String globalid) {
        this.globalid = globalid;
    }

    /**
     * @param typenum the typenum to set
     */
    public void setTypenum(Long typenum) {
        this.typenum = typenum;
    }

    /**
     * @param groupid the groupid to set
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     * @param scale the scale to set
     */
    public void setScale(Integer scale) {
        this.scale = scale;
    }

    /**
     * @param maxzorder the maxzorder to set
     */
    public void setMaxzorder(Long maxzorder) {
        this.maxzorder = maxzorder;
    }

    /**
     * @param printscale the printscale to set
     */
    public void setPrintscale(Integer printscale) {
        this.printscale = printscale;
    }

    /**
     * @param gridsize the gridsize to set
     */
    public void setGridsize(Integer gridsize) {
        this.gridsize = gridsize;
    }

    /**
     * @param backgroundcolor the backgroundcolor to set
     */
    public void setBackgroundcolor(Long backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    /**
     * @param attrhandling the attrhandling to set
     */
    public void setAttrhandling(Integer attrhandling) {
        this.attrhandling = attrhandling;
    }

    /**
     * @param refglobalid the refglobalid to set
     */
    public void setRefglobalid(String refglobalid) {
        this.refglobalid = refglobalid;
    }

    /**
     * @param bizmodelid the bizmodelid to set
     */
    public void setBizmodelid(String bizmodelid) {
        this.bizmodelid = bizmodelid;
    }

    /**
     * @param arcradius the arcradius to set
     */
    public void setArcradius(Long arcradius) {
        this.arcradius = arcradius;
    }

    /**
     * @param curveradius the curveradius to set
     */
    public void setCurveradius(Long curveradius) {
        this.curveradius = curveradius;
    }

    /**
     * @param typguid the typguid to set
     */
    public void setTypguid(String typguid) {
        this.typguid = typguid;
    }

    /**
     * @param templateguid the templateguid to set
     */
    public void setTemplateguid(String templateguid) {
        this.templateguid = templateguid;
    }

    /**
     * @param lockowner the lockowner to set
     */
    public void setLockowner(String lockowner) {
        this.lockowner = lockowner;
    }

    /**
     * @param modelAttrBeans the modelAttrBeans to set
     */
    public void setModelAttrBeans(Set<ModelAttrBean> modelAttrBeans) {
        this.modelAttrBeans = modelAttrBeans;
    }

    /**
     * @param laneBeans the laneBeans to set
     */
    public void setLaneBeans(Set<LaneBean> laneBeans) {
        this.laneBeans = laneBeans;
    }

    /**
     * @param occBeans the occBeans to set
     */
    public void setOccBeans(Set<OccBean> occBeans) {
        this.occBeans = occBeans;
    }
}