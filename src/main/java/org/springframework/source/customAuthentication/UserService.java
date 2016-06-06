package org.springframework.source.customAuthentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.source.login.LoginVo;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sg on 2016-06-04.
 */
public class UserService implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("username : " + username);

        LoginVo loginVo = null;

        try {
            loginVo = userDao.getUser(username);
        } catch (SQLException e) {
            logger.debug(e.getMessage(),e);
        }

        if (loginVo == null) throw new UsernameNotFoundException("접속자 정보를 찾을 수 없습니다.");

        User user = new User();
        user.setUsername(username);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(loginVo.getPw());

        Role role = new Role();
        role.setName("ROLE_USER");

        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        user.setAuthorities(roles);

        return user;
    }
}
