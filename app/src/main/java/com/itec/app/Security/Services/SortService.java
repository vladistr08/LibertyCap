package com.itec.app.Security.Services;


import com.itec.app.Dto.ProductDto;
import com.itec.app.Entity.Category;
import com.itec.app.Entity.Product;
import com.itec.app.Entity.Subcategory;
import com.itec.app.Entity.User;
import com.itec.app.Mapper.ProductMapper;
import com.itec.app.Repository.CategoryRepository;
import com.itec.app.Repository.ProductRepository;
import com.itec.app.Repository.SubcategoryRepository;
import com.itec.app.Repository.UserRepository;
import com.itec.app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class SortService {
    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductService productService;

    @Autowired
    UserRepository userRepository;

    public List<ProductDto> getProductsByCategory(String categ, Long userId, String city) {
        Category category = categoryRepository.findCategory(categ);
        List<ProductDto> products=new ArrayList<>();
        if(userId!=0 && !city.equals("")) {
            products = productService.getAllProducts(userId, city);
        }
        else {
            List<Product> productToMap = productRepository.findAll();
            for(Product product : productToMap) {
                products.add(productMapper.productToProductDto(product));
            }
        }

        List<ProductDto> productsToShow = new ArrayList<>();
        for(ProductDto product : products) {
            if(subcategoryRepository.findCategoryId(product.getSubcategoryId())==category.getId()){
                productsToShow.add(product);
            }
        }
        return productsToShow;
    }

    public List<ProductDto> getProductsBySubcategory(String subcateg, Long userId, String city) {
        Subcategory subcategory = subcategoryRepository.findByName(subcateg);
        List<ProductDto> products=new ArrayList<>();
        if(userId!=0 && !city.equals("")) {
            products = productService.getAllProducts(userId, city);
        }
        else {
            List<Product> productToMap = productRepository.findAll();
            for(Product product : productToMap) {
                products.add(productMapper.productToProductDto(product));
            }
        }

        List<ProductDto> productsToShow = new ArrayList<>();
        for(ProductDto product : products) {
            if(product.getSubcategoryId() == subcategory.getId())
                productsToShow.add(product);
        }

        return productsToShow;
    }

    public List<ProductDto> sortAscending(Long userId, String city) {
        List<ProductDto> products = new ArrayList<>();
        if (userId != 0 && !city.equals("")) {
            products = productService.getAllProducts(userId, city);
        } else {
            List<Product> productToMap = productRepository.findAll();
            for (Product product : productToMap) {
                products.add(productMapper.productToProductDto(product));
            }
        }

        Collections.sort(products);

        return products;
    }

    public List<ProductDto> sortDescending(Long userId, String city) {
        List<ProductDto> products = new ArrayList<>();
        if (userId != 0 && !city.equals("")) {
            products = productService.getAllProducts(userId, city);
        } else {
            List<Product> productToMap = productRepository.findAll();
            for (Product product : productToMap) {
                products.add(productMapper.productToProductDto(product));
            }
        }

        Collections.reverse(products);

        return products;
    }

    public List<ProductDto> sortByLocation(String location, Long userId){
        List<ProductDto> products = new ArrayList<>();
        if (userId != 0) {
            products = productService.getAllProducts(userId, location);
        } else {
            List<Product> productToMap = productRepository.findAll();
            for (Product product : productToMap) {
                products.add(productMapper.productToProductDto(product));
            }

            for(ProductDto product : products) {
                if(!product.getCity().equals(location))
                    products.remove(product);
            }
        }
        return products;
    }

    public List<ProductDto> sortByUser(String lastName, Long userId){
        User user = userRepository.findById(userId).get();

        if(user.getLastName()!=lastName) {
            User searchedUser = userRepository.findUserByLastName(lastName);
            List<Product> products = productRepository.findProductsByEmail(searchedUser.getEmail());
            List<ProductDto> productDtos = new ArrayList<>();

            for(Product product : products) {
                productDtos.add(productMapper.productToProductDto(product));
            }

            return productDtos;
        }
        return Collections.emptyList();
    }
}
