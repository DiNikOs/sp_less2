package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.persistence.CategoryRepository;
import ru.geekbrains.persistence.ProductRepository;
import ru.geekbrains.persistence.UserRepository;
import ru.geekbrains.persistence.entity.Category;
import ru.geekbrains.persistence.entity.Product;
import ru.geekbrains.persistence.entity.User;

@Controller
@RequestMapping("products")
public class ProductController {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String products(@RequestParam(name = "categoryId", required = false) Long categoryId,
                           Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        if (categoryId == null || categoryId == -1) {
            model.addAttribute("products", productRepository.findAll());
        } else if (categoryId == 12) {
            model.addAttribute("products", productRepository.findTopByOrderByPriceAsc());
        } else if (categoryId == 13) {
            model.addAttribute("products", productRepository.findTopByOrderByPriceDesc());
        } else if (categoryId == 14) {
            model.addAttribute("products", productRepository.findTopByOrderByPriceAsc());
        } else if (categoryId == 15) {
            model.addAttribute("products", productRepository.findByOrderByPriceAsc());
        } else if (categoryId == 16) {
            model.addAttribute("products", productRepository.findByOrderByPriceDesc());
        }else {
            model.addAttribute("products", productRepository.getAllByCategory_Id(categoryId));
        }
        return "products";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createProductFrom(@RequestParam("categoryId") Long categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalStateException("Category not found"));
        Product product = new Product();
        product.setCategory(category);
        model.addAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") Product product) {
        product.setCategory(categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new IllegalStateException("Category not found")));
        productRepository.save(product);
        return "redirect:/categories/edit?id=" + product.getCategory().getId();
    }

    @RequestMapping(value = " ", method = RequestMethod.GET)
    public String productsUser(@RequestParam(name = "userId", required = false) Long userId,
                               Model model) {
        model.addAttribute("users", userRepository.findAll());
        if (userId == null || userId == -1) {
            model.addAttribute("productsUser", productRepository.findAll());
        } else {
            model.addAttribute("productsUser", productRepository.getAllByUser_Id(userId));
        }
        return "productsUser";
    }

    @RequestMapping(value = "createUser", method = RequestMethod.GET)
    public String createProductUserFrom(@RequestParam("userId") Long userId, Model model) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));
        Product product = new Product();
        product.setUser(user);
        model.addAttribute("productUser", product);
        return "productUser";
    }

    @RequestMapping(value = "createUser", method = RequestMethod.POST)
    public String createProductUser(@ModelAttribute("productUser") Product product) {
        product.setUser(userRepository.findById(product.getUserId())
                .orElseThrow(() -> new IllegalStateException("User not found")));
        productRepository.save(product);
        return "redirect:/users/edit?id=" + product.getUser().getId();
    }
}
