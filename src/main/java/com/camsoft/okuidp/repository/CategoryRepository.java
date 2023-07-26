package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);

}
