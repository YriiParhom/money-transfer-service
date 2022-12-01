package ru.netology.cardtransferback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.netology.cardtransferback.model.Operation;
import ru.netology.cardtransferback.model.Transaction;
import ru.netology.cardtransferback.model.Verification;
import ru.netology.cardtransferback.service.TransactionService;

@RestController
@RequestMapping("/")
@CrossOrigin
public class TransferController {
    private final TransactionService transactionService;
    private final Logger logger = LoggerFactory.getLogger(TransferController.class);

    @Autowired
    public TransferController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Operation> transferTransaction(@RequestBody Transaction transaction) {
        logger.debug(String.format("Перевод с карты %s на карту %s сумма перевода %d, валюта перевода %s",
                transaction.getCardFromNumber(), transaction.getCardToNumber(), transaction.getAmount().getValue(),
                transaction.getAmount().getCurrency()));

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionService.registerTransaction(transaction));
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<Operation> confirmOperation(@RequestBody Verification verification) {
        logger.debug(String.format("Перевод выполнен! Id перевода: %s, код подтверждения %s",
                verification.getOperationId(), verification.getCode()));
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionService.verifyingOperation(verification));
    }
}
