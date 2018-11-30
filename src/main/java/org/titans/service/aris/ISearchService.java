package org.titans.service.aris;

import java.util.List;
import java.util.Map;

public interface ISearchService {

    /**
     * 查询所有文件列表.
     * @param keyWord 关键字查询
     * @return 文件列表
     */
    List<Map<String, String>> queryAllFileInfo(String keyWord);

    
}
