package edu.t1.task5.controller;

import edu.t1.task5.entity.Product;
import edu.t1.task5.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getProduct/{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) throws SQLException {
        return productService.getProductById(productId);
    }

    @GetMapping(value = "/getAllProduct/{userId}")
    public List<Product> getAllByUserId(@PathVariable("userId")Long userId) throws SQLException {
        return productService.getAllByUserId(userId);
    }

    @PostMapping(value = "/updateProduct/{productId}/{count}")
    public void updateProductById(@PathVariable("productId")Long productId, @PathVariable("count")Long count) throws SQLException {
        productService.updateProduct(productId, count);
    }
}
