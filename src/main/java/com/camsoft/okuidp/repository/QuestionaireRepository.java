package com.camsoft.okuidp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Questionaire;

@Repository
public interface QuestionaireRepository extends JpaRepository<Questionaire, Long>{

	Questionaire findByNameIgnoreCase(String name);

	void deleteByNameIgnoreCase(String name);

}
