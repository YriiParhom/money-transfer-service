package ru.netology.cardtransferback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.cardtransferback.exception.NoCardException;
import ru.netology.cardtransferback.exception.NotEnoughMoneyException;
import ru.netology.cardtransferback.model.Card;
import ru.netology.cardtransferback.model.Operation;
import ru.netology.cardtransferback.model.Transaction;
import ru.netology.cardtransferback.model.Verification;
import ru.netology.cardtransferback.repository.CardRepository;

import java.util.Random;

@Service
public class TransactionService {
    private final CardRepository cardRepository;

    @Autowired
    public TransactionService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Operation registerTransaction(Transaction transaction) {
        String id;
        Random random = new Random();
        long idLong = random.nextLong() * 1000000;
        id = Long.toString(idLong);

        moneyTransfering(transaction);

        return new Operation(id);
    }

    public Operation verifyingOperation(Verification verification) {
        return new Operation(verification.getOperationId());
    }

    private void moneyTransfering(Transaction transaction) {
        try {
            Card cardFrom = cardRepository.getCardStorage().get(transaction.getCardFromNumber());
            Card cardTo = cardRepository.getCardStorage().get(transaction.getCardToNumber());
            if (transaction.getAmount().getValue() > cardFrom.getAmount().getValue()) {
                throw new NotEnoughMoneyException("Недостаточно средств");
            } else {
                cardFrom.getAmount().setValue(cardFrom.getAmount().getValue() - transaction.getAmount().getValue());
                cardTo.getAmount().setValue(cardTo.getAmount().getValue() + transaction.getAmount().getValue());
            }
        } catch (NullPointerException e) {
            throw new NoCardException("Карты отправителя или получателя не существует." +
                    "Проверьте правильность ввода");
        }
    }
}

