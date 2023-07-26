package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByProblem(Problem problem);

    List<Question> findByQuestionaire(Questionaire quest);

    Question findByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);
}
