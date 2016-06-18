package org.springframework.source.nomalClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.source.common.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/selectNomalClientDetail")
    public String selectNomalClientDetailView(Model model) throws Exception{
        model.addAttribute("nomalClientVo",new NomalClientVo());
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

}
