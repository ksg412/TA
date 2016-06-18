package org.springframework.source.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.source.common.util.CommonUtil;
import org.springframework.source.common.util.MessageUtil;
import org.springframework.source.common.util.SessionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-12.
 */
@RequestMapping("/company/*")
@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private MessageUtil messageUtil;

    @RequestMapping(value = "selectCompanyView.do")
    public String selectCompanyView() throws Exception{
        return "/jsp/company/company";
    }

    @RequestMapping(value = "selectCompanyDetail")
    public String selectCompanyDetail(
            Model model
            ,@RequestParam Map commandMap
    ) throws Exception{
        CompanyVo companyVo = new CompanyVo();
        companyVo.setViewType("insert");
        model.addAttribute("companyVo",companyVo);
        return "/jsp/company/companyDetail";
    }

    @RequestMapping(value = "selectCompanyDetail/{companyId}")
    public String selectCompanyDetailId(
            Model model
            ,@RequestParam Map commandMap
            ,@PathVariable String companyId
    ) throws Exception{

        CompanyVo companyVo = companyService.selectCompanyDetail(companyId);
        companyVo.setViewType("update");

        model.addAttribute("companyVo",companyVo);
        return "/jsp/company/companyDetail";
    }

    @RequestMapping(value = "saveCompanyDetail")
    public String insertCompanyDetial(
            @Valid @ModelAttribute CompanyVo companyVo
            ,BindingResult bindingResult
            ,SessionStatus sessionStatus
            ,RedirectAttributes redirectAttributes
    ) throws Exception{
        if(!bindingResult.hasErrors()){
            companyVo.setRegistId(SessionUtil.getSessionId());
            companyVo.setUpdateId(SessionUtil.getSessionId());
            if(companyVo.getViewType().equals("update")){
                companyService.updateCompanyDetail(companyVo);
                redirectAttributes.addFlashAttribute("msg", messageUtil.returnMsg("return.update.success"));
            }else{
                companyService.insertCompanyDetail(companyVo);
                redirectAttributes.addFlashAttribute("msg", messageUtil.returnMsg("return.insert.success"));
            }
            sessionStatus.setComplete();
            return "redirect:/company/selectCompanyView.do";
        }else{
            return "/jsp/company/companyDetail";
        }
    }

    @ResponseBody
    @RequestMapping(value="selectCompanyList")
    public Object selectCompanyList(@RequestParam Map commandMap) throws Exception{
        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = companyService.selectCompanyList(commandMap);
        int dataCount = companyService.selectCompanyCount(commandMap);
        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }
}
