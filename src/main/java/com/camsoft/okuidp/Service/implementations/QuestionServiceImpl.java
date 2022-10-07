package com.camsoft.okuidp.Service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camsoft.okuidp.Service.ProblemService;
import com.camsoft.okuidp.Service.QuestionService;
import com.camsoft.okuidp.Service.QuestionaireService;
import com.camsoft.okuidp.domain.IDPAnswer;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;
import com.camsoft.okuidp.repository.IDPAnswerRepository;
import com.camsoft.okuidp.repository.QuestionRepository;
import org.springframework.transaction.annotation.*;

@Service
public class QuestionServiceImpl implements QuestionService {
   @Autowired
   private QuestionRepository quesRepos;
   
   @Autowired
   private ProblemService probService;
   
   @Autowired
   private IDPAnswerRepository idpAnsRepos;
   
   @Autowired
   private QuestionaireService questService;
   
	@Override
	@Transactional
	public Question createQuestion(String questioniareName, String problemName, String catName, String questionName) {
		
		Question questionFromDbByName = quesRepos.findByNameIgnoreCase(questionName);
		
		if(questionFromDbByName != null) {
			return questionFromDbByName;
		}else if(!questioniareName.isBlank() && !problemName.isBlank() && !questionName.isBlank()) {
		    Questionaire questionaire = questService.createQuestionaire(questioniareName);
		    Problem problem = probService.createProblem(catName, problemName, 0l);
		    return quesRepos.save(new Question(questionaire, problem, questionName));
		}
	    
		return null;
	}

	@Override
	public Question getQuestion(Long id) {
		return quesRepos.getReferenceById(id);
	}

	@Override
	public Question getQuestion(String name) {
		return quesRepos.findByNameIgnoreCase(name);
	}

	@Override
	public List<Question> getQuestions(Questionaire quest) {
		return quesRepos.findByQuestionaire(quest);
	}

	@Override
	public List<Question> getQuestions(Problem prob) {
		return quesRepos.findByProblem(prob);
	}

	@Override
	public List<Question> getQuestions() {
		return quesRepos.findAll();
	}

	@Override
	public void deleteQuestion(Long id) {
		quesRepos.deleteById(id);

	}

	@Override
	public void deleteQuestion(String name) {
		quesRepos.deleteByNameIgnoreCase(name);

	}

	
	@Override
	public void deleteQuestions(List<Long> id) {
		quesRepos.deleteAllByIdInBatch(id);

	}

}
