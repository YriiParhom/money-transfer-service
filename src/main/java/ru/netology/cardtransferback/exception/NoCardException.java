package ru.netology.cardtransferback.exception;

public class NoCardException extends RuntimeException{
    public NoCardException(String message) {
        super(message);
    }
}