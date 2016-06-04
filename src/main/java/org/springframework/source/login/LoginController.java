package org.springframework.source.login;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by sg on 2016-06-04.
 */
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/login")
    public String loginView() {
        return "/jsp/login";
    }
}
