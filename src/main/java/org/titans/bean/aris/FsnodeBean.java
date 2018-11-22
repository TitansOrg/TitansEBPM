package org.titans.bean.aris;

import java.lang.reflect.Field;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 实体Bean.
 */
@Entity
@Table(name = "aris_fsnode")
public class FsnodeBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 字体编号.
     */
    private String fssheetid;
    /**
     * 语言.
     */
    private String languageid;
    /**
     * 字体高度.
     */
    private Long fontHeight;
    /**
     * 字体宽度.
     */
    private Long fontWidth;
    /**
     * 字体驱动.
     */
    private Long fontEscapement;
    /**
     * font方向.
     */
    private Long fontOrientation;
    /**
     * 字体体重.
     */
    private Long fontWeight;
    /**
     * 字体方言.
     */
    private Short fontItalic;
    /**
     * 下划线.
     */
    private Short fontUnderline;
    /**
     * fontStrikeout.
     */
    private Short fontStrikeout;
    /**
     * 字符集.
     */
    private Short fontCharset;
    /**
     * fontOutprec.
     */
    private Short fontOutprec;
    /**
     * fontClipprec.
     */
    private Short fontClipprec;
    /**
     * fontQuality.
     */
    private Short fontQuality;
    /**
     * fontPitchandfam.
     */
    private Short fontPitchandfam;
    /**
     * 字体颜色.
     */
    private Long fontColor;
    /**
     * fontFacename.
     */
    private String fontFacename;

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
    @Column(name = "fs_sheet_id", nullable = false, length = 16)
    public String getFssheetid() {
        return this.fssheetid;
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
    @Column(name = "font_height", precision = 10, scale = 0)
    public Long getFontHeight() {
        return this.fontHeight;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_width", precision = 10, scale = 0)
    public Long getFontWidth() {
        return this.fontWidth;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_escapement", precision = 10, scale = 0)
    public Long getFontEscapement() {
        return this.fontEscapement;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_orientation", precision = 10, scale = 0)
    public Long getFontOrientation() {
        return this.fontOrientation;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_weight", precision = 10, scale = 0)
    public Long getFontWeight() {
        return this.fontWeight;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_italic", precision = 3, scale = 0)
    public Short getFontItalic() {
        return this.fontItalic;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_underline", precision = 3, scale = 0)
    public Short getFontUnderline() {
        return this.fontUnderline;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_strikeout", precision = 3, scale = 0)
    public Short getFontStrikeout() {
        return this.fontStrikeout;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_charset", precision = 3, scale = 0)
    public Short getFontCharset() {
        return this.fontCharset;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_outprec", precision = 3, scale = 0)
    public Short getFontOutprec() {
        return this.fontOutprec;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_clipprec", precision = 3, scale = 0)
    public Short getFontClipprec() {
        return this.fontClipprec;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_quality", precision = 3, scale = 0)
    public Short getFontQuality() {
        return this.fontQuality;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_pitchandfam", precision = 3, scale = 0)
    public Short getFontPitchandfam() {
        return this.fontPitchandfam;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_color", precision = 10, scale = 0)
    public Long getFontColor() {
        return this.fontColor;
    }

    /**
     * get方法.
     * @return 对应字段
     */
    @Column(name = "font_facename", length = 100)
    public String getFontFacename() {
        return this.fontFacename;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param fssheetid the fssheetid to set
     */
    public void setFssheetid(String fssheetid) {
        this.fssheetid = fssheetid;
    }

    /**
     * @param languageid the languageid to set
     */
    public void setLanguageid(String languageid) {
        this.languageid = languageid;
    }

    /**
     * @param fontHeight the fontHeight to set
     */
    public void setFontHeight(Long fontHeight) {
        this.fontHeight = fontHeight;
    }

    /**
     * @param fontWidth the fontWidth to set
     */
    public void setFontWidth(Long fontWidth) {
        this.fontWidth = fontWidth;
    }

    /**
     * @param fontEscapement the fontEscapement to set
     */
    public void setFontEscapement(Long fontEscapement) {
        this.fontEscapement = fontEscapement;
    }

    /**
     * @param fontOrientation the fontOrientation to set
     */
    public void setFontOrientation(Long fontOrientation) {
        this.fontOrientation = fontOrientation;
    }

    /**
     * @param fontWeight the fontWeight to set
     */
    public void setFontWeight(Long fontWeight) {
        this.fontWeight = fontWeight;
    }

    /**
     * @param fontItalic the fontItalic to set
     */
    public void setFontItalic(Short fontItalic) {
        this.fontItalic = fontItalic;
    }

    /**
     * @param fontUnderline the fontUnderline to set
     */
    public void setFontUnderline(Short fontUnderline) {
        this.fontUnderline = fontUnderline;
    }

    /**
     * @param fontStrikeout the fontStrikeout to set
     */
    public void setFontStrikeout(Short fontStrikeout) {
        this.fontStrikeout = fontStrikeout;
    }

    /**
     * @param fontCharset the fontCharset to set
     */
    public void setFontCharset(Short fontCharset) {
        this.fontCharset = fontCharset;
    }

    /**
     * @param fontOutprec the fontOutprec to set
     */
    public void setFontOutprec(Short fontOutprec) {
        this.fontOutprec = fontOutprec;
    }

    /**
     * @param fontClipprec the fontClipprec to set
     */
    public void setFontClipprec(Short fontClipprec) {
        this.fontClipprec = fontClipprec;
    }

    /**
     * @param fontQuality the fontQuality to set
     */
    public void setFontQuality(Short fontQuality) {
        this.fontQuality = fontQuality;
    }

    /**
     * @param fontPitchandfam the fontPitchandfam to set
     */
    public void setFontPitchandfam(Short fontPitchandfam) {
        this.fontPitchandfam = fontPitchandfam;
    }

    /**
     * @param fontColor the fontColor to set
     */
    public void setFontColor(Long fontColor) {
        this.fontColor = fontColor;
    }

    /**
     * @param fontFacename the fontFacename to set
     */
    public void setFontFacename(String fontFacename) {
        this.fontFacename = fontFacename;
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