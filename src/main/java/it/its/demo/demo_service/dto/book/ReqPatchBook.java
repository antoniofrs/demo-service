package it.its.demo.demo_service.dto.book;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class ReqPatchBook {

    String name;
    Integer author;
    //String author;
    @Positive(message = "Quantity cannot be negative")
    Integer quantity;
    @Positive
    Double price;

}
