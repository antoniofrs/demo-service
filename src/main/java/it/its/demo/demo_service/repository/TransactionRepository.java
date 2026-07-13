package it.its.demo.demo_service.repository;

import it.its.demo.demo_service.dto.TotalDto;
import it.its.demo.demo_service.model.Book;
import it.its.demo.demo_service.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public Transaction save(Transaction transaction){
        transactions.add(transaction);
        return transaction;
    }

    public List<Transaction> findAllTra(){return transactions;}

    public List<Transaction> findByIdBook(String idBook){
       return transactions.stream().filter(transaction -> transaction.getIdBook().equals(idBook)).toList();
    }

    public Integer totalByIdBook(String idBook){
      Integer qntBook= transactions.stream().filter(transaction -> transaction.getIdBook().equals(idBook)).mapToInt(trans->trans.getQntSell()).sum();
      return qntBook;
    }

}
