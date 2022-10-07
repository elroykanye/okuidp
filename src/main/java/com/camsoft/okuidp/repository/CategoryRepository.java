package com.camsoft.okuidp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  Category findByNameIgnoreCase(String name);
  void deleteByNameIgnoreCase(String name);
  
}
