package ru.geekbrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.controller.repr.ProductRepr;
import ru.geekbrains.persistence.CategoryRepository;
import ru.geekbrains.persistence.ProductRepository;
import ru.geekbrains.persistence.UserRepository;
import ru.geekbrains.persistence.entity.Category;
import ru.geekbrains.persistence.entity.Product;
import ru.geekbrains.persistence.entity.User;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.service.UserService;

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
//        model.addAttribute("categories", categoryRepository.findAll());
//        if (categoryId == null || categoryId == -1) {
//            model.addAttribute("products", productRepository.findAll());
//        } else if (categoryId == 12) {
//            model.addAttribute("products", productRepository.findTopByOrderByPriceAsc());
//        } else if (categoryId == 13) {
//            model.addAttribute("products", productRepository.findTopByOrderByPriceDesc());
//        } else if (categoryId == 14) {
//            model.addAttribute("products", productRepository.findTopByOrderByPriceAsc());
//        } else if (categoryId == 15) {
//            model.addAttribute("products", productRepository.findByOrderByPriceAsc());
//        } else if (categoryId == 16) {
//            model.addAttribute("products", productRepository.findByOrderByPriceDesc());
//        }else {
//            model.addAttribute("products", productRepository.getAllByCategory_Id(categoryId));
//        }
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

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute("product") ProductRepr productRepr) {
        productService.save(productRepr);
        return "redirect:/categories/edit?id=" + productRepr.getCategoryId();
    }



//    @RequestMapping(value = " ", method = RequestMethod.GET)
//    public String productsUser(@RequestParam(name = "userId", required = false) Long userId,
//                               Model model) {
//        model.addAttribute("users", userRepository.findAll());
//        if (userId == null || userId == -1) {
//            model.addAttribute("productsUser", productRepository.findAll());
//        } else {
//            model.addAttribute("productsUser", productRepository.getAllByUser_Id(userId));
//        }
//        return "productsUser";
//    }
//
//    @RequestMapping(value = "createUser", method = RequestMethod.GET)
//    public String createProductUserFrom(@RequestParam("userId") Long userId, Model model) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new IllegalStateException("User not found"));
//        Product product = new Product();
//        product.setUser(user);
//        model.addAttribute("productUser", product);
//        return "productUser";
//    }
//
//    @RequestMapping(value = "createUser", method = RequestMethod.POST)
//    public String createProductUser(@ModelAttribute("productUser") Product product) {
//        product.setUser(userRepository.findById(product.getUserId())
//                .orElseThrow(() -> new IllegalStateException("User not found")));
//        productRepository.save(product);
//        return "redirect:/users/edit?id=" + product.getUser().getId();
//    }
}
