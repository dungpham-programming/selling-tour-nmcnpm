package com.nmcnpm.payment.model;

public class OrderTour {
    private int id;
    private int customerId;
    private double total;
    private String note;
    private String paymentTransactionId;

    public OrderTour() {
    }

    public OrderTour(int id, int customerId, double total, String note, String paymentTransactionId) {
        this.id = id;
        this.customerId = customerId;
        this.total = total;
        this.note = note;
        this.paymentTransactionId = paymentTransactionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(String paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    @Override
    public String toString() {
        return "OrderTour{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", total=" + total +
                ", note='" + note + '\'' +
                ", paymentTransactionId='" + paymentTransactionId + '\'' +
                '}';
    }
}