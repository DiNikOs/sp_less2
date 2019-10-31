package ru.geekbrains.controller.repr;

import java.math.BigDecimal;

public class ProductReprUser {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long userId;

    private String userName;

    public ProductReprUser() {
    }

    public ProductReprUser(Long id, String name, String description, BigDecimal price, Long userId, String userName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long categoryId) {
        this.userId = categoryId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
