package com.camsoft.okuidp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}