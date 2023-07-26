package com.camsoft.okuidp.service;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;

import java.util.List;

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

    Problem save(Problem problem);


}
