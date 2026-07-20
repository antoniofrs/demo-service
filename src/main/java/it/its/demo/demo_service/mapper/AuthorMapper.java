package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.AuthorDto;
import it.its.demo.demo_service.dto.BookWithoutAuthorDto;
import it.its.demo.demo_service.dto.InsertAuthorDto;
import it.its.demo.demo_service.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public AuthorDto toDto(Author author) {
        AuthorDto authorDto = new AuthorDto();
        List<BookWithoutAuthorDto> bookWithoutAuthorDtoList = new ArrayList<>();

        authorDto.setId(author.getId());
        authorDto.setName(author.getName());

        author.getBooks().stream()
                .map(book ->
                        bookWithoutAuthorDtoList.add(
                            new BookWithoutAuthorDto(
                                    book.getId(),
                                    book.getName(),
                                    book.getQuantity(),
                                    book.getPrice())
                        )
                ).toList();


        authorDto.setBooks(bookWithoutAuthorDtoList);

        return authorDto;
    }

    public Author toModel(AuthorDto authorDto) {

        Author author = new Author();

        author.setId(authorDto.getId());
        author.setName(authorDto.getName());

        return author;
    }

    public Author toModel(InsertAuthorDto insertAuthorDto) {

        Author author = new Author();

        author.setName(insertAuthorDto.getName());

        return author;
    }



}
