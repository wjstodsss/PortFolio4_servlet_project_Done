package com.blacksmith.banchan.payment.dto;

public class PaymentGatewayVO {
    private int id;
    private String cardNumber;
    private int expirationMM;
    private int expirationYY;
    private String cvc;
    private String cardHolderName;

    // 생성자, getter 및 setter 메서드

    public PaymentGatewayVO() {
    }

    public PaymentGatewayVO(int id, String cardNumber, int expirationMM, int expirationYY, String cvc, String cardHolderName) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationMM = expirationMM;
        this.expirationYY = expirationYY;
        this.cvc = cvc;
        this.cardHolderName = cardHolderName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getExpirationMM() {
        return expirationMM;
    }

    public void setExpirationMM(int expirationMM) {
        this.expirationMM = expirationMM;
    }

    public int getExpirationYY() {
        return expirationYY;
    }

    public void setExpirationYY(int expirationYY) {
        this.expirationYY = expirationYY;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
