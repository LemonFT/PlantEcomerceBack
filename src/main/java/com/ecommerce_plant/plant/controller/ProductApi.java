package com.ecommerce_plant.plant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecommerce_plant.plant.model.Product;
import com.ecommerce_plant.plant.service.ProductService;

@Controller
@RequestMapping("api/product")
@CrossOrigin("*")
public class ProductApi {

    @Autowired
    ProductService productServer;

    @GetMapping("")
    public ResponseEntity<?> getAllProduct() {
        return ResponseEntity.ok().body(productServer.getAllProduct());
    }

    @PostMapping("")
    public ResponseEntity<?> insertProduct(@RequestBody Product product) {
        String result = productServer.insertProduct(product);
        return result.equals("Insert successfully") ? ResponseEntity.ok().body(result)
                : ResponseEntity.badRequest().body(result);
    }

    @PutMapping("")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        String result = productServer.updateProduct(product);
        return result.equals("Update successfully") ? ResponseEntity.ok().body(result)
                : ResponseEntity.badRequest().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {
        String result = productServer.deleteProduct(id);
        return result.equals("Delete successfully") ? ResponseEntity.ok().body(result)
                : ResponseEntity.badRequest().body(result);
    }
}
