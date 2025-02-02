package com.crudApp.service;


import com.crudApp.model.Product;
import com.crudApp.model.ProductDetails;

import java.util.List;

public interface ProductService {

    ProductDetails insert(ProductDetails product) ;
    Product findById(int id);
     ProductDetails findByProductDetails(int id);
    void deleteById(int id);
    ProductDetails update(ProductDetails product);
    List<Product> getAllProducts();
    List<Product> search(String name);

}