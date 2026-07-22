package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
<<<<<<< Updated upstream
@NoArgsConstructor
@AllArgsConstructor
public class InnerTransactionDto {
    String id;
    Float totale;
=======
@AllArgsConstructor
@NoArgsConstructor
public class InnerTransactionDto {

    private String id;
    private Float total;

>>>>>>> Stashed changes
}
