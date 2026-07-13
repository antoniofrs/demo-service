package it.its.demo.demo_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InsertBook {

    @NotBlank(message = "Name cannot be blank")
    String name;

    @NotBlank(message = "Author cannot be blank")
    String author;

    @NotNull(message = "Quantity cannot be null or negative")
    @Positive(message = "Quantity cannot be null or negative")
    Integer quantity;

    @NotNull(message = "Prezzo cannot be null or negative")
    @Positive(message = "Prezzo cannot be null or negative")
    Double prezzo;

}
