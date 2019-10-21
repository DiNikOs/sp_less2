package ru.geekbrains.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Repository {

    private static final Logger logger = LoggerFactory.getLogger(Repository.class);

    static List<Product> list = new ArrayList<>();


    public static void insert(Product product)  {
        list.add(new Product(-1L, "", -1L));

    }

    public static void update(Product product) {

    }

    public static void delete(long id) {

    }

    public Product findById(long id) {
        return new Product(-1L, "", -1L);
    }

    public static List<Product> findAll()  {
            List<Product> res = new ArrayList<>();

            return res;
        }

}
