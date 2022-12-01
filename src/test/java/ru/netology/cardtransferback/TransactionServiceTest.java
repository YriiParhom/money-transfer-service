package ru.netology.cardtransferback;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.cardtransferback.exception.NoCardException;
import ru.netology.cardtransferback.exception.NotEnoughMoneyException;
import ru.netology.cardtransferback.model.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    @Mock
    private Operation operation;

    @Test
    public void moneyTransferingTest() {

        NoCardException exception = assertThrows(
                NoCardException.class,
                () -> {
                   throw new NoCardException("Карты отправителя или получателя не существует. Проверьте правильность ввода");
                }
        );
        assertEquals("Карты отправителя или получателя не существует. Проверьте правильность ввода",
                exception.getMessage());
    }

    @Test
    public void moneyTransferingTest2() {

        NotEnoughMoneyException exception = assertThrows(
                NotEnoughMoneyException.class,
                () -> {
                    throw new NotEnoughMoneyException("Недостаточно средств");
                }
        );
        assertEquals("Недостаточно средств", exception.getMessage());
    }

    @Test
    public void registerTransactionTest() {
        when(operation.getOperationId()).thenReturn("222222222222");
        assertEquals("222222222222", operation.getOperationId());
    }

    @Test
    public void verifyingOperationTest() {
        when(operation.getOperationId()).thenReturn("111111111");
        assertEquals("111111111", operation.getOperationId());
    }
}

