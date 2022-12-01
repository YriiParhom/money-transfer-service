package ru.netology.cardtransferback.model;

public class Operation {
    private String operationId;

    public Operation(String operationId) {
        this.operationId = operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }
}
