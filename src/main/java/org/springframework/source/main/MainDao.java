package org.springframework.source.main;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;

/**
 * Created by sg on 2016-06-05.
 */
@Mapper
public interface MainDao {
    String test() throws SQLException;
}
