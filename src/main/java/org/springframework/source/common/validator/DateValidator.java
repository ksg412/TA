package org.springframework.source.common.validator;

import org.springframework.source.common.annotation.DateValid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;

/**
 * Created by sg on 2016-06-07.
 */
public class DateValidator implements ConstraintValidator<DateValid, Object> {


    @Override
    public void initialize(DateValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        SimpleDateFormat oDateFormat = new SimpleDateFormat();

        oDateFormat.applyPattern("yyyy-MM-dd");
        oDateFormat.setLenient(false);      // 엄밀하게 검사한다는 옵션 (반드시 있어야 한다)

        if(value != null && !value.equals("")){
            try {
                oDateFormat.parse(String.valueOf(value));
                return true;
            } catch (Exception e) {
                return false;
            }
        }else{
            return true;
        }
    }
}
