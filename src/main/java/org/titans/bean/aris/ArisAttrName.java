package org.titans.bean.aris;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类（所有特性）.
 */
@Entity
@Table(name = "aris_attr_name")
public class ArisAttrName {

    @Column(name = "attribute_index", nullable = true, length = 10)
    private Integer attributeIndex;

    @Column(name = "attribute_type", nullable = true, length = 10)
    private Integer attributeType;

    @Column(name = "attribute_name", nullable = true, length = 4000)
    private String attributeName;

    @Column(name = "belong_type", nullable = true, length = 100)
    private String belongType;

    @Column(name = "symbol_type", nullable = true, length = 10)
    private Integer symbolType;

    @Column(name = "orig_attribute_type", nullable = true, length = 10)
    private Integer origAttributeType;

    @Column(name = "attribute_typeguid", nullable = true, length = 36)
    private String attributeTypeguid;
    @Id   
    @Column(name = "attribute_id", unique = true, nullable = false, length = 10)
    private Integer attributeId;

    @Column(name = "attribute_key", nullable = true, length = 100)
    private String attributeKey;

    /**
     * @return the attributeIndex
     */
    public Integer getAttributeIndex() {
        return attributeIndex;
    }

    /**
     * @param attributeIndex the attributeIndex to set
     */
    public void setAttributeIndex(Integer attributeIndex) {
        this.attributeIndex = attributeIndex;
    }

    /**
     * @return the attributeType
     */
    public Integer getAttributeType() {
        return attributeType;
    }

    /**
     * @param attributeType the attributeType to set
     */
    public void setAttributeType(Integer attributeType) {
        this.attributeType = attributeType;
    }

    /**
     * @return the attributeName
     */
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * @param attributeName the attributeName to set
     */
    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    /**
     * @return the belongType
     */
    public String getBelongType() {
        return belongType;
    }

    /**
     * @param belongType the belongType to set
     */
    public void setBelongType(String belongType) {
        this.belongType = belongType;
    }

    /**
     * @return the symbolType
     */
    public Integer getSymbolType() {
        return symbolType;
    }

    /**
     * @param symbolType the symbolType to set
     */
    public void setSymbolType(Integer symbolType) {
        this.symbolType = symbolType;
    }

    /**
     * @return the origAttributeType
     */
    public Integer getOrigAttributeType() {
        return origAttributeType;
    }

    /**
     * @param origAttributeType the origAttributeType to set
     */
    public void setOrigAttributeType(Integer origAttributeType) {
        this.origAttributeType = origAttributeType;
    }

    /**
     * @return the attributeTypeguid
     */
    public String getAttributeTypeguid() {
        return attributeTypeguid;
    }

    /**
     * @param attributeTypeguid the attributeTypeguid to set
     */
    public void setAttributeTypeguid(String attributeTypeguid) {
        this.attributeTypeguid = attributeTypeguid;
    }

    /**
     * @return the attributeId
     */
    public Integer getAttributeId() {
        return attributeId;
    }

    /**
     * @param attributeId the attributeId to set
     */
    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    /**
     * @return the attributeKey
     */
    public String getAttributeKey() {
        return attributeKey;
    }

    /**
     * @param attributeKey the attributeKey to set
     */
    public void setAttributeKey(String attributeKey) {
        this.attributeKey = attributeKey;
    }

}
