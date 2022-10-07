package com.camsoft.okuidp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Interest;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long>{

	List<Interest> findByCategory(Category cat);

	Interest findByNameIgnoreCase(String name);

	void deleteByNameIgnoreCase(String name);

	

}
