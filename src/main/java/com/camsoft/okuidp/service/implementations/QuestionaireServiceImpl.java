package com.camsoft.okuidp.service.implementations;

import com.camsoft.okuidp.service.QuestionaireService;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.domain.Questionaire;
import com.camsoft.okuidp.repository.QuestionRepository;
import com.camsoft.okuidp.repository.QuestionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionaireServiceImpl implements QuestionaireService {
    @Autowired
    private QuestionaireRepository questRepos;
    @Autowired
    private QuestionRepository quesRepos;

    @Override
    public Questionaire createQuestionaire(String questName) {
        if (questName.isBlank() || questName != null) {
            Questionaire questionaireFromDbByName = questRepos.findByNameIgnoreCase(questName);
            if (questionaireFromDbByName != null) {
                return questionaireFromDbByName;
            }
            return questRepos.save(new Questionaire(questName));
        }
        return null;
    }


    @Override
    public Questionaire uploadQuestionaire(String questName, List<Question> questions) {
        Questionaire questionaire = createQuestionaire(questName);
        try {
            List<Question> savedQuestions = quesRepos.saveAll(questions);
            questionaire.setQuestions(savedQuestions);
            return questRepos.save(questionaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Questionaire getQuestionaire(Long id) {
        return questRepos.getReferenceById(id);
    }

    @Override
    public List<Questionaire> getQuestionaires() {
        return questRepos.findAll();
    }

    @Override
    public List<Question> getQuestions(Questionaire quest) {
        return quesRepos.findByQuestionaire(quest);
    }

    @Override
    public void deleteQuestionaire(Long id) {
        questRepos.deleteById(id);

    }

    @Override
    public void deleteQuestionaires(List<Long> id) {
        questRepos.deleteAllByIdInBatch(id);

    }

    @Override
    public Questionaire getQuestionaire(String name) {
        return questRepos.findByNameIgnoreCase(name);
    }

    @Override
    public void deleteQuestionaire(String name) {
        questRepos.deleteByNameIgnoreCase(name);
    }

}
