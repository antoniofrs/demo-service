package it.its.demo.demo_service.dto.book;

import it.its.demo.demo_service.dto.category.ResCategoryDto;
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
    List<ResCategoryDto> categories;
}
