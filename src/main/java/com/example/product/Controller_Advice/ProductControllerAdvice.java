package com.example.product.Controller_Advice;

import com.example.product.DTOs.ProductResaponseSelf;
import com.example.product.Exceptions.ProductNotPresentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotPresentException.class)
    public ResponseEntity<ProductResaponseSelf> handleInvalidProduct(){
        ProductResaponseSelf productResaponseSelf = new ProductResaponseSelf(null,"Product doesn't exist");
        return new ResponseEntity<>(productResaponseSelf
                , HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ProductResaponseSelf> handleAirthmaticException(){
        ProductResaponseSelf productResaponseSelf = new ProductResaponseSelf(null,"Airthmetic exc");
        return new ResponseEntity<>(productResaponseSelf
                ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
