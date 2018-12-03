package org.titans.service.aris;

import java.util.Map;

public interface IInitService {

    public Map<Integer, String> queryAttrs();

    public Map<String, Integer> queryAttrTypeNum();
}
