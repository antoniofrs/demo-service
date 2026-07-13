package it.its.demo.demo_service.service;

import it.its.demo.demo_service.model.Book;
import it.its.demo.demo_service.model.Transaction;
import it.its.demo.demo_service.repository.TransactionRepository;
import org.springframework.stereotype.Service;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void registraTransazione(Book book, Integer quantity){
        Transaction transaction = new Transaction();
        transaction.setBookId(book.getId());
        transaction.setBookName(book.getName());
        transaction.setPrice(book.getPrezzo() * quantity);
        transactionRepository.save(transaction);
    }

    public Double getTotaleGuadagnato(String bookId){
        return transactionRepository.findTransactionById(bookId).stream()
                .mapToDouble(Transaction::getPrice)
                .sum();
    }


}

