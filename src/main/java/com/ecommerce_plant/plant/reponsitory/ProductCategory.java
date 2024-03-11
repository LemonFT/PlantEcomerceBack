package com.ecommerce_plant.plant.reponsitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCategory {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean insertCategory() {
        return jdbcTemplate.update("insert into product_category values(1, 'Nguyen', 'Nguyen')") > 0;
    }
}