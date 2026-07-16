package it.its.demo.demo_service.dto;

import it.its.demo.demo_service.validators.CustomNameConstraint;
import it.its.demo.demo_service.validators.QuantityConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@AllArgsConstructor
@Data
public class InsertBook {

    @CustomNameConstraint(value="La mia storia con Albano")
    @NotBlank(message = "Name cannot be blank")
    String name;

    @CustomNameConstraint(value="antonio frisenda",message = "non sei il benvenuto")
    @NotBlank(message = "Author cannot be blank")
    String author;

    @QuantityConstraint(message = "non valido")
    @NotNull(message = "Quantity cannot be null or negative")
    @Positive(message = "Quantity cannot be null or negative")
    Integer quantity;

    @Positive
    @NotNull
    Double price;

}
