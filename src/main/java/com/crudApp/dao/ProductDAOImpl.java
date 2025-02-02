package com.crudApp.dao;

import com.crudApp.model.Product;
import com.crudApp.model.ProductDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    // inject SessionFactory
    final
    SessionFactory sessionFactory;

    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Product insert(ProductDetails productDetails) {
        // cascade type all
        Product product = new Product();
        product.setName(productDetails.getName());
        product.setProductDetails(productDetails);
        getSession().persist(product);
        return product;


    }

    public Product findById(int id) {

        return getSession().get(Product.class, id);
    }

    public ProductDetails findByProductDetails(int id) {
        Product product = findById(id);
        ProductDetails productDetails = product.getProductDetails();
        return productDetails;

    }

    public void deleteById(int id) {
        Product product= getSession().get(Product.class, id);
        getSession().delete(product);

    }

    public ProductDetails update(ProductDetails productDetails) {
        // get productDetails and product to update
        ProductDetails oldProductDetails = getSession().get(ProductDetails.class, productDetails.getId());
        Product oldProduct = oldProductDetails.getProduct();

        oldProduct.setName(productDetails.getName());
        oldProductDetails.setName(productDetails.getName());
        oldProductDetails.setManufacturer(productDetails.getManufacturer());
        oldProductDetails.setExpirationDate(productDetails.getExpirationDate());
        oldProductDetails.setPrice(productDetails.getPrice());
        oldProductDetails.setAvailable(productDetails.isAvailable());
        //oldProductDetails.setImg(productDetails.getImg());

        return oldProductDetails;
    }

    public List<Product> getAllProducts() {
        Query query=  getSession().createQuery("from Product");
        return  query.getResultList();

    }

    public List<Product> search(String Name) {
        // HQL query to search by name.
        Query query=getSession().createQuery("from Product where  name =:Name");
        query.setParameter("Name",Name);
        List<Product>  products=query.getResultList();

       return products;
    }

}
