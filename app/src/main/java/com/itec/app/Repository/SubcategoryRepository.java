package com.itec.app.Repository;


import com.itec.app.Entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    @Query("SELECT subcategory.categoryId FROM Subcategory subcategory WHERE subcategory.id=?1")
    Long findCategoryId(Long subcategoryId);

    @Query("SELECT subcategory FROM Subcategory subcategory WHERE subcategory.name=?1")
    Subcategory findByName(String name);
}
