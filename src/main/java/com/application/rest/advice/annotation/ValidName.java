package com.application.rest.advice.annotation;

import com.application.rest.advice.validator.ValidNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ValidNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidName {
    String message() default "{custom.validation.messages}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
