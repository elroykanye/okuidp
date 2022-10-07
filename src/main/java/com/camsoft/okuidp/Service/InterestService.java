package com.camsoft.okuidp.Service;

import java.util.List;

import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Interest;

public interface InterestService {

	Interest getInterest(Long id);
	Interest getInterest(String name);
	
	List<Interest>getInterests();
	List<Interest>getInterest(Category cat);
	List<Interest>getInterest(IDP idp);
	
	void deleteInterest(Long id);
	void deleteInterest(String name);
	void deleteInterests(List<Long>id);
	//Interest createInterestIfNotExist(Interest interest);
	Interest createInterestIfNotExist(String interestName);

}