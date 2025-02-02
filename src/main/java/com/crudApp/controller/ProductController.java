package com.crudApp.controller;

import com.crudApp.model.Product;
import com.crudApp.model.ProductDetails;
import com.crudApp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    final
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);

        return "homePage";
    }

    @GetMapping("/viewDetailsPage/{id}")
    public String showDetails(  @PathVariable int id, Model model){
        ProductDetails productDetails = productService.findByProductDetails(id);
        model.addAttribute("productDetailsView", productDetails);

        return "viewDetailsPage";
    }
    // add product
    @GetMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("productDetailsModel") Model model){
        // send product details to page
        ProductDetails productDetails=new ProductDetails();
        model.addAttribute("productDetailsModel",productDetails);

        return "addProductForm";
    }


    @PostMapping("/processAddProduct")
    public String processAddProduct(@Valid @ModelAttribute("productDetailsModel") ProductDetails productDetails, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            return "addProductForm";
        }
        // insert product details into database
        productService.insert(productDetails);
        return "redirect:/";
    }

    @GetMapping("/updateDetails/{id}")
    public String update(@PathVariable int id, Model model){
        // get the object and override it
        Product product = productService.findById(id);
        ProductDetails productDetails = product.getProductDetails();
        model.addAttribute("productDetails", productDetails);

        return "updateDetailsForm";
    }

    @PostMapping ("/processUpdateDetails")
    public String  update(@Valid @ModelAttribute("productDetails") ProductDetails productDetails, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("product", productDetails);
            return "updateDetailsForm";
        }

        productService.update(productDetails);
        return "redirect:/";
    }

    // delete products
    @GetMapping("/deleteProduct/{id}")
    public String processDeleteProduct( @PathVariable int id){

        productService.deleteById(id);

        return "redirect:/";
    }

}
