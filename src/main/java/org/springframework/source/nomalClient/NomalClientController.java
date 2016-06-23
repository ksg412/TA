package org.springframework.source.nomalClient;

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
 * Created by sg on 2016-06-16.
 */
@RequestMapping("/nomalClient/*")
@Controller
public class NomalClientController {

    @Autowired
    private NomalClientService nomalClientService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/selectNomalClientView")
    public String selectNomalClientView() throws Exception{
        return "/jsp/nomalClient/nomalClient";
    }

    @RequestMapping("/selectNomalClientDetail")
    public String selectNomalClientDetailView(Model model) throws Exception{
        NomalClientVo nomalClientVo = new NomalClientVo();
        nomalClientVo.setViewType("insert");
        model.addAttribute("nomalClientVo",nomalClientVo);
        return "/jsp/nomalClient/nomalClientDetail";
    }

    @RequestMapping("/selectNomalClientDetail/{ncId}")
    public String selectNomalClientDetailViewId(
            Model model
            ,@RequestParam Map commandMap
            ,@PathVariable String ncId
    ) throws Exception{
        NomalClientVo nomalClientVo =  nomalClientService.selectNomalClientDetail(ncId);
        nomalClientVo.setViewType("update");
        model.addAttribute("nomalClientVo",nomalClientVo);
        return "/jsp/nomalClient/nomalClientDetail";
    }

    @ResponseBody
    @RequestMapping("/selectNomalClientList")
    public Object selectNomalClientList(@RequestParam Map commandMap) throws Exception{

        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = nomalClientService.selectNomalClientList(commandMap);
        int dataCount = nomalClientService.selectNomalClientCount(commandMap);

        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }

    @RequestMapping(value = "saveNomalClientDetail")
    public String saveNomalClientDetail(
            @Valid @ModelAttribute NomalClientVo nomalClientVo
            ,BindingResult bindingResult
            ,SessionStatus sessionStatus
            ,RedirectAttributes redirectAttributes) throws Exception{

        Gson gson = new Gson();
        List insertList = gson.fromJson(nomalClientVo.getTableData01(),List.class);
        nomalClientVo.setInsertList(insertList);

        if(!bindingResult.hasErrors()){
            nomalClientVo.setRegistId(SessionUtil.getSessionId());
            nomalClientVo.setUpdateId(SessionUtil.getSessionId());
            if(nomalClientVo.getViewType().equals("update")){
                nomalClientService.updateNomalClientDetail(nomalClientVo);
                redirectAttributes.addFlashAttribute("msg",messageSource.getMessage("return.update.success",null, Locale.getDefault()));
            }else{
                nomalClientService.insertNomalClientDetail(nomalClientVo);
                redirectAttributes.addFlashAttribute("msg", messageSource.getMessage("return.insert.success",null, Locale.getDefault()));
            }
            sessionStatus.setComplete();
            return "redirect:/nomalClient/selectNomalClientView";
        }else{
            return "/jsp/nomalClient/nomalClientDetail";
        }
    }

    @ResponseBody
    @RequestMapping("/selectNomalClientDetailList")
    public Object selectNomalClientDetailList(@RequestParam Map commandMap) throws Exception{

        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = nomalClientService.selectNomalClientDetailList(commandMap);
        int dataCount = nomalClientService.selectNomalClientDetailCount(commandMap);

        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }
}
