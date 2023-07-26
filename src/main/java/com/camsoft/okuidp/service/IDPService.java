package com.camsoft.okuidp.service;

import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.IDPAnswer;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.domain.User;
import com.camsoft.okuidp.util.Gender;
import com.camsoft.okuidp.util.IDPType;

import java.util.List;
import java.util.Optional;

public interface IDPService {
    IDP createIDP(User user, IDP idp);

    IDP getIDP(Long id);

    IDP getIDP(String name);

    IDP getIDPByCNI(String cni);

    List<IDP> getIDPs(int minAge, int maxAge);

    List<IDP> getIDPs(IDPType type);

    List<IDP> getIDPs(Gender gender);

    List<IDP> getIDPs(Interest interest);

    List<IDPAnswer> getIDPAnswers(IDP idp);

    IDP updateIDP(Long id, IDP idp);

    void deleteIDP(Long id);

    List<IDP> getIDPs();

    List<IDP> getIDPsByMinors(int minMinor, int maxMinor);

    List<IDP> getIDPs(int numOfMinor);


    Optional<IDP> getById(long id);

    IDP saveIDP(User user, IDP idp);

    IDP addIDP(String name);


}
