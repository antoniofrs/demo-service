package it.its.demo.demo_service.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    //la chiave sarà di tipo integer a differenza del libro.
    //Usiamo il generationType identity perchè è di tipo numerico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    @OneToMany(mappedBy = "author")
    //@JsonManagedReference
    private List<Book> books;
}
