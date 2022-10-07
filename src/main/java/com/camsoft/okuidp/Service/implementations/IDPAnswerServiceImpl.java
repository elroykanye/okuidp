package com.camsoft.okuidp.Service.implementations;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camsoft.okuidp.Service.IDPAnswerService;
import com.camsoft.okuidp.domain.Answer;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.IDPAnswer;
import com.camsoft.okuidp.domain.Question;
import com.camsoft.okuidp.repository.IDPAnswerRepository;
import com.camsoft.okuidp.repository.IDPRepository;
import com.camsoft.okuidp.repository.QuestionRepository;
@Service
public class IDPAnswerServiceImpl implements IDPAnswerService {
    @Autowired
    public IDPAnswerRepository idpAnsRepos;
    @Autowired
    public AnswerRepository ansRepos;
    @Autowired
    public IDPRepository idpRepos;
    
	@Override
	public IDPAnswer createIDPAnswer(Long idpId, Long ansId, IDPAnswer idpAnswer) {
		IDP idp = idpRepos.getReferenceById(idpId);
		Answer answer = ansRepos.getReferenceById(ansId);
		idpAnswer.setAnswer(answer);
		idpAnswer.setIdp(idp);
		idpAnswer.setAnswereddate(LocalDate.now());
		
		return idpAnsRepos.save(idpAnswer);
	}

	@Override
	public IDPAnswer getIDPAnswer(Long id) {
		return idpAnsRepos.getReferenceById(id);
	}

	@Override
	public List<IDPAnswer> getIDPAnswers() {
		return idpAnsRepos.findAll();
	}

	@Override
	public List<IDPAnswer> getIDPAnswers(IDP idp) {
		return idpAnsRepos.findByIdp(idp);
	}

	@Override
	public void deleteIDPanswer(Long id) {
		idpAnsRepos.deleteById(id);

	}

	@Override
	public void deleteIDPAnswers(List<Long> id) {
		idpAnsRepos.deleteAllByIdInBatch(id);
	}
}
