package it.its.demo.demo_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    String id;

    String name;
    Integer quantity;
    Float price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_author_id")
    Author author;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Transaction> transactions;
<<<<<<< Updated upstream
=======

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setBook(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setBook(null);
    }
>>>>>>> Stashed changes
}

/*
*
* {
 *   "id": "1234",
 *   "name": "Il piccolo principe",
 *   "author": "Antoine"
* }

* */
