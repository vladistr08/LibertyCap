package com.itec.app.Repository;


import com.itec.app.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT product FROM Product product WHERE product.city=?1")
    List<Product> findAllInRange(String city);

    @Query("SELECT product FROM Product product WHERE product.subcategoryId=?1")
    List<Product> findProductsBySubcategory(Long subcategory_id);

    @Query("SELECT product FROM Product product WHERE product.email=?1")
    List<Product> findProductsByEmail(String email);

    @Query("SELECT product FROM Product product WHERE product.id=?1")
    Product findProductById(Long id);
}
