package com.ogutcenali.service;

import com.ogutcenali.dto.request.CreateCategoryRequest;
import com.ogutcenali.model.Category;
import com.ogutcenali.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    public void createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = Category.builder().categoryName(createCategoryRequest.getCategoryName()).build();
        categoryRepository.save(category);
    }

}
