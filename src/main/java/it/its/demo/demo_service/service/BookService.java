package it.its.demo.demo_service.service;

import it.its.demo.demo_service.dto.*;
import it.its.demo.demo_service.dto.book.ReqInsertBook;
import it.its.demo.demo_service.dto.book.ReqPatchBook;
import it.its.demo.demo_service.dto.book.ReqPatchBookWithId;
import it.its.demo.demo_service.dto.book.ResBookDto;
import it.its.demo.demo_service.exceptions.BookNotFoundException;
import it.its.demo.demo_service.exceptions.BooksNotAvailable;
import it.its.demo.demo_service.mapper.AuthorMapper;
import it.its.demo.demo_service.mapper.BookMapper;
import it.its.demo.demo_service.model.Book;
import it.its.demo.demo_service.model.Transaction;
import it.its.demo.demo_service.repository.BookRepository;
import it.its.demo.demo_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {


    private BuyRequest buyRequest;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AuthorService authorService;
    @Autowired
    private AuthorMapper authorMapper;

    public ResBookDto insert(ReqInsertBook reqInsertBook) {
        AuthorDto author= authorService.findById(reqInsertBook.getAuthor());
        Book book = bookMapper.toModel(reqInsertBook, author);
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }


    public ResBookDto findById(String id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return bookMapper.toDto(book);
    }
//
    public List<ResBookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
    }
//
    public List<ResBookDto> findByName(String name) {
        return bookRepository.findByNameWithQuery(name).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    public void delete(String id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
//
//    public void delete(String id) {
//        int result = bookRepository.delete(id);
//        if(result == 0){
//            throw new BookNotFoundException(id);
//        }
//    }
//
    public ResBookDto buy(String id, BuyRequest request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (book.getQuantity() <= request.getQuantity() - 1) {
            throw new BooksNotAvailable(id, request.getQuantity());
        }

        book.setQuantity(book.getQuantity() - request.getQuantity());

       bookRepository.save(book);

        Transaction transaction=new Transaction();
        transaction.setBook(book);
        transaction.setTotal(book.getPrice()* request.getQuantity() );
        transaction.setQntBought(request.getQuantity());
        transactionRepository.save(transaction);
        return bookMapper.toDto(book);
    }
//
//
//    // PatchBook -> BookDto
    public ResBookDto patch(String id, ReqPatchBook reqPatchBook) {

        Book toUpdate = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        if (reqPatchBook.getAuthor() != null) {

            toUpdate.setAuthor(
                    authorMapper.toModel(
                            authorService.findById(reqPatchBook.getAuthor())));
        }

        if (reqPatchBook.getName() != null) {
            toUpdate.setName(reqPatchBook.getName());
        }

        if (reqPatchBook.getQuantity() != null) {
            toUpdate.setQuantity(reqPatchBook.getQuantity());
        }
        if (reqPatchBook.getPrice() != null) {
            toUpdate.setPrice(reqPatchBook.getPrice());
        }

        bookRepository.save(toUpdate);

        return bookMapper.toDto(toUpdate);
    }
//
//    // BookInsertDto -> BookDto
    public ResBookDto put(String id, ReqInsertBook insert) {

        bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        AuthorDto authorDto= authorService.findById(insert.getAuthor());
        Book toUpdate = bookMapper.toModel(insert, authorDto);

        bookRepository.save(toUpdate);

        return bookMapper.toDto(toUpdate);
    }

    //patch con withIdBookPatch
    public ResBookDto patch(ReqPatchBookWithId patchBook) {

        Book toUpdate = bookRepository.findById(patchBook.getId())
                .orElseThrow(() -> new BookNotFoundException(patchBook.getId()));

        if (patchBook.getAuthor() != null) {
            toUpdate.setAuthor(authorMapper.toModel(
                    authorService.findById(patchBook.getAuthor())));
        }

        if (patchBook.getName() != null) {
            toUpdate.setName(patchBook.getName());
        }

        if (patchBook.getQuantity() != null) {
            toUpdate.setQuantity(patchBook.getQuantity());
        }

        if (patchBook.getPrice() != null) {
            toUpdate.setPrice(patchBook.getPrice());
        }

        return bookMapper.toDto(bookRepository.save(toUpdate));
    }

//
//    public TotalDto totalForId(String id) {
//        Double total=transactionRepository.findAllById(id).stream().mapToDouble(Transaction::getTotal).sum();
//        TotalDto totalDto=new TotalDto();
//        totalDto.setIdBook(id);
//        totalDto.setTotal(total);
//        return totalDto;
//    }
}
