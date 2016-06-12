package org.springframework.source.common.util;

import java.util.HashMap;

/**
 * Created by sg on 2016-06-11.
 */
public class ResultMap extends HashMap<String,Object> {
    private static final long serialVersionUID = 1L;

    public ResultMap put(String key, Object value){
        super.put( CommonUtil.toCamelCase(key, false), value);
        return this;
    }
}
