package org.springframework.source.login;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;

/**
 * Created by sg on 2016-06-07.
 */
@Mapper
public interface LoginDao {

    void insertRegist(LoginVo loginVo) throws SQLException;

    int selectIdOverlabCount(String id) throws SQLException;

}
