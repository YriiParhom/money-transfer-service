package ru.netology.cardtransferback.repository;

import org.springframework.stereotype.Repository;
import ru.netology.cardtransferback.model.Amount;
import ru.netology.cardtransferback.model.Card;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CardRepository {
    private static Map<String, Card> cardStorage = new HashMap<>();

    static {
        cardStorage.put("1111222233334444", new Card("1111222233334444", "01/23", "123", new Amount(100000, "RUR")));
        cardStorage.put("5555666677778888", new Card("5555666677778888", "03/24", "456", new Amount(100000, "RUR")));
    }


    public Map<String, Card> getCardStorage() {
        return cardStorage;
    }
}
