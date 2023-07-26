package com.camsoft.okuidp.service;

import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.IDPAnswer;

import java.util.List;

public interface IDPAnswerService {
    //IDPAnswer createIDPAnswer(IDPAnswer idpAnswer);
    IDPAnswer getIDPAnswer(Long id);


    List<IDPAnswer> getIDPAnswers();

    List<IDPAnswer> getIDPAnswers(IDP idp);

    void deleteIDPanswer(Long id);

    void deleteIDPAnswers(List<Long> id);

    IDPAnswer createIDPAnswer(Long idpId, Long ansId, IDPAnswer idpAnswer);

}
