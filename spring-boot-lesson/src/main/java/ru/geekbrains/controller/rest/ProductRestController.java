package ru.geekbrains.controller.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
//import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.controller.repr.ProductFilter;
import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.persistence.entity.Product;
import ru.geekbrains.service.ProductService;

import java.util.List;

@RequestMapping("/api/product")
@RestController
public class ProductRestController {
    private ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/all")
    public List<ProductRepr> getAllProducts(){
        return productService.findAllByProduct();
    }

    @GetMapping(value = "/{id}/id")
    public Product getProduct(@PathVariable("id") Long id) {
        return productService.findByIdProduct(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateProduct(@RequestBody ProductRepr product) {
        productService.save(product);
    }

    @DeleteMapping(value = "/{id}/id")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }

}
