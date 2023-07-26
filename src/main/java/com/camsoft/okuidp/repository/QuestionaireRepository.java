package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Questionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaireRepository extends JpaRepository<Questionaire, Long> {

    Questionaire findByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);

}
