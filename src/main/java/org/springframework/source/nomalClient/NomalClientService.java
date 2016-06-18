package org.springframework.source.nomalClient;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-16.
 */
public interface NomalClientService {
    List selectNomalClientList(Map commandMap) throws Exception;
    int selectNomalClientCount(Map commandMap) throws Exception;

}
