package com.ehr.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PSCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PSCode {

    public String value() default "PS";

    public String message() default "PS Code should starts with PS";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
