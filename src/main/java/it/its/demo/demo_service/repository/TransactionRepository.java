package it.its.demo.demo_service.repository;

import it.its.demo.demo_service.exceptions.BookNotFoundException;
import it.its.demo.demo_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
