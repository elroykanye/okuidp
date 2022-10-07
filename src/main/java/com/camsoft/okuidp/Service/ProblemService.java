package com.camsoft.okuidp.Service;

import java.util.List;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;

public interface ProblemService {

	//Problem createProblem(Problem problem);
	Problem getProblemById(Long id);
	
	List<Problem> getAllProblems();
	List<Problem> getProblemsByCategory(Category cat);
	List<Question> getQuestionsByProblem(Problem problem);
	
	void deleteProblem(Long id);
	void deleteProblem(String name);
	void deleteProblem(Problem problem);

	Problem createProblem(String catName, String problem, Long probId);
	
	
	
}
