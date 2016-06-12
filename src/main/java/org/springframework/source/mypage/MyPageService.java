package org.springframework.source.myPage;

/**
 * Created by sg on 2016-06-12.
 */
public interface MyPageService {
    MyPageVo selectMyPageView(String id) throws Exception;
    void updateMyPageInfo(MyPageVo myPageVo) throws Exception;
}
