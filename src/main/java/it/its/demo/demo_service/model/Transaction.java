package it.its.demo.demo_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String idTrans;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    Double total;
    private Integer qntBought;

}
