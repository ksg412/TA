package org.springframework.source.nomalClient;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-16.
 */
public interface NomalClientService {
    List selectNomalClientList(Map commandMap) throws Exception;
    int selectNomalClientCount(Map commandMap) throws Exception;
    void updateNomalClientDetail(NomalClientVo nomalClientVo) throws Exception;
    void insertNomalClientDetail(NomalClientVo nomalClientVo) throws Exception;
    List selectNomalClientDetailList(Map commandMap) throws Exception;
    int selectNomalClientDetailCount(Map commandMap) throws Exception;
    NomalClientVo selectNomalClientDetail(String ncId) throws Exception;


}
