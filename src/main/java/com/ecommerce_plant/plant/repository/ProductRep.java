package com.ecommerce_plant.plant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce_plant.plant.model.Product;

@Repository
public class ProductRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> findAllProducts() {
        String sql = "SELECT * FROM product where display = true and deleted = false";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Product.class));
    }

    public boolean insertProduct(Product product) {
        String sql = "INSERT INTO product (code, name, category_product_id, description, amount, price, voucher) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, product.getCode(), product.getName(), product.getCategory_product_id(),
                product.getDescription(), product.getAmount(), product.getPrice(), product.getVoucher()) > 0;
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE product SET code = ?, name = ?, category_product_id = ?, description = ?, amount = ?, price = ?, voucher = ?, display = ? WHERE id = ?";
        return jdbcTemplate.update(sql, product.getCode(), product.getName(), product.getCategory_product_id(),
                product.getDescription(), product.getAmount(), product.getPrice(), product.getVoucher(),
                product.isDisplay(), product.getId()) > 0;
    }

    public boolean hardDeleteProduct(int id) {
        String sql = "DELETE FROM product WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    public boolean SoftdeleteProduct(int id) {
        String sql = "UPDATE product SET deleted = ?, display = ? WHERE id = ?";
        return jdbcTemplate.update(sql, 1, 0, id) > 0;
    }
}
