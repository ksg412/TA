package org.springframework.source.companyClient;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.source.common.util.CommonUtil;
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
import java.util.Locale;
import java.util.Map;

/**
 * Created by sg on 2016-07-16.
 */
@RequestMapping("/companyClient/*")
@Controller
public class CompanyClientController {

    @Autowired
    private CompanyClientService companyClientService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/selectCompanyClientView")
    public String selectCompanyClientView() throws Exception{
        return "/jsp/companyClient/companyClient";
    }

    @RequestMapping("/selectCompanyClientDetail")
    public String selectCompanyClientDetailView(Model model) throws Exception{
        CompanyClientVo companyClientVo = new CompanyClientVo();
        companyClientVo.setViewType("insert");
        model.addAttribute("companyClientVo",companyClientVo);
        return "/jsp/companyClient/companyClientDetail";
    }

    @RequestMapping("/selectCompanyClientDetail/{ncId}")
    public String selectCompanyClientDetailViewId(
            Model model
            ,@RequestParam Map commandMap
            ,@PathVariable String ncId
    ) throws Exception{
        CompanyClientVo companyClientVo =  companyClientService.selectCompanyClientDetail(ncId);
        companyClientVo.setViewType("update");
        model.addAttribute("companyClientVo",companyClientVo);
        return "/jsp/companyClient/companyClientDetail";
    }

    @ResponseBody
    @RequestMapping("/selectCompanyClientList")
    public Object selectCompanyClientList(@RequestParam Map commandMap) throws Exception{

        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = companyClientService.selectCompanyClientList(commandMap);
        int dataCount = companyClientService.selectCompanyClientCount(commandMap);

        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }

    @RequestMapping(value = "saveCompanyClientDetail")
    public String saveCompanyClientDetail(
            @Valid @ModelAttribute CompanyClientVo companyClientVo
            ,BindingResult bindingResult
            ,SessionStatus sessionStatus
            ,RedirectAttributes redirectAttributes) throws Exception{

        Gson gson = new Gson();
        List insertList = gson.fromJson(companyClientVo.getTableData01(),List.class);
        companyClientVo.setInsertList(insertList);

        if(!bindingResult.hasErrors()){
            companyClientVo.setRegistId(SessionUtil.getSessionId());
            companyClientVo.setUpdateId(SessionUtil.getSessionId());
            if(companyClientVo.getViewType().equals("update")){
                companyClientService.updateCompanyClientDetail(companyClientVo);
                redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("return.update.success",null, Locale.getDefault()));
            }else{
                companyClientService.insertCompanyClientDetail(companyClientVo);
                redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("return.insert.success",null, Locale.getDefault()));
            }
            sessionStatus.setComplete();
            return "redirect:/companyClient/selectCompanyClientView";
        }else{
            return "/jsp/companyClient/companyClientDetail";
        }
    }

    @ResponseBody
    @RequestMapping("/selectCompanyClientDetailList")
    public Object selectCompanyClientDetailList(@RequestParam Map commandMap) throws Exception{

        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = companyClientService.selectCompanyClientDetailList(commandMap);
        int dataCount = companyClientService.selectCompanyClientDetailCount(commandMap);

        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }






}
