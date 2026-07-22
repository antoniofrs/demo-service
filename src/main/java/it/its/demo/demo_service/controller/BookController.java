package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.book.*;
import it.its.demo.demo_service.dto.transaction.ReqBuyDto;
import it.its.demo.demo_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/v1")
    @ResponseStatus(HttpStatus.CREATED)
    public ResBookDto insert (@Valid @RequestBody ReqInsertBookDto book) {
        return bookService.insert(book);
    }

    @PatchMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto patch (
            @PathVariable String id,
            @RequestBody ReqPatchBookDto patchBook
    ) {
        return bookService.patch(id, patchBook);
    }

    @PatchMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto patch (
            @Valid @RequestBody ReqPatchBookDtoWithIdDto patchBook
    ) {
        return bookService.patch(patchBook);
    }

    @PutMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto patch (
            @PathVariable String id,
            @RequestBody ReqInsertBookDto reqInsertBookDto
    ) {
        return bookService.put(id, reqInsertBookDto);
    }

    @PutMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto put (
            @Valid @RequestBody ReqPutBookDtoDto putBook
    ) {
        return bookService.put(putBook);
    }

    @GetMapping("/v1")
    @ResponseStatus(HttpStatus.OK)
    public List<ResBookDto> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto findById(
            @PathVariable String id
    ){
        return bookService.findById(id);
    }

    @GetMapping("/transactions/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto findByIdWithTransactions(
            @PathVariable String id
    ){
        return bookService.findByIdWithTransactions(id);
    }

    @GetMapping("/search/v1")
    @ResponseStatus(HttpStatus.OK)
    public List<ResBookDto> findByName(
            @RequestParam String name
    ){
        return bookService.findByName(name);
    }

    @DeleteMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id
    ){
       bookService.delete(id);
    }

    @PostMapping("/{id}/buy/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookWithTransactionsDto buy(
            @PathVariable String id,
            @Valid @RequestBody ReqBuyDto buyRequest
    ){
        return bookService.buy(id, buyRequest);
    }

//    @GetMapping("/{id}/buy/total/v1")
//    @ResponseStatus(HttpStatus.OK)
//    public TransactionTotalDto transactionTotal(
//            @PathVariable String id
//    ){
//        return bookService.total(id);
//    }
}
