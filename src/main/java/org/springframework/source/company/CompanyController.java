package org.springframework.source.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sg on 2016-06-12.
 */
@RequestMapping("/company/*")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "selectCompanyView.do")
    public String selectCompanyView() throws Exception{
        return "/jsp/company/company";
    }

    @RequestMapping(value = "selectCompanyDetail.do")
    public String selectCompanyDetail() throws Exception{
        return "/jsp/company/companyDetail";
    }

}
