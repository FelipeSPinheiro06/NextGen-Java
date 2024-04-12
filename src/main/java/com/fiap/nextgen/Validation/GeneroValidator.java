package com.fiap.nextgen.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GeneroValidator implements ConstraintValidator<Genero, Boolean> {

	@Override
	public boolean isValid(Boolean value, ConstraintValidatorContext context) {
		return equals("Masculine") || equals("Feminine");
	}

    
}