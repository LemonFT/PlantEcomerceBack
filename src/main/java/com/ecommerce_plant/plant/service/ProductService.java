package com.ecommerce_plant.plant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce_plant.plant.model.Product;
import com.ecommerce_plant.plant.repository.ProductRep;

@Service
public class ProductService {

    @Autowired
    ProductRep productRep;

    public List<Product> getAllProduct() {
        return productRep.findAllProducts();
    }

    public String insertProduct(Product product) {
        product.setDisplay(true);
        product.setDeleted(false);
        boolean result = productRep.insertProduct(product);
        return result ? "Insert successfully" : "Insert false";
    }

    public String updateProduct(Product product) {
        product.setDeleted(false);
        boolean result = productRep.updateProduct(product);
        return result ? "Update successfully" : "Update fasle";
    }

    public String deleteProduct(int id) {
        try {
            return productRep.hardDeleteProduct(id) ? "Delete successfully" : "Delete false";
        } catch (Exception e) {
            return productRep.SoftdeleteProduct(id) ? "Delete successfully" : "Delete false";
        }
    }
}
