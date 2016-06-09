package org.springframework.source.userManagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sg on 2016-06-09.
 */
@Controller
@RequestMapping("/userManagement/*")
public class userManagementController {

    @RequestMapping(value = "userManagementView.do")
    public String userManagementView() throws Exception{

        return "/jsp/userManagement/userManagement";
    }

}
