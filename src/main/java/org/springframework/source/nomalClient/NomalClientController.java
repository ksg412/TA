package org.springframework.source.nomalClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sg on 2016-06-16.
 */
@RequestMapping("/nomalClient/*")
@Controller
public class NomalClientController {

    @Autowired
    private NomalClientService nomalClientService;

    @RequestMapping("/selectNomalClientView")
    public String selectNomalClientView() throws Exception{

        return "/jsp/nomalClient/nomalClient";
    }

    @RequestMapping("/selectNomalClientDetailView")
    public String selectNomalClientDetailView() throws Exception{



        return "/jsp/nomalClient/nomalClientDetail";
    }

}
