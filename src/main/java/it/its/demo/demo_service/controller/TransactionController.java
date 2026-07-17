package it.its.demo.demo_service.controller;

import it.its.demo.demo_service.dto.TotalDto;
import it.its.demo.demo_service.model.Transaction;
import it.its.demo.demo_service.repository.TransactionRepository;
import it.its.demo.demo_service.service.BookService;
import it.its.demo.demo_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/allTrans")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Transaction> cerca(){
        return transactionService.findAll();
    }


//    @PostMapping("/{id}/total")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public TotalDto fai(
//            @PathVariable String id
//    ) {
//        return bookService.totalForId(id);
//    }
}
