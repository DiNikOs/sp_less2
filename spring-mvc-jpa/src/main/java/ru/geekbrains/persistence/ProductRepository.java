package ru.geekbrains.persistence;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findTopByOrderByPriceAsc();
    List<Product> findTopByOrderByPriceDesc();
    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByPriceDesc();

    List<Product> getAllByCategory_Id(Long categoryId);
    List<Product> getAllByCategory_Id(Long categoryId, Pageable pageable);

    List<Product> getAllByUser_Id(Long userId);
    List<Product> getAllByUser_Id(Long userId, Pageable pageable);

    List<Product> findAllByUser_Id(Long userId);



    @Query("select new ru.geekbrains.controller.repr.ProductRepr(" +
            "p.id, p.name, " +
            "p.description, " +
            "p.price, " +
            "p.category.id, " +
            "p.category.name) " +
            "from Product p " +
            "where p.id = :id")

    Optional<ProductRepr> getProductReprById(@Param("id") Long id);
}
