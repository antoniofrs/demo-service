package it.its.demo.demo_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_category", // Il nome della tabella ponte che verrà creata su Postgres
            joinColumns = @JoinColumn(name = "book_id"), // Chiave esterna verso questa entità (Book)
            inverseJoinColumns = @JoinColumn(name = "category_id") // Chiave esterna verso l'altra entità (Category)
    )
    private List<Category> categories = new ArrayList<>();


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setBook(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setBook(null);
    }
}

/*
*
* {
 *   "id": "1234",
 *   "name": "Il piccolo principe",
 *   "author": "Antoine"
* }

* */
