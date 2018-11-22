package org.titans.bean.aris;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类.
 */
@Entity
@Table(name = "aris_attrocc")
public class AttrOccBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 模型id.
     */
    private String modelid;
    /**
     * 关联关系id.
     */
    private String occid;
    /**
     * 字体id.
     */
    private String fssheetid;
    /**
     * 特性类型编号.
     */
    private Long attrtypenum;
    /**
     * 类型GUID.
     */
    private String typeguid;
    /**
     * 标示符.
     */
    private Long flags;
    /**
     * 坐标.
     */
    private Integer port;
    /**
     * 使用关系.
     */
    private Integer alignment;
    /**
     * 排序.
     */
    private Integer ordernum;
    /**
     * x坐标.
     */
    private Long xoffset;
    /**
     * y坐标.
     */
    private Long yoffset;
    /**
     * 宽度.
     */
    private Long sizeX;
    /**
     * 高度.
     */
    private Long sizeY;
    /**
     * rotation.
     */
    private Integer rotation;

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
    @Column(name = "model_id", nullable = false, length = 16)
    public String getModelid() {
        return this.modelid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "occ_id", nullable = false, length = 16)
    public String getOccid() {
        return this.occid;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "fs_sheet_id", length = 16)
    public String getFssheetid() {
        return this.fssheetid;
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
    @Column(name = "flags", precision = 10, scale = 0)
    public Long getFlags() {
        return this.flags;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "port", precision = 5, scale = 0)
    public Integer getPort() {
        return this.port;
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
    @Column(name = "order_num", precision = 5, scale = 0)
    public Integer getOrdernum() {
        return this.ordernum;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "x_offset", precision = 10, scale = 0)
    public Long getXoffset() {
        return this.xoffset;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "y_offset", precision = 10, scale = 0)
    public Long getYoffset() {
        return this.yoffset;
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
    @Column(name = "rotation", precision = 5, scale = 0)
    public Integer getRotation() {
        return this.rotation;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param modelid the modelid to set
     */
    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    /**
     * @param occid the occid to set
     */
    public void setOccid(String occid) {
        this.occid = occid;
    }

    /**
     * @param fssheetid the fssheetid to set
     */
    public void setFssheetid(String fssheetid) {
        this.fssheetid = fssheetid;
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
     * @param flags the flags to set
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     * @param port the port to set
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * @param alignment the alignment to set
     */
    public void setAlignment(Integer alignment) {
        this.alignment = alignment;
    }

    /**
     * @param ordernum the ordernum to set
     */
    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * @param xoffset the xoffset to set
     */
    public void setXoffset(Long xoffset) {
        this.xoffset = xoffset;
    }

    /**
     * @param yoffset the yoffset to set
     */
    public void setYoffset(Long yoffset) {
        this.yoffset = yoffset;
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
     * @param rotation the rotation to set
     */
    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

}