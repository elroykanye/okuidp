package com.camsoft.okuidp.Service;

import java.util.List;

import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;

public interface QuestionaireService {
	
	//Questionaire createQuestionaire(Questionaire quest);
	//Questionaire uploadQuestionaire(String questName);
	Questionaire getQuestionaire(Long id);
	Questionaire getQuestionaire(String name);
	
	List<Questionaire>getQuestionaires();
	List<Question>getQuestions(Questionaire quest);
	
	
	void deleteQuestionaire(Long id);
	void deleteQuestionaires(List<Long>id);
	void deleteQuestionaire(String name);
	Questionaire createQuestionaire(String questName);
	Questionaire uploadQuestionaire(String questName, List<Question> questions);
	
	

}
