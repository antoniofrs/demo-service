package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InnerTransactionDto {

    private String id;
    private Float total;

}
