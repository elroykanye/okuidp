package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    List<Interest> findByCategory(Category cat);

    Interest findByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);


}
