package org.springframework.source.common.annotation;

import org.springframework.source.common.validator.DateValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by sg on 2016-06-07.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={DateValidator.class})
public @interface DateValid {

    String message() default "{validator.date.check}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
