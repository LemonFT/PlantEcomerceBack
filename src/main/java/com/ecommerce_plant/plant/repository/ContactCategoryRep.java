package com.ecommerce_plant.plant.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ecommerce_plant.plant.model.ContactCategory;

@Repository
public class ContactCategoryRep {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ContactCategory> findAllContactCategories() {
        String sql = "SELECT * FROM contact_category";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(ContactCategory.class));
    }

    public boolean insertContactCategory(ContactCategory contactCategory) {
        String sql = "INSERT INTO contact_category (name) VALUES (?)";
        return jdbcTemplate.update(sql, contactCategory.getName()) > 0;
    }

    public boolean updateContactCategory(ContactCategory contactCategory) {
        String sql = "UPDATE contact_category SET name = ? WHERE id = ?";
        return jdbcTemplate.update(sql, contactCategory.getName(), contactCategory.getId()) > 0;
    }

    public boolean deleteContactCategory(int id) {
        String sql = "DELETE FROM contact_category WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }
}
