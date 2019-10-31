package ru.geekbrains.controller.repr;

import java.math.BigDecimal;

public class ProductRepr {

    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private Long categoryId;

    private String categoryName;
    private BigDecimal sortMin;
    private BigDecimal sortMax;

    public ProductRepr() {
    }

    public ProductRepr(Long id, String name, String description, BigDecimal price, Long categoryId, String categoryName, BigDecimal sortMin, BigDecimal sortMax) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.sortMin = sortMin;
        this.sortMax = sortMax;
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

    public BigDecimal getSortMin() {
        return sortMin;
    }

    public BigDecimal getSortMax() {
        return sortMax;
    }

    public void setSortMin(BigDecimal sortMin) {
        this.sortMin = sortMin;
    }

    public void setSortMax(BigDecimal sortMax) {
        this.sortMax = sortMax;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
