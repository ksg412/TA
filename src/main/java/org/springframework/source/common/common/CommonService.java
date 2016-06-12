package org.springframework.source.common.common;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
public interface CommonService {

    List selectComboboxData(Map commandMaps) throws Exception;

    String getCurrentPassword(String id) throws Exception;

}
