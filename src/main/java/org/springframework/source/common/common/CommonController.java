package org.springframework.source.common.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.samples.mvc.mapping.JavaBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-11.
 */
@Controller
@RequestMapping("/common/*")
public class CommonController {

    private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private CommonService commonService;


   @ResponseBody
    @RequestMapping(value = "selectComboboxData.do")
    public List selectComboboxData(@RequestParam Map commandMap) throws Exception{
        List comboData = commonService.selectComboboxData(commandMap);
        return comboData;
    }
}
