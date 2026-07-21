package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.author.ResAuthorDto;
import it.its.demo.demo_service.dto.author.InnerBookDto;
import it.its.demo.demo_service.dto.author.ReqInsertAuthorDto;
import it.its.demo.demo_service.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorMapper {

    public ResAuthorDto toDto(Author author) {
        ResAuthorDto resAuthorDto = new ResAuthorDto();
        List<InnerBookDto> innerBookDtoList = new ArrayList<>();

        resAuthorDto.setId(author.getId());
        resAuthorDto.setName(author.getName());

        System.out.println("Carico la lista di libri....");
        author.getBooks().stream()
                .map(book ->
                        innerBookDtoList.add(
                            new InnerBookDto(
                                    book.getId(),
                                    book.getName(),
                                    book.getQuantity(),
                                    book.getPrice())
                        )
                ).toList();


        resAuthorDto.setBooks(innerBookDtoList);

        return resAuthorDto;
    }

    public Author toModel(ResAuthorDto resAuthorDto) {

        Author author = new Author();

        author.setId(resAuthorDto.getId());
        author.setName(resAuthorDto.getName());

        return author;
    }

    public Author toModel(ReqInsertAuthorDto reqInsertAuthorDto) {

        Author author = new Author();

        author.setName(reqInsertAuthorDto.getName());

        return author;
    }



}
