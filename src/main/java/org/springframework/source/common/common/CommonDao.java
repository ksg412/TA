package org.springframework.source.common.common;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */

@Mapper
public interface CommonDao {
    List selectComboboxData(Map commandMap) throws SQLException;
    String getCurrentPassword(String id) throws SQLException;
}
