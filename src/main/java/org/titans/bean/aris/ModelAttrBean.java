package org.titans.bean.aris;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体.
 */
@Entity
@Table(name = "aris_model_attr")
public class ModelAttrBean {

    /**
     * id.
     */
    private String id;
    /**
     * 类型.
     */
    private Long discriminator;
    /**
     * 树形类型.
     */
    private Long attrtypenum;
    /**
     * GUID.
     */
    private String typeguid;
    /**
     * 语言ID.
     */
    private String languageid;
    /**
     * 外键.
     */
    private String parentitemid;
    /**
     * 内容.
     */
    private String plaintextfragment;
    /**
     * 内容.
     */
    private String plaintnffragment;
    /**
     * 内容.
     */
    private String styledtextfragment;
    /**
     * 内容.
     */
    private String plaintextclob;
    /**
     * 内容.
     */
    private String plaintnfclob;
    /**
     * 内容.
     */
    private String styledtextclob;
    /**
     * 长值.
     */
    private BigDecimal longvalue;
    /**
     * 数值.
     */
    private BigDecimal doublevalue;
    /**
     * 数值.
     */
    private String blobvalue;

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
    @Column(name = "attr_type_num", precision = 10, scale = 0)
    public Long getAttrtypenum() {
        return this.attrtypenum;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "type_guid", length = 36)
    public String getTypeguid() {
        return this.typeguid;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "language_id", nullable = false, length = 16)
    public String getLanguageid() {
        return this.languageid;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "parent_item_id", nullable = false, length = 16)
    public String getParentitemid() {
        return this.parentitemid;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "plain_text_fragment", length = 100)
    public String getPlaintextfragment() {
        return this.plaintextfragment;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "plain_tnf_fragment", length = 100)
    public String getPlaintnffragment() {
        return this.plaintnffragment;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "styled_text_fragment", length = 100)
    public String getStyledtextfragment() {
        return this.styledtextfragment;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "plain_text_clob")
    public String getPlaintextclob() {
        return this.plaintextclob;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "plain_tnf_clob")
    public String getPlaintnfclob() {
        return this.plaintnfclob;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "styled_text_clob")
    public String getStyledtextclob() {
        return this.styledtextclob;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "long_value", precision = 20, scale = 0)
    public BigDecimal getLongvalue() {
        return this.longvalue;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "double_value", precision = 22, scale = 0)
    public BigDecimal getDoublevalue() {
        return this.doublevalue;
    }


    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "blob_value")
    public String getBlobvalue() {
        return this.blobvalue;
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
     * @param attrtypenum the attrtypenum to set
     */
    public void setAttrtypenum(Long attrtypenum) {
        this.attrtypenum = attrtypenum;
    }

    /**
     * @param typeguid the typeguid to set
     */
    public void setTypeguid(String typeguid) {
        this.typeguid = typeguid;
    }

    /**
     * @param languageid the languageid to set
     */
    public void setLanguageid(String languageid) {
        this.languageid = languageid;
    }

    /**
     * @param parentitemid the parentitemid to set
     */
    public void setParentitemid(String parentitemid) {
        this.parentitemid = parentitemid;
    }

    /**
     * @param plaintextfragment the plaintextfragment to set
     */
    public void setPlaintextfragment(String plaintextfragment) {
        this.plaintextfragment = plaintextfragment;
    }

    /**
     * @param plaintnffragment the plaintnffragment to set
     */
    public void setPlaintnffragment(String plaintnffragment) {
        this.plaintnffragment = plaintnffragment;
    }

    /**
     * @param styledtextfragment the styledtextfragment to set
     */
    public void setStyledtextfragment(String styledtextfragment) {
        this.styledtextfragment = styledtextfragment;
    }

    /**
     * @param plaintextclob the plaintextclob to set
     */
    public void setPlaintextclob(String plaintextclob) {
        this.plaintextclob = plaintextclob;
    }

    /**
     * @param plaintnfclob the plaintnfclob to set
     */
    public void setPlaintnfclob(String plaintnfclob) {
        this.plaintnfclob = plaintnfclob;
    }

    /**
     * @param styledtextclob the styledtextclob to set
     */
    public void setStyledtextclob(String styledtextclob) {
        this.styledtextclob = styledtextclob;
    }

    /**
     * @param longvalue the longvalue to set
     */
    public void setLongvalue(BigDecimal longvalue) {
        this.longvalue = longvalue;
    }

    /**
     * @param doublevalue the doublevalue to set
     */
    public void setDoublevalue(BigDecimal doublevalue) {
        this.doublevalue = doublevalue;
    }

    /**
     * @param blobvalue the blobvalue to set
     */
    public void setBlobvalue(String blobvalue) {
        this.blobvalue = blobvalue;
    }

}
