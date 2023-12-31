package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.Answer;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.IDPAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDPAnswerRepository extends JpaRepository<IDPAnswer, Long> {

    List<IDPAnswer> findByIdp(IDP idp);

    IDPAnswer findByAnswer(Answer answer);

}
