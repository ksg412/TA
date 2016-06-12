package org.springframework.source.userManagement;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */

@Mapper
public interface UserManagementDao {
    List selectUserList(Map commandMap) throws SQLException;
    int selectUserCount(Map commandMap) throws SQLException;
}
