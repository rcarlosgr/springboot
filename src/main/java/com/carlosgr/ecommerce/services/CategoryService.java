package com.carlosgr.ecommerce.services;

import com.carlosgr.ecommerce.entities.Category;
import com.carlosgr.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> list(int page, String search) {
        Pageable pageable = PageRequest.of(page, 4, Sort.by("name").descending());
        return categoryRepository.findAll(search, pageable);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
