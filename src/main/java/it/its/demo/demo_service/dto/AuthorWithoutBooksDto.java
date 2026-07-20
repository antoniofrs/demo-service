package it.its.demo.demo_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorWithoutBooksDto {
    private Integer id;
    private String name;
}
