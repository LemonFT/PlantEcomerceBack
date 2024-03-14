package com.ecommerce_plant.plant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce_plant.plant.model.ContactUser;

@Repository
public class ContactUserRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ContactUser> findAllContactUsers() {
        String sql = "SELECT * FROM contact_user";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ContactUser.class));
    }

    public boolean insertContactUser(ContactUser contactUser) {
        String sql = "INSERT INTO contact_user (user_id, address_category_id, address, phone_number) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, contactUser.getUser_id(), contactUser.getAddress_category_id(),
                contactUser.getAddress(), contactUser.getPhone_number()) > 0;
    }

    public boolean updateContactUser(ContactUser contactUser) {
        String sql = "UPDATE contact_user SET address_category_id = ?, address = ?, phone_number = ? WHERE user_id = ?";
        return jdbcTemplate.update(sql, contactUser.getAddress_category_id(), contactUser.getAddress(),
                contactUser.getPhone_number(), contactUser.getUser_id()) > 0;
    }

    public boolean deleteContactUser(int userId) {
        String sql = "DELETE FROM contact_user WHERE user_id = ?";
        return jdbcTemplate.update(sql, userId) > 0;
    }
}
