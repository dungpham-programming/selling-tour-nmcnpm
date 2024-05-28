package com.nmcnpm.model;

public class Transaction {
    private String id;
    private String paymentMethod;
    private double amount;
    private String currency;
    private String transactionStatus;
    private String transactionTime;
    private String transferorName;
    public Transaction(){}

    public Transaction(String id, String paymentMethod, double amount, String currency, String transactionStatus, String transactionTime, String transferorName) {
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.currency = currency;
        this.transactionStatus = transactionStatus;
        this.transactionTime = transactionTime;
        this.transferorName = transferorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getTransferorName() {
        return transferorName;
    }

    public void setTransferorName(String transferorName) {
        this.transferorName = transferorName;
    }
}
