package it.its.demo.demo_service.dto.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReqPutBookDtoDto extends ReqInsertBookDto {

    @NotBlank(message = "Id cannot be blank")
    String id;

    public ReqPutBookDtoDto(String name, Integer author, Integer quantity, Float price) {
        super(name, author, quantity, price);
    }
}
