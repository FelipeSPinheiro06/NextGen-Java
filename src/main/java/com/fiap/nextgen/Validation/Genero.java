package com.fiap.nextgen.Validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=GeneroValidator.class)
public @interface Genero {
    String message() default "{movimentacao.tipo}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
