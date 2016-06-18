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

}
