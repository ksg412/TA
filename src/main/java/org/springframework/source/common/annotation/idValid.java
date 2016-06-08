package org.springframework.source.common.annotation;

import org.springframework.source.common.validator.IdOverlabValidator;
import org.springframework.source.common.validator.NumberValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by sg on 2016-06-08.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={IdOverlabValidator.class})
public @interface IdValid {

    String message() default "{validator.idoverlab.check}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

}
