package com.camsoft.okuidp.repository;

import com.camsoft.okuidp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByNameIgnoreCase(String name);

    User findByUsernameIgnoreCase(String username);

    Optional<User> findByEmail(String email);

}
