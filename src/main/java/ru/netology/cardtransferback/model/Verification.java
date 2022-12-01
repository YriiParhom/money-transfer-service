package ru.netology.cardtransferback.model;

public class Verification {
    private String operationId;
    private String code;

    public Verification(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }
}
