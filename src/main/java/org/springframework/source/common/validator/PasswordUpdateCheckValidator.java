package org.springframework.source.common.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.source.common.common.CommonService;
import org.springframework.source.common.util.SessionUtil;
import org.springframework.source.myPage.MyPageVo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sg on 2016-06-07.
 */
@Component
public class PasswordUpdateCheckValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(PasswordUpdateCheckValidator.class);

    @Autowired
    private CommonService commonService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        if(target != null){
            MyPageVo myPageVo = (MyPageVo) target;
            if(myPageVo.getUpdatePw() !=null && myPageVo.getUpdatePwCheck() != null){
                if(!myPageVo.getUpdatePw().equals(myPageVo.getUpdatePwCheck())){
                    errors.rejectValue("updatePwCheck","validator.passwordCheck.error");
                }
            }
        }
    }
}
