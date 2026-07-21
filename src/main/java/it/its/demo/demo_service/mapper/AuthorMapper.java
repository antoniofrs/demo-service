package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.author.ResAuthorDto;
import it.its.demo.demo_service.dto.author.InnerBookDto;
import it.its.demo.demo_service.dto.author.ReqInsertAuthorDto;
import it.its.demo.demo_service.model.Author;
import it.its.demo.demo_service.model.Book;
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
        if (author.getBooks() != null && !author.getBooks().isEmpty()) {
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
        } else {
            resAuthorDto.setBooks(new ArrayList<>());
        }

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

        if (reqInsertAuthorDto.getBooks() != null && !reqInsertAuthorDto.getBooks().isEmpty()) {
            List<Book> books = new ArrayList<>();
            for (InnerBookDto bookDto : reqInsertAuthorDto.getBooks()) {
                Book book = new Book();
                book.setName(bookDto.getName());
                book.setPrice(bookDto.getPrice());
                book.setQuantity(bookDto.getQuantity());

                book.setAuthor(author);

                books.add(book);
            }

            author.setBooks(books);
        }

        return author;
    }



}
