package ru.geekbrains.Controller;

import ru.geekbrains.Repository.Product;
import ru.geekbrains.Repository.Repository;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "ProductService", urlPatterns = {"", "/"})
public class ProductService extends HttpServlet {
    private Repository repository;
    List<Product> list = new ArrayList<>();
    Product product = new Product();

    public ProductService(Product product) {
        this.product = product;
        list.add(new Product(1,"aaa",1.0));
        list.add(new Product(2,"aaa",2.0));
    }


    public Product get (Long id) {
        if (list.contains(id)) {
            return product;
        }
        return null;
    }
}
