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
<<<<<<< Updated upstream
    String id;

    Float total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_book_id")
    Book book;
=======
    private String id;

    private Float total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_book_id")
    private Book book;
>>>>>>> Stashed changes
}
