package org.springframework.source.common.annotation;

import org.springframework.source.common.validator.EmptySizeValidator;

import javax.validation.Constraint;
import java.lang.annotation.*;

/**
 * Created by sg on 2016-06-07.
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy={EmptySizeValidator.class})
public @interface EmptySizeValid {

    String message() default "{javax.validation.constraints.Size.message}";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};

    int min() default 0;

    int max() default Integer.MAX_VALUE;
}
