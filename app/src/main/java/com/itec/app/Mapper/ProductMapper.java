package com.itec.app.Mapper;

;
import com.itec.app.Dto.ProductDto;
import com.itec.app.Entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    //Get
    public ProductDto productToProductDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }
    //Post
    public Product productDtoToProduct(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
