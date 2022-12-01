package ru.netology.cardtransferback.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.netology.cardtransferback.exception.NoCardException;
import ru.netology.cardtransferback.exception.NotEnoughMoneyException;

@RestControllerAdvice()
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoCardException.class)
    public ResponseEntity<TextException> noCardException(NoCardException e) {
        return new ResponseEntity<>(new TextException("Карты отправителя или получателя " +
                "не существует. Проверьте правильность ввода данных"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<TextException> notEnoughMoneyException(NotEnoughMoneyException e) {
        return new ResponseEntity<>(new TextException("Недостаточно средств"), HttpStatus.BAD_REQUEST);
    }

    @Data
    @AllArgsConstructor
    private static class TextException {
        private String message;
    }

}
