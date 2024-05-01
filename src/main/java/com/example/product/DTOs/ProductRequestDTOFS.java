package com.example.product.DTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDTOFS {
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;

}
