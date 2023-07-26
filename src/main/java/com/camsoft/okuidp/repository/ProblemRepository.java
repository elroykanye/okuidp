package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface ProblemRepository extends JpaRepository<Problem, Long> {

    Problem findByNameIgnoreCase(String name);

    List<Problem> findByCategory(Category category);

    @Modifying
    @Transactional
    @Query("delete from Problem p where LOWER(p.name) = LOWER(:name)")
    void deleteByNameIgnoreCase(String name);

}
