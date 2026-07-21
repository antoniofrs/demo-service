package it.its.demo.demo_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    Float total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_book_id")
    Book book;
}
