package com.iti.customAnnotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndianPhoneNumberValidator implements ConstraintValidator<IndianPhoneNumber, String> {

    private static final String PHONE_NUMBER_REGEX = "^[6-9]\\d{9}$";

    @Override
    public void initialize(IndianPhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return true; // Null or empty values are considered valid (you can change this behavior)
        }

        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
}

