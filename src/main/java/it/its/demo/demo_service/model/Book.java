package it.its.demo.demo_service.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    String name;
    //andiamo a cambiare la struttura del author, non è più una stringa, ma un oggetto.
    //String author;
    Integer quantity;
    Double price;

    @ManyToOne
    @JoinColumn(name = "fk_author_id")
    //@JsonBackReference
    Author author;
}

/*
*
* {
 *   "id": "1234",
 *   "name": "Il piccolo principe",
 *   "author": "Antoine"
* }

* */
