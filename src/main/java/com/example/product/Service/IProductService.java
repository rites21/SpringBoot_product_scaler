package com.example.product.Service;

import com.example.product.Exceptions.ProductNotPresentException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    Product getSingleProduct(Long id) throws ProductNotPresentException;
    List<Product> getAllProducts();

    Product saveProduct(Product product);
}
