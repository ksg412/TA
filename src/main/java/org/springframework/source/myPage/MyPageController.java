package org.springframework.source.myPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.source.common.util.SessionUtil;
import org.springframework.source.common.validator.PasswordUpdateCheckValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * Created by sg on 2016-06-12.
 */
@RequestMapping("/myPage/*")
@Controller
public class MyPageController {

    @Autowired
    private MyPageService myPageService;

    @RequestMapping(value = "myPageView.do")
    public String myPageView(Model model) throws Exception{
        MyPageVo myPageVo = myPageService.selectMyPageView(SessionUtil.getSessionId());
        model.addAttribute("myPageVo",myPageVo);
        return "jsp/myPage/myPage";
    }

    @RequestMapping(value = "updateMyPage")
    public String updateMyPage(
            @Valid @ModelAttribute MyPageVo myPageVo
            ,BindingResult bindingResult
            ,SessionStatus sessionStatus
    ) throws Exception{

        PasswordUpdateCheckValidator passwordUpdateCheckValidator = new PasswordUpdateCheckValidator();
        passwordUpdateCheckValidator.validate(myPageVo,bindingResult);

        if(!bindingResult.hasErrors()){
            myPageService.updateMyPageInfo(myPageVo);
            sessionStatus.setComplete();
            return "redirect:/login/loginCheck.do";
        }else{
            myPageVo.setPw(null);
            myPageVo.setUpdatePw(null);
            myPageVo.setUpdatePwCheck(null);
            return "/jsp/myPage/myPage";
        }
    }
}
