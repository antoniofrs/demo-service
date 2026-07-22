package it.its.demo.demo_service.mapper;

import it.its.demo.demo_service.dto.author.ResAuthorDto;
import it.its.demo.demo_service.dto.book.*;
import it.its.demo.demo_service.model.Book;
import it.its.demo.demo_service.model.Category;
import it.its.demo.demo_service.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

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
    @Transactional
    public ResBookWithTransactionsDto toDtoWithTransactions(Book book){
        ResBookWithTransactionsDto resBookDto = new ResBookWithTransactionsDto();

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

        List<InnerTransactionDto> innerTransactionDtoList = new ArrayList<>();
        List<Transaction> transactions = book.getTransactions();

        for (Transaction transaction: transactions) {
            InnerTransactionDto innerTransactionDto = new InnerTransactionDto(
                    transaction.getId(),
                    transaction.getTotal()
            );
            innerTransactionDtoList.add(innerTransactionDto);
        }

        resBookDto.setTransactions(innerTransactionDtoList);

        return resBookDto;
    }

    public Book toModel(ReqInsertBookDto bookDto, ResAuthorDto resAuthorDto, List<Category> categories){
        Book book = new Book();
        //book.setId(UUID.randomUUID().toString());
        book.setName(bookDto.getName());
        book.setAuthor(authorMapper.toModel(resAuthorDto));
        book.setQuantity(bookDto.getQuantity());
        book.setPrice(bookDto.getPrice());
        book.setCategories(categories);
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
