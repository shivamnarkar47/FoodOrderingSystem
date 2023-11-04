package com.foodOrdering.backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Document
public class Order {
    @Id
    private String id;

    @NotBlank
    @Size(max = 20)
    private String orderId;

    @NotBlank
    @Size(max = 200)
    private String userName;

    @NotBlank
    @Size(max = 30)
    private String orderDetails;

    @NotBlank
    @Size(max = 200)
    private String imgURL;

    @Size(max = 30000)
    private int price;

    @NotBlank
    @Size(max = 10)
    private int quantity;

    @NotBlank
    @Size(max = 200)
    private String location;

    @NotBlank
    @Size(max = 200)
    private String restaurant;

    @NotBlank
    private Boolean completed;

    @NotBlank
    private Boolean available;

    public Order(String orderId, String userName,
            String orderDetails, String imgURL, int price, int quantity,
            String location, String restaurant, Boolean completed, Boolean available) {
        // this.id = id;
        this.orderId = orderId;
        this.userName = userName;
        this.orderDetails = orderDetails;
        this.price = price;
        this.imgURL = imgURL;
        this.quantity = quantity;
        this.location = location;
        this.restaurant = restaurant;
        this.completed = completed;
        this.available = available;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
