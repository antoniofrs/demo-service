package it.its.demo.demo_service.dto.author;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResAuthorDto {

    Integer id;
    String name;
    List<InnerBookDto> books;
}
