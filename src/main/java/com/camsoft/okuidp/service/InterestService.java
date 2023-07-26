package com.camsoft.okuidp.service;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Interest;

import java.util.List;

public interface InterestService {

    Interest getInterest(Long id);

    Interest getInterest(String name);

    List<Interest> getInterests();

    List<Interest> getInterest(Category cat);

    List<Interest> getInterest(IDP idp);

    void deleteInterest(Long id);

    void deleteInterest(String name);

    void deleteInterests(List<Long> id);

    //Interest createInterestIfNotExist(Interest interest);
    Interest createInterestIfNotExist(String interestName);

    Interest save(Interest interest);

}