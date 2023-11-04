package com.foodOrdering.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document(collection = "transactions")
public class Transaction {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String transactionName;

    @NotBlank
    @Size(max = 50)
    private String orderDetails;

    @NotBlank
    @Size(max = 120)
    private String payment_mode;

    @NotBlank
    @Size(max = 120)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String date;

    public Transaction(@NotBlank @Size(max = 20) String transactionName,
            @NotBlank @Size(max = 50) String orderDetails, @NotBlank @Size(max = 120) String payment_mode,
            String username,
            @NotBlank @Size(max = 120) String date) {
        this.transactionName = transactionName;
        this.orderDetails = orderDetails;
        this.payment_mode = payment_mode;
        this.username = username;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getPayment_mode() {
        return payment_mode;
    }

    public void setPayment_mode(String payment_mode) {
        this.payment_mode = payment_mode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
