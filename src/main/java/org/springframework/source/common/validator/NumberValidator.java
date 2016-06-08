package org.springframework.source.common.validator;

import org.springframework.source.common.annotation.NumberValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sg on 2016-06-07.
 */
public class NumberValidator implements ConstraintValidator<NumberValid, Object>{

    @Override
    public void initialize(NumberValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        if(value != null && !value.equals("")){
            try {
                Double.parseDouble(String.valueOf(value));
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }else{
            return true;
        }
    }
}
