package edu.t1.task5.service;

import edu.t1.task5.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public Product getProductById(Long productId) throws SQLException;
    public List<Product> getAllByUserId(Long userId) throws SQLException;
    public void updateProduct(Long productId, Long count) throws SQLException;
}
