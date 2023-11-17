package com.iti.customAnnotations;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidYearValidator implements ConstraintValidator<ValidYear, Integer> {

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext context) {
        // Your custom validation logic here
    	int currentYearUsingLocalDate = LocalDate.now().getYear();
        System.out.println("Current year using LocalDate: " + currentYearUsingLocalDate);
        return year != null && year >= 1900 && year <= currentYearUsingLocalDate;
    }
}

