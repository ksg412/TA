package org.springframework.source.common.validator;

import org.springframework.source.common.annotation.DateValid;
import org.springframework.source.common.annotation.EmptySizeValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * Created by sg on 2016-06-07.
 */
public class EmptySizeValidator implements ConstraintValidator<EmptySizeValid, Object> {

    int min;
    int max;

    @Override
    public void initialize(EmptySizeValid constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String str = (String) value;
        if(value != null && !value.equals("")){
            if(str.length() < min){
                return false;
            }else if(str.length() > max){
                return false;
            }else{
                return true;
            }
        }else{
            return true;
        }
    }
}
