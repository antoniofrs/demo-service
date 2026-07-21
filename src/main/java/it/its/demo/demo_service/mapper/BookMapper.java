package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.*;
import it.its.demo.demo_service.dto.book.InnerAuthorDto;
import it.its.demo.demo_service.dto.book.ReqInsertBook;
import it.its.demo.demo_service.dto.book.ReqPatchBook;
import it.its.demo.demo_service.dto.book.ResBookDto;
import it.its.demo.demo_service.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    @Autowired
    AuthorMapper authorMapper;

    public ResBookDto toDto(Book book){
        ResBookDto resBookDto = new ResBookDto();
        InnerAuthorDto innerAuthorDto =
                new InnerAuthorDto(
                        book.getAuthor().getId(),
                        book.getAuthor().getName());

        resBookDto.setId(book.getId());
        resBookDto.setName(book.getName());
        resBookDto.setAuthor(innerAuthorDto);
        resBookDto.setQuantity(book.getQuantity());
        resBookDto.setPrice(book.getPrice());
        return resBookDto;
    }

    public Book toModel(ReqInsertBook bookDto, AuthorDto authorDto){
        Book book = new Book();
//        book.setId(UUID.randomUUID().toString());
        book.setName(bookDto.getName());
        book.setAuthor(authorMapper.toModel(authorDto));
        book.setQuantity(bookDto.getQuantity());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    public Book toModel(String id, ReqPatchBook reqPatchBook, AuthorDto authorDto){
        Book book = new Book();
        book.setId(id);
        book.setName(reqPatchBook.getName());
        book.setAuthor(authorMapper.toModel(authorDto));
        book.setQuantity(reqPatchBook.getQuantity());
        book.setPrice(reqPatchBook.getPrice());
        return book;
    }

}
