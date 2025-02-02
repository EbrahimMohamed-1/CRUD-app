package com.crudApp.dao;

import com.crudApp.model.Product;
import com.crudApp.model.ProductDetails;

import java.util.List;

public interface ProductDAO {
    // insert all product details
    Product insert(ProductDetails productDetails);
    Product findById(int id);
    ProductDetails findByProductDetails(int id);
    void deleteById(int id);
    ProductDetails update(ProductDetails productDetails);
    List<Product> getAllProducts();
    List<Product> search(String Name);


}
