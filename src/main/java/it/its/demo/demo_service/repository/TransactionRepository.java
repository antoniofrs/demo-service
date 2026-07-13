package it.its.demo.demo_service.repository;

import it.its.demo.demo_service.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {

    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> findAll() {
        return transactions;
    }

    public List<Transaction> findTransactionById(String bookID) {
        return transactions.stream()
                .filter(t -> t.getBookId().equals(bookID))
                .collect(Collectors.toList());
    }


}
