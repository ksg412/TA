package org.springframework.source.common.validator;

import org.springframework.source.login.LoginVo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by sg on 2016-06-07.
 */

public class PasswordCheckValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(target != null){
            LoginVo loginVo = (LoginVo) target;
            if(loginVo.getPw() !=null && loginVo.getPwCheck() != null){
                if(!loginVo.getPw().equals(loginVo.getPwCheck())){
                    errors.rejectValue("pwCheck","validator.passwordCheck.error");
                }
            }
        }
    }
}
