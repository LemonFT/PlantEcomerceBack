package com.ecommerce_plant.plant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce_plant.plant.model.Cart;

@Repository
public class CartRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public List<Cart> findAllCartsByUserId(int user_id) {
        String sql = "SELECT * FROM cart where user_id = ?";
        return jdbcTemplate.query(sql, new Object[] { user_id }, BeanPropertyRowMapper.newInstance(Cart.class));
    }

    public boolean insertCart(Cart cart) {
        String sql = "INSERT INTO cart (user_id, product_id, number) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, cart.getUser_id(), cart.getProduct_id(), cart.getNumber()) > 0;
    }

    public boolean updateCart(Cart cart) {
        String sql = "UPDATE cart SET number = ? WHERE user_id = ? AND product_id = ?";
        return jdbcTemplate.update(sql, cart.getNumber(), cart.getUser_id(), cart.getProduct_id()) > 0;
    }

    public boolean deleteCart(int userId, int productId) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
        return jdbcTemplate.update(sql, userId, productId) > 0;
    }
}
