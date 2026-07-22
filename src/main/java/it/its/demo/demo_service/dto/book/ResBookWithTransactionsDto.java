package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
<<<<<<< Updated upstream
=======

>>>>>>> Stashed changes
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResBookWithTransactionsDto extends ResBookDto{
<<<<<<< Updated upstream
    List<InnerTransactionDto> transactionList;
=======

    private List<InnerTransactionDto> transactions;

>>>>>>> Stashed changes
}
