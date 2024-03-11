package com.ecommerce_plant.plant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce_plant.plant.reponsitory.ProductCategory;

@Controller
@RequestMapping("/category")
public class ProductCategoryApi {

    @Autowired
    private ProductCategory productCategory;

    @GetMapping("/insert")
    @ResponseBody
    public String insertCategory() {
        boolean result = productCategory.insertCategory();
        if (result) {
            return "Insertion successful!";
        } else {
            return "Insertion failed!";
        }
    }
}