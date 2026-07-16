package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.TotalDto;
import it.its.demo.demo_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class TransactionController {

    @Autowired
    private BookService bookService;

//    @PostMapping("/{id}/total")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public TotalDto fai(
//            @PathVariable String id
//    ) {
//        return bookService.totalForId(id);
//    }
}
