package org.springframework.source.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.source.common.util.CommonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sg on 2016-06-09.
 */
@Controller
@RequestMapping("/userManagement/*")
public class UserManagementController {

    @Autowired
    private UserManagementService userManagementService;

    @RequestMapping(value = "userManagementView.do")
    public String userManagementView() throws Exception{

        return "/jsp/userManagement/userManagement";
    }

    @ResponseBody
    @RequestMapping(value="selectUserList.do")
    public Object selectUserList(@RequestParam Map commandMap) throws Exception{
        CommonUtil.mapFormDataToNomalData(commandMap);
        List dataList = userManagementService.selectUserList(commandMap);
        int dataCount = userManagementService.selectUserCount(commandMap);
        Map returnMap = new HashMap();
        returnMap.put("data",dataList);
        returnMap.put("draw",commandMap.get("draw"));
        returnMap.put("recordsTotal",dataCount);
        returnMap.put("recordsFiltered",dataCount);
        return returnMap;
    }

}
