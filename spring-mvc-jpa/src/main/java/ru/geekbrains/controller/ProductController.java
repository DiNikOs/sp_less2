package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.controller.repr.ProductReprUser;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.service.UserService;

import java.math.BigDecimal;

@Controller
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    private final CategoryService categoryService;

    private final UserService userService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, UserService userService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String products(@RequestParam(name = "categoryId", required = false) Long categoryId,
                           Model model) {
        model.addAttribute("categories", categoryService.findAllWithoutProducts());
        if (categoryId == null || categoryId == -1) {
            model.addAttribute("products", productService.findAll());
        } else {
            model.addAttribute("products", productService.getAllByCategory_Id(categoryId));
        }
        return "products";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createProductFrom(@RequestParam("categoryId") Long categoryId, Model model) {
        model.addAttribute("product", productService.getEmptyProductReprWithCategory(categoryId));
        return "product";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductReprById(id)
                .orElseThrow(() -> new IllegalStateException("Product not found")));
        return "product";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductRepr productRepr) {
        productService.save(productRepr);
        return "redirect:/categories/edit?id=" + productRepr.getCategoryId();
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createProductUserFrom(@RequestParam("userId") Long userId, Model model) {
        model.addAttribute("product", productService.getEmptyProductReprWithUser(userId));
        return "product";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editProductUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductReprUserById(id)
                .orElseThrow(() -> new IllegalStateException("Product not found")));
        return "product";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createOrder(@ModelAttribute("product") ProductReprUser productReprUser) {
        productService.save(productReprUser);
        return "redirect:/users/edit?id=" + productReprUser.getUserId();
    }

}
