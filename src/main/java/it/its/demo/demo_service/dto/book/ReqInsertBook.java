package it.its.demo.demo_service.dto.book;

import it.its.demo.demo_service.validators.CustomNameConstraint;
import it.its.demo.demo_service.validators.QuantityConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ReqInsertBook {

    @CustomNameConstraint(value="La mia storia con Albano")
    @NotBlank(message = "Name cannot be blank")
    String name;


    @NotNull(message = "Author cannot be blank")
    @Positive (message = "Author cannot be null or negative")
    //abbiamo modificato author in integer perchè ora sarà l'id dell'entità Author
    Integer author;
    //String author;

    @QuantityConstraint(message = "non valido")
    @NotNull(message = "Quantity cannot be null or negative")
    @Positive(message = "Quantity cannot be null or negative")
    Integer quantity;

    @Positive
    @NotNull
    Double price;

}
