package org.titans.bean.aris;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类.
 */
@Entity
@Table(name = "aris_assignment")
public class AssignmentBean {

    /**
     * 主键.
     */
    private String id;
    /**
     * 对象ID.
     */
    private String objdefid;
    /**
     * 模型id.
     */
    private String modelid;

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
    @Column(name = "obj_def_id", nullable = false, length = 16)
    public String getObjdefid() {
        return this.objdefid;
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
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param objdefid the objdefid to set
     */
    public void setObjdefid(String objdefid) {
        this.objdefid = objdefid;
    }

    /**
     * @param modelid the modelid to set
     */
    public void setModelid(String modelid) {
        this.modelid = modelid;
    }
}
