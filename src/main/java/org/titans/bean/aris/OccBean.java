package org.titans.bean.aris;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 实体.
 */
@Entity
@Table(name = "aris_occ")
public class OccBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * discriminator.
     */
    private Long discriminator;
    /**
     * 模型ID.
     */
    private String modelid;
    /**
     * unionid.
     */
    private String unionid;
    /**
     * 排序.
     */
    private Long zorder;
    /**
     * flags.
     */
    private Long flags;
    /**
     * hints.
     */
    private Long hints;
    /**
     * X坐标.
     */
    private Long positionX;
    /**
     * Y坐标.
     */
    private Long positionY;
    /**
     * sizeX.
     */
    private Long sizeX;
    /**
     * sizeY.
     */
    private Long sizeY;
    /**
     * 类型号.
     */
    private Long typenum;
    /**
     * 符号GUID.
     */
    private String symbolguid;
    /**
     * 宽度.
     */
    private Long penWidth;
    /**
     * 样式.
     */
    private Long penStyle;
    /**
     * 颜色.
     */
    private Long penColor;
    /**
     * 类型.
     */
    private Long brushType;
    /**
     * 颜色.
     */
    private Long brushColor2;
    /**
     * 颜色.
     */
    private Long brushColor;
    /**
     * alignment.
     */
    private Integer alignment;
    /**
     * externalguid.
     */
    private String externalguid;
    /**
     * seqnum.
     */
    private Long seqnum;
    /**
     * 对象来源.
     */
    private String fromobjoccid;
    /**
     * 对象去向.
     */
    private String toobjoccid;
    /**
     * 点.
     */
    private String points;
    /**
     * 数据.
     */
    private String data;
    /**
     * bizoccid.
     */
    private String bizoccid;
    /**
     * srcarrow.
     */
    private Long srcarrow;
    /**
     * tgtarrow.
     */
    private Long tgtarrow;
    /**
     * 对象实体.
     */
    private DefinitionBean definitionBean;

    /**
     * 特性集合.
     */
    private Set<AttrOccBean> attrOccBeans = new HashSet<AttrOccBean>(0);

    /**
     * get方法.
     * @return 对应字段
     */
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "occid")
    public Set<AttrOccBean> getAttrOccBeans() {
        return attrOccBeans;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "definition_id")
    public DefinitionBean getDefinitionBean() {
        return definitionBean;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Id
    @Column(name = "id", unique = true, nullable = false, length = 15)
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
    @Column(name = "model_id", nullable = false, length = 15)
    public String getModelid() {
        return this.modelid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "z_order", precision = 10, scale = 0)
    public Long getZorder() {
        return this.zorder;
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
    @Column(name = "hints", precision = 10, scale = 0)
    public Long getHints() {
        return this.hints;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "position_x", precision = 10, scale = 0)
    public Long getPositionX() {
        return this.positionX;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "position_y", precision = 10, scale = 0)
    public Long getPositionY() {
        return this.positionY;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "size_x", precision = 10, scale = 0)
    public Long getSizeX() {
        return this.sizeX;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "size_y", precision = 10, scale = 0)
    public Long getSizeY() {
        return this.sizeY;
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
    @Column(name = "symbol_guid", length = 36)
    public String getSymbolguid() {
        return this.symbolguid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "pen_width", precision = 10, scale = 0)
    public Long getPenWidth() {
        return this.penWidth;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "pen_style", precision = 10, scale = 0)
    public Long getPenStyle() {
        return this.penStyle;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "pen_color", precision = 10, scale = 0)
    public Long getPenColor() {
        return this.penColor;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "brush_type", precision = 10, scale = 0)
    public Long getBrushType() {
        return this.brushType;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "brush_color2", precision = 10, scale = 0)
    public Long getBrushColor2() {
        return this.brushColor2;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "brush_color", precision = 10, scale = 0)
    public Long getBrushColor() {
        return this.brushColor;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "alignment", precision = 5, scale = 0)
    public Integer getAlignment() {
        return this.alignment;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "external_guid", length = 36)
    public String getExternalguid() {
        return this.externalguid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "seq_num", precision = 10, scale = 0)
    public Long getSeqnum() {
        return this.seqnum;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "points")
    public String getPoints() {
        return this.points;
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
    @Column(name = "src_arrow", precision = 10, scale = 0)
    public Long getSrcarrow() {
        return this.srcarrow;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "tgt_arrow", precision = 10, scale = 0)
    public Long getTgtarrow() {
        return this.tgtarrow;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "union_id", length = 15)
    public String getUnionid() {
        return unionid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "from_obj_occ_id", length = 15)
    public String getFromobjoccid() {
        return fromobjoccid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "to_obj_occ_id", length = 15)
    public String getToobjoccid() {
        return toobjoccid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "biz_occ_id", length = 15)
    public String getBizoccid() {
        return bizoccid;
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
     * @param modelid the modelid to set
     */
    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    /**
     * @param unionid the unionid to set
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    /**
     * @param zorder the zorder to set
     */
    public void setZorder(Long zorder) {
        this.zorder = zorder;
    }

    /**
     * @param flags the flags to set
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     * @param hints the hints to set
     */
    public void setHints(Long hints) {
        this.hints = hints;
    }

    /**
     * @param positionX the positionX to set
     */
    public void setPositionX(Long positionX) {
        this.positionX = positionX;
    }

    /**
     * @param positionY the positionY to set
     */
    public void setPositionY(Long positionY) {
        this.positionY = positionY;
    }

    /**
     * @param sizeX the sizeX to set
     */
    public void setSizeX(Long sizeX) {
        this.sizeX = sizeX;
    }

    /**
     * @param sizeY the sizeY to set
     */
    public void setSizeY(Long sizeY) {
        this.sizeY = sizeY;
    }

    /**
     * @param typenum the typenum to set
     */
    public void setTypenum(Long typenum) {
        this.typenum = typenum;
    }

    /**
     * @param symbolguid the symbolguid to set
     */
    public void setSymbolguid(String symbolguid) {
        this.symbolguid = symbolguid;
    }

    /**
     * @param penWidth the penWidth to set
     */
    public void setPenWidth(Long penWidth) {
        this.penWidth = penWidth;
    }

    /**
     * @param penStyle the penStyle to set
     */
    public void setPenStyle(Long penStyle) {
        this.penStyle = penStyle;
    }

    /**
     * @param penColor the penColor to set
     */
    public void setPenColor(Long penColor) {
        this.penColor = penColor;
    }

    /**
     * @param brushType the brushType to set
     */
    public void setBrushType(Long brushType) {
        this.brushType = brushType;
    }

    /**
     * @param brushColor2 the brushColor2 to set
     */
    public void setBrushColor2(Long brushColor2) {
        this.brushColor2 = brushColor2;
    }

    /**
     * @param brushColor the brushColor to set
     */
    public void setBrushColor(Long brushColor) {
        this.brushColor = brushColor;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(Integer alignment) {
        this.alignment = alignment;
    }

    /**
     * @param externalguid the externalguid to set
     */
    public void setExternalguid(String externalguid) {
        this.externalguid = externalguid;
    }

    /**
     * @param seqnum the seqnum to set
     */
    public void setSeqnum(Long seqnum) {
        this.seqnum = seqnum;
    }

    /**
     * @param fromobjoccid the fromobjoccid to set
     */
    public void setFromobjoccid(String fromobjoccid) {
        this.fromobjoccid = fromobjoccid;
    }

    /**
     * @param toobjoccid the toobjoccid to set
     */
    public void setToobjoccid(String toobjoccid) {
        this.toobjoccid = toobjoccid;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(String points) {
        this.points = points;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param bizoccid the bizoccid to set
     */
    public void setBizoccid(String bizoccid) {
        this.bizoccid = bizoccid;
    }

    /**
     * @param srcarrow the srcarrow to set
     */
    public void setSrcarrow(Long srcarrow) {
        this.srcarrow = srcarrow;
    }

    /**
     * @param tgtarrow the tgtarrow to set
     */
    public void setTgtarrow(Long tgtarrow) {
        this.tgtarrow = tgtarrow;
    }

    /**
     * @param definitionBean the definitionBean to set
     */
    public void setDefinitionBean(DefinitionBean definitionBean) {
        this.definitionBean = definitionBean;
    }

    /**
     * @param attrOccBeans the attrOccBeans to set
     */
    public void setAttrOccBeans(Set<AttrOccBean> attrOccBeans) {
        this.attrOccBeans = attrOccBeans;
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