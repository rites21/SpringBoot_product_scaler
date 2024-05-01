package com.example.product.Controller;

import com.example.product.DTOs.ProductRequestDTOFS;
import com.example.product.DTOs.ProductResaponseSelf;
import com.example.product.Exceptions.ProductNotPresentException;
import com.example.product.Service.IProductService;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Qualifier("fakestoreProductService")
    @Autowired
     IProductService productService;
    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResaponseSelf> getSingleProduct(@PathVariable("id") Long id){

        Product product;
        try {
            product = productService.getSingleProduct(id);
        }catch (ProductNotPresentException e){
            ProductResaponseSelf productResaponseSelf = new ProductResaponseSelf(null,"Product doesn't exist");
            return new ResponseEntity<>(productResaponseSelf
                    ,HttpStatus.NOT_FOUND);
        }catch (ArithmeticException e){
            ProductResaponseSelf productResaponseSelf = new ProductResaponseSelf(null,"Airthmetic exc");
            return new ResponseEntity<>(productResaponseSelf
                    ,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ProductResaponseSelf(product,"Sucess"),
                HttpStatus.OK);
    }

    @GetMapping("/product/exception/{id}")
    public ResponseEntity<ProductResaponseSelf> getSingleProductException(@PathVariable("id") Long id) throws ProductNotPresentException {

        Product product = productService.getSingleProduct(id);
        return new ResponseEntity<>(new ProductResaponseSelf(product,"Sucess"),
                HttpStatus.OK);
    }



    @GetMapping("/products/categories")
    public List<Category> getAllCategories(){

         return null;
    }

    @GetMapping("/products/category/{id}")
    public List<Product> getAllProductsInCategoryCategories(@PathVariable("id") Long id){

        return new ArrayList<>();
    }

    @PostMapping("/products")
    public  Product addProduct(@RequestBody ProductRequestDTOFS requestDTO){
        return  new Product();
    }

    @PatchMapping("/products/{id}")
    public  Product updateProduct(@PathVariable("id") Long id,
            @RequestBody ProductRequestDTOFS requestDTO){
        return  new Product();
    }

    @DeleteMapping("/products/{id}")
    public  boolean deleteProduct(@PathVariable("id") Long id){
        return  true;
    }

}
