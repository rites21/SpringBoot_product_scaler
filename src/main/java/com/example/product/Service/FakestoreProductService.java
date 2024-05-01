package com.example.product.Service;
import com.example.product.DTOs.ProductResponseDtoFS;
import com.example.product.Exceptions.ProductNotPresentException;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakestoreProductService implements IProductService{

    @Autowired
    RestTemplate restTemplate;
    @Override
    public Product getSingleProduct(Long id) throws ProductNotPresentException {
        if(id > 20 && id < 40){
            throw new ProductNotPresentException();
        }
        if(id > 40){
            throw new ArithmeticException();
        }

        ProductResponseDtoFS response = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+ id, ProductResponseDtoFS.class);

               Product product =  getProductResponseDTO(response);
        return product;
    }

    @Override
    public List<Product> getAllProducts() {

        ProductResponseDtoFS[] products = restTemplate.getForObject(
                "https://fakestoreapi.com/products", ProductResponseDtoFS[].class);

        List<Product> output = new ArrayList<>();
        for(ProductResponseDtoFS productResponseDto : products){
            output.add(getProductResponseDTO(productResponseDto));
        }

        return output;
    }

    @Override
    public Product saveProduct(Product product) {
//        ProductResponseDtoFS product = restTemplate.getForObject()
        return null;
    }

    private Product getProductResponseDTO(ProductResponseDtoFS response) {
        Product product = new Product();
        product.setId(response.getId());
        product.setName(response.getTitle());
        product.setDescription(response.getDescription());
        product.setPrice(response.getPrice());
        product.setCtaegory(new Category());
        product.getCtaegory().setName(response.getCategory());
        product.setImage(response.getImage());

        return product;
    }

}
