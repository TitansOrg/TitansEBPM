package org.titans.bean.aris;

import java.lang.reflect.Field;
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
 * 实体.
 */
@Entity
@Table(name = "aris_lane")
public class LaneBean {

    /**
     * ID.
     */
    private String id;
    /**
     * 模型ID.
     */
    private String modelid;
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
     * 刷样式.
     */
    private Long brushType;
    /**
     * 刷颜色.
     */
    private Long brushColor2;
    /**
     * 刷颜色.
     */
    private Long brushColor;
    /**
     * 起始线.
     */
    private Long startborder;
    /**
     * 终止线.
     */
    private Long endborder;
    /**
     * 类型号.
     */
    private Long typenum;
    /**
     * 方向.
     */
    private Long orientation;
    /**
     * 全局ID.
     */
    private String globalid;
    /**
     * 特性类集合.
     */
    private Set<LaneAttrBean> laneAttrBeans = new HashSet<LaneAttrBean>(0);

    /**
     * 重写.
     * @return 字符串
     */
    @Override
    public String toString() {

        String str = "";
        try {

            Field [] f = this.getClass().getDeclaredFields();
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
    @Column(name = "start_border", precision = 10, scale = 0)
    public Long getStartborder() {
        return this.startborder;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "end_border", precision = 10, scale = 0)
    public Long getEndborder() {
        return this.endborder;
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
    @Column(name = "orientation", precision = 10, scale = 0)
    public Long getOrientation() {
        return this.orientation;
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
    @OrderBy("attrtypenum asc")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "parentitemid")
    public Set<LaneAttrBean> getLaneAttrBeans() {
        return this.laneAttrBeans;
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
     * @param startborder the startborder to set
     */
    public void setStartborder(Long startborder) {
        this.startborder = startborder;
    }

    /**
     * @param endborder the endborder to set
     */
    public void setEndborder(Long endborder) {
        this.endborder = endborder;
    }

    /**
     * @param typenum the typenum to set
     */
    public void setTypenum(Long typenum) {
        this.typenum = typenum;
    }

    /**
     * @param orientation the orientation to set
     */
    public void setOrientation(Long orientation) {
        this.orientation = orientation;
    }

    /**
     * @param globalid the globalid to set
     */
    public void setGlobalid(String globalid) {
        this.globalid = globalid;
    }

    /**
     * @param laneAttrBeans the laneAttrBeans to set
     */
    public void setLaneAttrBeans(Set<LaneAttrBean> laneAttrBeans) {
        this.laneAttrBeans = laneAttrBeans;
    }

}