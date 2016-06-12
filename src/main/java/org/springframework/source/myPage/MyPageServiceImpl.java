package org.springframework.source.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.source.common.util.SessionUtil;
import org.springframework.stereotype.Service;

/**
 * Created by sg on 2016-06-12.
 */

@Service
public class MyPageServiceImpl implements MyPageService{

    @Autowired
    private MyPageDao myPageDao;

    @Override
    public MyPageVo selectMyPageView(String id) throws Exception {
        return myPageDao.selectMyPageView(id);
    }

    @Override
    public void updateMyPageInfo(MyPageVo myPageVo) throws Exception {
        if(myPageVo.getUpdatePw() != null && !myPageVo.getUpdatePw().equals("")){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            myPageVo.setPw(passwordEncoder.encode(myPageVo.getUpdatePw()));
        }
        myPageVo.setUpdateId(SessionUtil.getSessionId());
        myPageDao.updateMyPageInfo(myPageVo);
    }
}

