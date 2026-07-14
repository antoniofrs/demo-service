package it.its.demo.demo_service.validators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = CustomNameValidator.class)
public @interface CustomNameConstraint {

    String message() default "autore non ammesso";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    //LE PARENTESI[] SIGNIFICA CHE è UNA LISTA
    String value() default "";//aggiungo un altro attributo che posso specificare quando richiamo il constraint(in Insertbook)
    //String value()[] default "" SE VOGLIO DICHIARARE UN ARRAY DI CAMPI NON ACCETTATI
}
