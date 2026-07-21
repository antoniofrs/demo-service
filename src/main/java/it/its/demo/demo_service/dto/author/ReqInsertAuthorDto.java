package it.its.demo.demo_service.dto.author;

import it.its.demo.demo_service.model.Book;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class ReqInsertAuthorDto {
    @NotBlank(message = "Author name cannot be null")
    private String name;

    private List<Book> books;
}
