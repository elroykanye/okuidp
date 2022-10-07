package com.camsoft.okuidp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

	List<Question> findByProblem(Problem problem);

	List<Question> findByQuestionaire(Questionaire quest);

	Question findByNameIgnoreCase(String name);

	void deleteByNameIgnoreCase(String name);
}
