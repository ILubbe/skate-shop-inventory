package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {PartsInvAboveMinValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPartsInvAboveMin {
    String message() default "One or more associated parts will have their inventory fall below the set minimum!";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
