package org.titans.dao.aris;

import java.util.Map;

public interface IInitDao {

    public Map<Integer, String> queryAttrs();

    public Map<String, Integer> queryAttrTypeNum();
}
