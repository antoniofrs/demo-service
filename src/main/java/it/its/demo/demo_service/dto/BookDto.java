package it.its.demo.demo_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    String id;
    String name;
    String author;
    Integer quantity;
    Double price;
}
