package com.camsoft.okuidp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camsoft.okuidp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByNameIgnoreCase(String name);

	User findByUsernameIgnoreCase(String username);

}
