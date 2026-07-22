package it.its.demo.demo_service.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResBookWithTransactionsDto extends ResBookDto{
    private List<InnerTransactionDto> transactions;

}
