package it.its.demo.demo_service.validators;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = QuantityValidator.class)
public @interface QuantityConstraint {
    String message() default "quantita non ammessa";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    //LE PARENTESI[] SIGNIFICA CHE è UNA LISTA
}
