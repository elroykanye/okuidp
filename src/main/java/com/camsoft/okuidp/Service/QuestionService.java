package com.camsoft.okuidp.Service;

import java.util.List;

import com.camsoft.okuidp.domain.IDPAnswer;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;

public interface QuestionService {
//Question createQuestion(Question question);
	
	Question getQuestion(Long id);
	Question getQuestion(String name);
	
	List<Question>getQuestions(Questionaire quest);
	List<Question>getQuestions(Problem prob);
	List<Question>getQuestions();
	
	
	void deleteQuestion(Long id);
	void deleteQuestion(String name);
	void deleteQuestions(List<Long>id);
	//Question createQuestion(Long problemId, Long questionaireId, String questionName);
	//Question createQuestion(String questioniareName, String problemName, String questionName);
	Question createQuestion(String questioniareName, String problemName, String catName, String questionName);
}
