package org.springframework.source.login;

/**
 * Created by sg on 2016-06-07.
 */
public interface LoginService {

    void insertRegist(LoginVo loginVo) throws Exception;

    int selectIdOverlabCount(String id) throws Exception;

}
