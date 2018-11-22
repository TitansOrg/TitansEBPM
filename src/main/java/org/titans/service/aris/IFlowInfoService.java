package org.titans.service.aris;

import java.util.List;
import java.util.Map;

/**
 * ARIS数据同步服务层接口.
 */
public interface IFlowInfoService {

    /**
     * 查询流程管理平台中指定的模型信息.
     * @param modelId 模型ID
     * @return 模型对象
     * @throws Exception 发布异常
     */
    String queryEbpmModelBean(String modelId);

    /**
     * 根据模型的GUID查询模型属性.
     * @param modelGuid 模型的GUID
     * @return 模型的所有属性集合
     */
    List<Map<String, String>> queryModelDetailInfo(String modelGuid);

    /**
     * 根据对象GUID查询对象属性.
     * @param objGuid 对象的GUID
     * @param objType 对象符号类型
     * @param modelId 模型Id
     * @return 对象的所有属性集合
     */
    List<Map<String, String>> queryObjDetailInfo(String objGuid, String objType);

    /**
     * 查询ARIS文件系统根路径信息.
     * @return 根路径信息集合
     */
    Map<String, String> queryFileRootPath();

    /**
     * 查询某个路径下的所有子路径和文件.
     * @param parentPath 父路径id
     * @return 所有子路径信息集合
     */
    List<Map<String, String>> queryFileInfoByParentId(String parentId);
}
