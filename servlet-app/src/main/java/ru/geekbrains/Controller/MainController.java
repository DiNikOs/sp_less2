package ru.geekbrains.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.Repository.Product;
import ru.geekbrains.Repository.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String mainPage(Model model) {
        model.addAttribute("msgList", Arrays.asList(
                new Message("Hello"),
                new Message("World"),
                new Message("!!!")
        ));
        return "index";
    }

    List<Product> list = new ArrayList<>();
//    private ProductService productService;

//        @Autowired
//    public ProductService setProductService (ProductService productService) {
//        this.productService = productService;
//    }
//
//    @RequestMapping(value="/", method = RequestMethod.GET)
//    public String showAllProducts (Model uiModel) {
//        // Получаем всех авторов из базы данных
//        List<Product> products = productService.getAll();
//        // Добавление списка авторов в объект модели для отображения их имен на странице
//        uiModel.addAttribute("products", products);
//        return "home";
//    }
//
//        @RequestMapping(value="/{id}", method = RequestMethod.GET)
//    public String home (Model uiModel, @PathVariable(value = "id") Long id) {
//        Product product = productService.get(id);
//        uiModel.add("product", product);
//        return "home";
//    }
//
//    @RequestMapping(value="/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public String hello (@PathVariable(value = "id") Long id) {
//        Product product = productService.get(id);
//        return product.getTitle();
//    }


    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private Repository repository;

    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getAllProduct() {
        return Repository.findAll();
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml";
    }

    public String saveProduct() {
        if (product.getId() == null) {
            Repository.insert(product);
        } else {
            Repository.update(product);
        }
        return "/index.xhtml";
    }

    public void deleteProduct(Product product){
        logger.info("Deleting Product.");
        Repository.delete(product.getId());
    }

    public String editProduct(Product product) {
        this.product = product;
        return "/product.xhtml";
    }

}
