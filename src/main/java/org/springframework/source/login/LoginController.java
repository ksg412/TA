package org.springframework.source.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.source.common.validator.PasswordCheckValidator;
import org.springframework.source.customAuthentication.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by sg on 2016-06-04.
 */

@Controller
@RequestMapping("/login/*")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LoginService loginService;

    @Autowired
    private PasswordCheckValidator passwordCheckValidator;

    @RequestMapping(value="login.do")
    public String login(
            HttpServletRequest request
            ,Model model
    ){
        model.addAttribute("fail",request.getParameter("fail"));
        return "/jsp/login/login";
    }

    @RequestMapping(value="loginCheck.do")
    public String loginCheck() {

        if(SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User){
            return "redirect:/main/mainView.do";
        }else{
            return "redirect:/login/login.do";
        }
    }

    @RequestMapping(value="logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login/login.do";
    }

    @RequestMapping(value="selectRegistView.do")
    public String selectRegistView(Model model){
        model.addAttribute("loginVo",new LoginVo());
        return "/jsp/login/regist";
    }

    @RequestMapping(value="insertRegist.do")
    public String insertRegist(
            @Valid @ModelAttribute LoginVo loginVo
            ,BindingResult bindingResult
            ,SessionStatus sessionStatus
    ) throws Exception{

        passwordCheckValidator.validate(loginVo,bindingResult);

        if(!bindingResult.hasErrors()){
            sessionStatus.setComplete();
            loginService.insertRegist(loginVo);
            return "redirect:/login/login.do";
        }else{
            loginVo.setPw(null);
            loginVo.setPwCheck(null);
            return "/jsp/login/regist";
        }
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public void login(HttpSession session) {
        logger.info("Welcome login! {}", session.getId());
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public void logout(HttpSession session) {
        User userDetails = (User)session.getAttribute("userLoginInfo");

        logger.info("Welcome logout! {}, {}", session.getId(), userDetails.getUsername());


        session.invalidate();
    }

    @RequestMapping(value = "login_success", method = RequestMethod.GET)
    public String login_success(HttpSession session) {

        User userDetails = null;

        userDetails = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        logger.info("Welcome login_success! {}, {}", session.getId(), userDetails.getUsername() + "/" + userDetails.getPassword());
        session.setAttribute("userLoginInfo", userDetails);
        return "redirect:/main/mainView.do";
    }

    @RequestMapping(value = "login_duplicate", method = RequestMethod.GET)
    public void login_duplicate() {
        logger.info("Welcome login_duplicate!");
    }
}
