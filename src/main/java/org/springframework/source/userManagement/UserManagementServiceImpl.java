package org.springframework.source.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
@Service
public class UserManagementServiceImpl implements UserManagementService{

    @Autowired
    private UserManagementDao userManagementDao;

    public List selectUserList(Map commandMap) throws Exception{
        return userManagementDao.selectUserList(commandMap);
    }

    @Override
    public int selectUserCount(Map commandMap) throws Exception {
        return userManagementDao.selectUserCount(commandMap);
    }
}
