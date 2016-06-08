package org.springframework.source.common.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.source.common.annotation.IdValid;
import org.springframework.source.login.LoginService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sg on 2016-06-08.
 */
public class IdOverlabValidator implements ConstraintValidator<IdValid, Object> {

    private static final Logger logger = LoggerFactory.getLogger(IdOverlabValidator.class);

    @Autowired
    private LoginService loginService;

    @Override
    public void initialize(IdValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null && !value.equals("")){
            try {
                if(loginService.selectIdOverlabCount(String.valueOf(value))>0){
                    return false;
                }else{
                    return true;
                }
            } catch (Exception e) {
                logger.debug(e.getMessage(),e);
                return false;
            }
        }else{
            return true;
        }
    }
}
