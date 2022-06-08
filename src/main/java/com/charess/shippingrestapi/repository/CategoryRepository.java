package com.charess.shippingrestapi.repository;

import com.charess.shippingrestapi.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("select c from Category c where lower(c.name) like Concat('%', Concat(?1,'%'))")
    List<Category> search(String criteria);
}
