package org.springframework.source.myPage;

import org.springframework.source.common.annotation.Mapper;

import java.sql.SQLException;

/**
 * Created by sg on 2016-06-12.
 */
@Mapper
public interface MyPageDao {
    MyPageVo selectMyPageView(String id) throws SQLException;
    void updateMyPageInfo(MyPageVo myPageVo) throws SQLException;
}
