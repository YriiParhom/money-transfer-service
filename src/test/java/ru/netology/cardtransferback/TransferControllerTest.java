package ru.netology.cardtransferback;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.netology.cardtransferback.controller.TransferController;
import ru.netology.cardtransferback.model.Amount;
import ru.netology.cardtransferback.model.Operation;
import ru.netology.cardtransferback.model.Transaction;
import ru.netology.cardtransferback.service.TransactionService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest(TransferController.class)
public class TransferControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;


    @Test
    public void transferTransactionTest() throws Exception {

        Transaction transaction = mock(Transaction.class);
        Operation operation = mock(Operation.class);
        Amount amount = mock(Amount.class);
        when(transaction.getCardFromNumber()).thenReturn("1111222233334444");
        when(transaction.getCardFromValidTill()).thenReturn("01/23");
        when(transaction.getCardFromCVV()).thenReturn("123");
        when(transaction.getCardToNumber()).thenReturn("5555666677778888");
        when(amount.getValue()).thenReturn(1000);
        when(amount.getCurrency()).thenReturn("RUR");
        when(operation.getOperationId()).thenReturn("000000000");
        when(transactionService.registerTransaction(transaction)).thenReturn(operation);
        assertEquals(operation, transactionService.registerTransaction(transaction));
    }
}
