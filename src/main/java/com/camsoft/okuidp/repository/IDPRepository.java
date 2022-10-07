package com.camsoft.okuidp.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Contact;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.User;
import com.camsoft.okuidp.util.Gender;
import com.camsoft.okuidp.util.IDPType;

@Repository
public interface IDPRepository extends JpaRepository<IDP, Long> {

	IDP findByNameIgnoreCase(String name);
	IDP findByCniIgnoreCase(String cni);
	IDP findByContact(Contact contact);
	List<IDP> findByAgeBetween(int minAge, int maxAge);
	List<IDP> findByType(IDPType type);
	List<IDP> findByGender(Gender gender);
	List<IDP> findByNumofminorsBetween(int minMinor, int maxMinor);
	List<IDP> findByNumofminorsGreaterThanEqual(int numOfMinor);
	List<IDP> findByUser(User user);
}
