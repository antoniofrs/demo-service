package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InnerAuthorDto {
    private Integer id;
    private String name;
}
