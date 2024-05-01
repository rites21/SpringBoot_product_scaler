package com.example.product.DTOs;

import com.example.product.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@AllArgsConstructor
public class ProductResaponseSelf {

    private Product product;
    private String message;
}
