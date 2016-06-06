package org.springframework.source.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sg on 2016-06-05.
 */
@Controller
@RequestMapping("/main/*")
public class MainController {
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    MainService mainService;

    @RequestMapping(value="mainView.do")
    public String mainView() {
        return "/jsp/main/main";
    }


    @RequestMapping(value="test.do")
    public void test() throws Exception {
        System.out.println(mainService.test());
    }
}
