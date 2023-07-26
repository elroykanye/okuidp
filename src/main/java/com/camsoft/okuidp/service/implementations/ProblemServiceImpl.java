package com.camsoft.okuidp.service.implementations;

import com.camsoft.okuidp.service.CategoryService;
import com.camsoft.okuidp.service.ProblemService;
import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.repository.ProblemRepository;
import com.camsoft.okuidp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemRepository probRepos;

    @Autowired
    private CategoryService catService;

    @Autowired
    private QuestionRepository questRepos;

    @Override
    public Problem createProblem(String catName, String problemName, Long probId) {
        Category category = catService.createCategory(catName, 0L);

        Problem problemFromDbByName = probRepos.findByNameIgnoreCase(problemName);

        if (probId > 0 && !problemName.isBlank()) {
            Problem problemFromDbById = probRepos.getReferenceById(probId);
            problemFromDbById.setName(problemName);

            probRepos.save(problemFromDbById);

        } else if (problemFromDbByName != null) {
            return problemFromDbByName;
        } else {
            return probRepos.save(new Problem(category, problemName));
        }
        return null;
    }

    @Override
    public Problem getProblemById(Long id) {
        return probRepos.getReferenceById(id);
    }

    @Override
    public List<Problem> getAllProblems() {
        return probRepos.findAll();
    }

    @Override
    public List<Problem> getProblemsByCategory(Category cat) {
        return probRepos.findByCategory(cat);
    }

    @Override
    public List<Question> getQuestionsByProblem(Problem problem) {
        return questRepos.findByProblem(problem);
    }

    @Override
    public void deleteProblem(Long id) {
        probRepos.deleteById(id);
    }

    @Override
    public void deleteProblem(String name) {
        probRepos.deleteByNameIgnoreCase(name);
    }

    @Override
    public void deleteProblem(Problem problem) {
        probRepos.delete(problem);
    }

    @Override
    public Problem save(Problem problem) {
        // TODO Auto-generated method stub
        return null;
    }


}
