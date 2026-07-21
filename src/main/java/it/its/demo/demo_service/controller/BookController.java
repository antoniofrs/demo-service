package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.book.ResBookDto;
import it.its.demo.demo_service.dto.BuyRequest;
import it.its.demo.demo_service.dto.book.ReqInsertBook;
import it.its.demo.demo_service.dto.book.ReqPatchBook;
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
    public ResBookDto insert (
            @Valid @RequestBody ReqInsertBook book
    ) {
        return bookService.insert(book);
    }

    @PatchMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto patch (
            @PathVariable String id,
            @RequestBody ReqPatchBook reqPatchBook
    ) {
        return bookService.patch(id, reqPatchBook);
    }

    @PutMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto put (
            @PathVariable String id,
            @RequestBody ReqInsertBook reqInsertBook
    ) {
        return bookService.put(id, reqInsertBook);
    }
//
//    @GetMapping("/v1")
//    @ResponseStatus(HttpStatus.OK)
//    public List<BookDto> findAll(){
//        return bookService.findAll();
//    }
//
    @GetMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto findById(
            @PathVariable String id
    ){
        return bookService.findById(id);
    }
//
    @GetMapping("/search/v1")
    @ResponseStatus(HttpStatus.OK)
    public List<ResBookDto> findByName(
            @RequestParam String name
    ){
        return bookService.findByName(name);
    }
//
    @DeleteMapping("/{id}/v1")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable String id
    ){
       bookService.delete(id);
    }
//
    @PostMapping("/{id}/buy/v1")
    @ResponseStatus(HttpStatus.OK)
    public ResBookDto buy(
            @PathVariable String id,
            @Valid @RequestBody BuyRequest buyRequest
    ){
        return bookService.buy(id, buyRequest);
    }
}
