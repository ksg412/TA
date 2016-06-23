package org.springframework.source.nomalClient;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-16.
 */
@Mapper
public interface NomalClientDao {
    List selectNomalClientList(Map comandMap) throws SQLException;
    int selectNomalClientCount(Map comandMap) throws SQLException;
    void updateNomalClientDetail(NomalClientVo nomalClientVo) throws SQLException;
    void insertNomalClientDetail(NomalClientVo nomalClientVo) throws SQLException;
    void insertNomalClientDetailList(NomalClientVo nomalClientVo) throws SQLException;
    void deleteNomalClientDetailList(NomalClientVo nomalClientVo) throws SQLException;
    List selectNomalClientDetailList(Map commandMap) throws SQLException;
    int selectNomalClientDetailCount(Map commandMap) throws SQLException;
    NomalClientVo selectNomalClientDetail(String ncId) throws SQLException;
}
