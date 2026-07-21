package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.author.ResAuthorDto;
import it.its.demo.demo_service.dto.book.InnerAuthorDto;
import it.its.demo.demo_service.dto.book.ResBookDto;
import it.its.demo.demo_service.dto.book.ReqInsertBookDto;
import it.its.demo.demo_service.dto.book.ReqPutBookDtoDto;
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
                        book.getAuthor().getName()
                );

        resBookDto.setId(book.getId());
        resBookDto.setName(book.getName());
        resBookDto.setAuthor(innerAuthorDto);
        resBookDto.setQuantity(book.getQuantity());
        resBookDto.setPrice(book.getPrice());
        return resBookDto;
    }

    public Book toModel(ReqInsertBookDto bookDto, ResAuthorDto resAuthorDto){
        Book book = new Book();
        //book.setId(UUID.randomUUID().toString());
        book.setName(bookDto.getName());
        book.setAuthor(authorMapper.toModel(resAuthorDto));
        book.setQuantity(bookDto.getQuantity());
        book.setPrice(bookDto.getPrice());
        return book;
    }

    public Book toModel(ReqPutBookDtoDto bookDto, ResAuthorDto resAuthorDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setAuthor(authorMapper.toModel(resAuthorDto));
        book.setQuantity(bookDto.getQuantity());
        book.setPrice(bookDto.getPrice());
        return book;
    }


}
