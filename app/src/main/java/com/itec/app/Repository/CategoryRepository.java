package com.itec.app.Repository;


import com.itec.app.Entity.Category;
import com.itec.app.Entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Subcategory, Long> {

    @Query("SELECT category FROM Category category WHERE category.name=?1")
    Category findCategory(String categ);
}
