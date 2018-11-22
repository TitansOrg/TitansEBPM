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
 * 实体类.
 */
@Entity
@Table(name = "aris_definition")
public class DefinitionBean {

    /**
     * 主键.
     */
    private String id;

    /**
     * discriminator.
     */

    private Long discriminator;

    /**
     * 最后更新.
     */
    private BigDecimal lastupdated;

    /**
     * 全局GUID.
     */
    private String globalid;

    /**
     * 类型号.
     */
    private Long typenum;

    /**
     * 对应文件夹id.
     */
    private String groupid;

    /**
     * 来源对象.
     */
    private String fromobjdefid;

    /**
     * 指向对象.
     */
    private String toobjdefid;

    /**
     * 线.
     */
    private String link;

    /**
     * refglobalid.
     */
    private String refglobalid;

    /**
     * 数据.
     */
    private String data;

    /**
     * metafile.
     */
    private String metafile;

    /**
     * reorg.
     */
    private Long reorg;

    /**
     * subtypenum.
     */
    private Long subtypenum;

    /**
     * 符号类型号.
     */
    private Long defsymbolnum;

    /**
     * 符号GUID.
     */
    private String symbolguid;

    /**
     * lockowner.
     */
    private String lockowner;

    /**
     * 对象原厂特性集合.
     */
    private Set<DefinitionAttrBean> definitionAttrBeans = new HashSet<DefinitionAttrBean>(0);

    /**
     * 使用关系集合.
     */
    private Set<AssignmentBean> assignmentBeans = new HashSet<AssignmentBean>(0);

    /**
     * get方法.
     * @return 对应字段
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "objdefid")
    public Set<AssignmentBean> getAssignmentBeans() {
        return assignmentBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @OrderBy("attrtypenum asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentitemid")
    public Set<DefinitionAttrBean> getDefinitionAttrBeans() {
        return definitionAttrBeans;
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
    @Column(name = "discriminator", precision = 10, scale = 0)
    public Long getDiscriminator() {
        return this.discriminator;
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
    @Column(name = "group_id", length = 16)
    public String getGroupid() {
        return this.groupid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "link", length = 4000)
    public String getLink() {
        return this.link;
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
    @Column(name = "data")
    public String getData() {
        return this.data;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "meta_file")
    public String getMetafile() {
        return this.metafile;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "reorg", precision = 10, scale = 0)
    public Long getReorg() {
        return this.reorg;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "sub_type_num", precision = 10, scale = 0)
    public Long getSubtypenum() {
        return this.subtypenum;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "def_symbol_num", precision = 10, scale = 0)
    public Long getDefsymbolnum() {
        return this.defsymbolnum;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "symbol_guid", length = 36)
    public String getSymbolguid() {
        return this.symbolguid;
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
     * get方法.
     * @return 对应字段
     */
    @Column(name = "from_obj_def_id", length = 16)
    public String getFromobjdefid() {
        return fromobjdefid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "to_obj_def_id", length = 16)
    public String getToobjdefid() {
        return toobjdefid;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param discriminator the discriminator to set
     */
    public void setDiscriminator(Long discriminator) {
        this.discriminator = discriminator;
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
     * @param fromobjdefid the fromobjdefid to set
     */
    public void setFromobjdefid(String fromobjdefid) {
        this.fromobjdefid = fromobjdefid;
    }

    /**
     * @param toobjdefid the toobjdefid to set
     */
    public void setToobjdefid(String toobjdefid) {
        this.toobjdefid = toobjdefid;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @param refglobalid the refglobalid to set
     */
    public void setRefglobalid(String refglobalid) {
        this.refglobalid = refglobalid;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param metafile the metafile to set
     */
    public void setMetafile(String metafile) {
        this.metafile = metafile;
    }

    /**
     * @param reorg the reorg to set
     */
    public void setReorg(Long reorg) {
        this.reorg = reorg;
    }

    /**
     * @param subtypenum the subtypenum to set
     */
    public void setSubtypenum(Long subtypenum) {
        this.subtypenum = subtypenum;
    }

    /**
     * @param defsymbolnum the defsymbolnum to set
     */
    public void setDefsymbolnum(Long defsymbolnum) {
        this.defsymbolnum = defsymbolnum;
    }

    /**
     * @param symbolguid the symbolguid to set
     */
    public void setSymbolguid(String symbolguid) {
        this.symbolguid = symbolguid;
    }

    /**
     * @param lockowner the lockowner to set
     */
    public void setLockowner(String lockowner) {
        this.lockowner = lockowner;
    }

    /**
     * @param definitionAttrBeans the definitionAttrBeans to set
     */
    public void setDefinitionAttrBeans(Set<DefinitionAttrBean> definitionAttrBeans) {
        this.definitionAttrBeans = definitionAttrBeans;
    }

    /**
     * @param assignmentBeans the assignmentBeans to set
     */
    public void setAssignmentBeans(Set<AssignmentBean> assignmentBeans) {
        this.assignmentBeans = assignmentBeans;
    }

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
}