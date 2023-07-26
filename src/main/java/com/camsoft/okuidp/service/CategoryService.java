package com.camsoft.okuidp.service;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.domain.Problem;

import java.util.List;


public interface CategoryService {
    //Category createCategory(Category cat);
    Category getCategory(Long id);

    Category getCategory(String name);

    List<Category> getcategorys();

    List<Interest> getInterests(Category cat);

    List<Problem> getProblems(Category cat);

    void deleteCategorys(List<Long> id);

    void deleteCategory(Long id);

    void deleteCategory(String name);

    Category createCategory(String catName, Long catId);

}
