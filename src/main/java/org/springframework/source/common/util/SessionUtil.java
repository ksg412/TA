package org.springframework.source.common.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.source.customAuthentication.User;

/**
 * Created by sg on 2016-06-12.
 */
public class SessionUtil {

    public static String getSessionId(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}
