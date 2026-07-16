package it.its.demo.demo_service.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class QuantityValidator implements ConstraintValidator<QuantityConstraint,Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value <= 1) {
            return false;
        }
        // Verifica la presenza di divisori fino alla radice quadrata del numero
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return true; // Trovato un divisore: il numero è non primo
            }
        }
        return false;
    }
}
