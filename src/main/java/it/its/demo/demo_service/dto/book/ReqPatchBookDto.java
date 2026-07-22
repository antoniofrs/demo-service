package it.its.demo.demo_service.dto.book;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@AllArgsConstructor
@Data
public class ReqPatchBookDto {

    String name;
    Integer author;
    @Positive(message = "Quantity cannot be negative")
    Integer quantity;
    @Positive
    Float price;
    List<Integer> categories;

}
