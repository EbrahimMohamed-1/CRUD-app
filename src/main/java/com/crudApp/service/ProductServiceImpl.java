package com.crudApp.service;

import com.crudApp.dao.ProductDAO;
import com.crudApp.model.Product;
import com.crudApp.model.ProductDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Transactional(rollbackFor = Exception.class)
    public ProductDetails insert(ProductDetails product)  {
        productDAO.insert(product);

        return product;
    }

    @Transactional(rollbackFor = Exception.class)
    public Product findById(int id) {
        Product product= productDAO.findById(id);
        return product;
    }

    @Transactional(rollbackFor = Exception.class)
    public ProductDetails findByProductDetails(int id) {
       ProductDetails productDetails= productDAO.findByProductDetails(id);
        return productDetails;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteById(int id) {
        productDAO.deleteById(id);
    }


    @Transactional(rollbackFor = Exception.class)
    public ProductDetails update(ProductDetails product) {
        ProductDetails productDetails = productDAO.update(product);
        return productDetails;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Product> getAllProducts() {
        List<Product> allProducts = productDAO.getAllProducts();
        return allProducts;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Product> search(String name) {
        List<Product> searchProducts = productDAO.search(name);
        return searchProducts;
    }

}
