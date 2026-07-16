package it.its.demo.demo_service.validators;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CustomNameValidator implements ConstraintValidator<CustomNameConstraint,String> {

    String value;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (this.value.equals(value)) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(CustomNameConstraint constraintAnnotation) {
        this.value= constraintAnnotation.value();
    }
}

