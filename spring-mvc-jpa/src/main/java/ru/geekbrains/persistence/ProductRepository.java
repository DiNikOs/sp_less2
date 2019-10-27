package ru.geekbrains.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persistence.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getAllByCategory_Id(Long categoryId);
    List<Product> getAllByUser_Id(Long userId);
    List<Product> findTopByOrderByPriceAsc();
    List<Product> findTopByOrderByPriceDesc();
    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByPriceDesc();
}
