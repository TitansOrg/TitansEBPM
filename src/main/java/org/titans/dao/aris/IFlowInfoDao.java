package org.titans.dao.aris;

import java.util.List;
import java.util.Map;

import org.titans.bean.aris.ArisGrouptblBean;
import org.titans.bean.aris.ModelBean;

/**
 * ARIS系统数据同步服务端持久层接口.
 */
public interface IFlowInfoDao {

    /**
     * 查询流程管理平台中指定的模型信息.
     * @param modelId 模型ID
     * @return 模型对象
     */
    ModelBean queryEbpmModelBean(String modelId);
    
    
    /**
     * 根据模型的ID查询模型属性.
     * @param modelId 模型的ID
     * @param symbolType 模型的索引类型编号
     * @return 模型的所有属性集合
     */
    List<Map<String, String>> queryModelDetailInfo(String modelId, String symbolType);

    /**
     * 根据对象ID查询对象属性.
     * @param objId 对象的ID
     * @param objType 对象符号类型
     * @return 对象的所有属性集合
     */
    List<Map<String, String>> queryObjDetailInfo(String objId, String objType);

    ArisGrouptblBean queryGrouptblById(String id);

    List<ArisGrouptblBean> queryGrouptblByParentId(String parentId);

    List<ModelBean> queryModelByGroupId(String groupId);
}
