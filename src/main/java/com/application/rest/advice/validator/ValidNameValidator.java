package com.application.rest.advice.validator;

import com.application.rest.advice.annotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidNameValidator implements ConstraintValidator<ValidName, String> {
    @Override
    public void initialize(ValidName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        //dato no puede ser null
        if(value == null){
            return false;
        }

        //dato no puede ser vacio
        if(value.isEmpty()){
            return false;
        }

        //dato no puede ser mayor a 15 caracteres
        if (value.length()>15){
            return false;
        }

        //dato no puede ser menor a 3 caracteres
        if (value.length()<3){
            return false;
        }

        //dato empieza en mayuscula
        //Si la primer letra no es mayuscula no pasa validador
        if(!Character.isUpperCase(value.charAt(0))){
            return false;
        }
        return true;
    }
}
