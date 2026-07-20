package it.its.demo.demo_service.repository;


import it.its.demo.demo_service.dto.TotalDto;
import it.its.demo.demo_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

    List<Transaction> findAllByBook_Id(String idBook);

//    public Transaction save(Transaction transaction) {
//        transactionList.add(transaction);
//        return transaction;
//    }
//
//    public List<Transaction> findAll(){
//        return  transactionList;
//    }
//
//    public List<Transaction> findAllById(String idBook) {
//       return transactionList.stream().filter(a->a.getIdBook().equals(idBook)).toList();
//    }


}
