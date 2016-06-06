package org.springframework.source.customAuthentication;

import org.springframework.source.common.annotation.Mapper;
import org.springframework.source.login.LoginVo;

import java.sql.SQLException;

/**
 * Created by sg on 2016-06-05.
 */
@Mapper
public interface UserDao {
    LoginVo getUser(String username) throws SQLException;
}
