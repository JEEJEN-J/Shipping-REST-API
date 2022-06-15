package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> list();

    List<Category> search(String criteria);

    void delete(Integer id);

    Category save(Category category);

    Category update(Category category);
}
