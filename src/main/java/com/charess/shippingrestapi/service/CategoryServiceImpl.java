package com.charess.shippingrestapi.service;


import com.charess.shippingrestapi.model.Audit;
import com.charess.shippingrestapi.model.Category;
import com.charess.shippingrestapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    private UserService userService;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(UserService userService, CategoryRepository categoryRepository) {
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public List<Category> search(String criteria) {
        return (criteria == null || criteria.trim().isEmpty()) ? new ArrayList<>() : categoryRepository.search(criteria);
    }

    public Category save(Category category) {
        Audit audit = category;
        userService.inject(audit);
        return (category == null || audit == null) ? null : categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return save(category);
    }

}
