package com.ogutcenali.controller;

import com.ogutcenali.dto.request.CreateCategoryRequest;
import com.ogutcenali.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @MutationMapping
    public Boolean createCategory(@Argument CreateCategoryRequest createCategoryRequest) {
        categoryService.createCategory(createCategoryRequest);
        return true;
    }
}
