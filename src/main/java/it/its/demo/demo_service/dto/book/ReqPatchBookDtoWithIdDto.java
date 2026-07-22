package it.its.demo.demo_service.dto.book;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class ReqPatchBookDtoWithIdDto extends ReqPatchBookDto {

    @NotBlank(message = "Id cannot be blank")
    String id;

    public ReqPatchBookDtoWithIdDto(String name, Integer author, Integer quantity, Float price, List<Integer> categories) {
        super(name, author, quantity, price, categories);
    }
}
