package org.springframework.source.common.annotation;

import org.springframework.source.common.validator.NumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by sg on 2016-06-07.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={NumberValidator.class})
public @interface NumberValid {

    String message() default "{validator.number.check}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
