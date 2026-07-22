package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResBookDto {
    String id;
    String name;
    InnerAuthorDto author;
    Integer quantity;
    Float price;
    List<String> categories;
}
