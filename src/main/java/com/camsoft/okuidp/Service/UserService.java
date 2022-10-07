package com.camsoft.okuidp.Service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Role;
import com.camsoft.okuidp.domain.User;

public interface UserService {

//User loginUser(String Username, String password);
User updateUser(User user, Long id);
//User verifyUser(String User);
void logoutUser(Long id);
void deleteUser(Long id);
User getUser(String name);
User getUser(Long id);
List<User> getUsers();
List<IDP> getIDPByUser(User user);
Role getrole(String name);
Role getrole(Long id);
void deleteRole(Long id);

boolean userExists(Example<User> example);


Role createRoleIfNotExist(String name);
User createUser(User user, String roleName);
void changeUserRole(User user, Role oldRole, Role newRole);
User loginUser(String username, String password);

}
