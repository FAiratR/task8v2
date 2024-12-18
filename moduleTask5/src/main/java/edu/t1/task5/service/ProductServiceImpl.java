package edu.t1.task5.service;

import edu.t1.task5.entity.Product;
import edu.t1.task5.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements edu.t1.task5.service.ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product getProductById(Long productId) throws SQLException {
        return productRepo.getProductById(productId);
    }

    public List<Product> getAllByUserId(Long userId) throws SQLException {
        return productRepo.getAllByUserId(userId);
    }
    public void updateProduct(Long productId, Long count) throws SQLException {
        Product product = getProductById(productId);
        product.setBalance(count);
        productRepo.save(product);
    }
}
