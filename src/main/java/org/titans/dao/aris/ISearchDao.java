package org.titans.dao.aris;

import java.util.List;
import java.util.Map;

import org.titans.bean.aris.ModelAttrBean;
import org.titans.bean.aris.ModelBean;

public interface ISearchDao {

    /**
     * 查询所有文件列表.
     * @param modelIds 关键字查询
     * @return 文件列表
     */
    List<ModelBean> queryAllFileInfo(List<String> modelIds);

    /**
     * 根据关键字查询模型特性表获取parientItemId.
     * @param keyWord
     * @return
     */
    List<ModelAttrBean> queryModelIds(String keyWord);

    
}
