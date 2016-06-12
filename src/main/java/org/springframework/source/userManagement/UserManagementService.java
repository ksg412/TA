package org.springframework.source.userManagement;

import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
public interface UserManagementService {
    List selectUserList(Map commandMap) throws Exception;
    int selectUserCount(Map commandMap) throws Exception;
}
