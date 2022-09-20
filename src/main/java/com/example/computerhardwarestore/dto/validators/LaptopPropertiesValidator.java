package com.example.computerhardwarestore.dto.validators;


import com.example.computerhardwarestore.dto.LaptopProperties;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



public class LaptopPropertiesValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return LaptopProperties.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        LaptopProperties laptopProperties = (LaptopProperties) target;

    }
}
