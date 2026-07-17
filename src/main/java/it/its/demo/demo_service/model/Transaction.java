package it.its.demo.demo_service.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Transaction {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String idTrans;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    private Double total;
    private Integer quantityBought;

}
