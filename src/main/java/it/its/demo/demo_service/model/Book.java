package it.its.demo.demo_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    String id;
    String name;
    String author;
    Integer quantity;
    String description;
    Double price;
}

/*
*
* {
 *   "id": "1234",
 *   "name": "Il piccolo principe",
 *   "author": "Antoine"
* }

* */
