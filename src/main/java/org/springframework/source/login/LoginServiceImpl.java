package org.springframework.source.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by sg on 2016-06-07.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;

    public void insertRegist(LoginVo loginVo) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        loginVo.setPw(passwordEncoder.encode(loginVo.getPw()));
        loginDao.insertRegist(loginVo);
    }

    public int selectIdOverlabCount(String id) throws Exception{
        return loginDao.selectIdOverlabCount(id);
    }
}
