package com.camsoft.okuidp.Service;

import java.util.List;

import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.IDPAnswer;
import com.camsoft.okuidp.domain.Question;

public interface IDPAnswerService {
	//IDPAnswer createIDPAnswer(IDPAnswer idpAnswer);
   IDPAnswer getIDPAnswer(Long id);
   
   
   List<IDPAnswer>getIDPAnswers();
   List<IDPAnswer>getIDPAnswers(IDP idp);
   
   void deleteIDPanswer(Long id);
   void deleteIDPAnswers(List<Long>id);
   IDPAnswer createIDPAnswer(Long idpId, Long ansId, IDPAnswer idpAnswer);
   
}
