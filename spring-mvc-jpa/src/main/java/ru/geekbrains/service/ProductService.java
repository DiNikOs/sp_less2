package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.controller.repr.ProductReprUser;
import ru.geekbrains.persistence.CategoryRepository;
import ru.geekbrains.persistence.ProductRepository;
import ru.geekbrains.persistence.UserRepository;
import ru.geekbrains.persistence.entity.Category;
import ru.geekbrains.persistence.entity.Product;
import ru.geekbrains.persistence.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    private UserRepository userRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Product> getAllByCategory_Id(Long categoryId) {
        return productRepository.getAllByCategory_Id(categoryId);
    }

    @Transactional(readOnly = true)
    public Optional<ProductRepr> getProductReprById(Long id) {
        return productRepository.getProductReprById(id);
    }

    @Transactional(readOnly = true)
    public ProductRepr getEmptyProductReprWithCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category not found"));
        ProductRepr productRepr = new ProductRepr();
        productRepr.setCategoryId(category.getId());
        productRepr.setCategoryName(category.getName());
        return productRepr;
    }

    @Transactional
    public void save(ProductRepr productRepr) {
        Product product = new Product();
        product.setId(productRepr.getId());
        product.setName(productRepr.getName());
        product.setPrice(productRepr.getPrice());
        product.setDescription(productRepr.getDescription());
        product.setCategory(categoryRepository.findById(productRepr.getCategoryId())
                .orElseThrow(() -> new IllegalStateException("Category not found")));
        productRepository.save(product);
    }


    @Transactional(readOnly = true)
    public List<Product> findAllByUser_Id(Long userId) {
        return productRepository.findAllByUser_Id(userId);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllByUser_Id(Long userId) {
        return productRepository.getAllByCategory_Id(userId);
    }

    @Transactional(readOnly = true)
    public Optional<ProductRepr> getProductReprUserById(Long id) {
        return productRepository.getProductReprById(id);
    }

    @Transactional(readOnly = true)
    public ProductReprUser getEmptyProductReprWithUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        ProductReprUser productReprUser = new ProductReprUser();
        productReprUser.setUserId(user.getId());
        productReprUser.setUserName(user.getName());
        return productReprUser;
    }

    @Transactional
    public void save(ProductReprUser productReprUser) {
        Product product = new Product();
        product.setId(productReprUser.getId());
        product.setName(productReprUser.getName());
        product.setPrice(productReprUser.getPrice());
        product.setDescription(productReprUser.getDescription());
        product.setUser(userRepository.findById(productReprUser.getUserId())
                .orElseThrow(() -> new IllegalStateException("User not found")));
        productRepository.save(product);
    }
}
