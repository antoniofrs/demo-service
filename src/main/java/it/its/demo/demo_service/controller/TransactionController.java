package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.TotalDto;
import it.its.demo.demo_service.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books/transaction")
public class TransactionController {

    private final BookService bookService;

    public TransactionController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}/total")
    @ResponseStatus(HttpStatus.OK)
    public TotalDto doTotal(@PathVariable String id){
        return bookService.totalSellBookId(id);
    }
}
