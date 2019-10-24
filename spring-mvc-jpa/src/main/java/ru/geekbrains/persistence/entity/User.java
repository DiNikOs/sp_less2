package ru.geekbrains.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name =  "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Product> productsUser;

    public User() {
    }

    public User(String name, String description) {
        this.name = name;
        this.description = description;
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

    public List<Product> getProductsUser() {
        return productsUser;
    }

    public void setProducts(List<Product> productsUser) {
        this.productsUser = productsUser;
    }
}
