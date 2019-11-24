package com.itec.app.Service;

import com.itec.app.Dto.ProductDto;
import com.itec.app.Entity.Product;
import com.itec.app.Entity.User;
import com.itec.app.Mapper.ProductMapper;
import com.itec.app.Repository.ProductRepository;
import com.itec.app.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public Product postProduct(ProductDto productDto){
        Product product = productMapper.productDtoToProduct(productDto);
        return saveProduct(product);
    }


    public ProductDto getProduct(Long id){
        return productMapper.productToProductDto(productRepository.findProductById(id));
    }

    public List<ProductDto> getAllProducts(Long userId, String city) {
        User user = userRepository.findUserById(userId);
        List<Product> products = productRepository.findAllInRange(city);
        List<ProductDto> productDtos = new ArrayList<>();
        for ( Product product : products ) {
            if(product.getEmail()!=user.getEmail())
                productDtos.add(productMapper.productToProductDto(product));
        }
        return productDtos;
    }

    public List<ProductDto> getAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for ( Product product : products )
            productDtos.add(productMapper.productToProductDto(product));

        return productDtos;
    }
}
