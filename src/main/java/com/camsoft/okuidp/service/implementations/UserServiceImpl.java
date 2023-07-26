package com.camsoft.okuidp.service.implementations;

import com.camsoft.okuidp.service.IDPService;
import com.camsoft.okuidp.service.UserService;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Role;
import com.camsoft.okuidp.domain.User;
import com.camsoft.okuidp.repository.RoleRepository;
import com.camsoft.okuidp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl<BCryptPasswordEncoder> implements UserService {

    @Autowired
    private UserRepository userRepos;
    @Autowired
    private RoleRepository roleRepos;
    @Autowired
    private IDPService idpService;


    @Override
    @Transactional
    public User createUser(User user, String roleName) {
        synchronized (this) {
            User userDto = userRepos.findByUsernameIgnoreCase(user.getUsername());
            if (userDto != null) {
                return userDto;
            }
            if (!user.getName().isBlank() && !user.getUsername().isBlank() && !user.getPassword().isBlank()) {
                if (!roleName.isEmpty()) {
                    Role role = createRoleIfNotExist(roleName);
                    user.addRole(role);
                }
                return userRepos.save(user);
            }
            return null;
        }
    }


    @Override
    public User loginUser(String username, String password) {

        return null;
    }

    @Override
    public User updateUser(User user, Long id) {
        User userFromDb = userRepos.getReferenceById(id);
        userFromDb.setName((user.getName().isBlank()) ? userFromDb.getName() : user.getName());
        userFromDb.setUsername((user.getUsername().isBlank()) ? userFromDb.getUsername() : user.getUsername());


        return userRepos.save(user);
    }


    @Override
    public void logoutUser(Long id) {
        if (userRepos.existsById(id)) {
            System.err.println("Logout successful");
        }

    }

    @Override
    public void deleteUser(Long id) {
        userRepos.deleteById(id);

    }

    @Override
    public User getUser(String name) {

        return userRepos.findByNameIgnoreCase(name);
    }

    @Override
    public User getUser(Long id) {
        return userRepos.getReferenceById(id);
    }

    @Override
    public List<User> getUsers() {
        return userRepos.findAll();
    }

    @Override
    public List<IDP> getIDPByUser(User user) {
        return user.getIdps();
    }


    @Override
    public Role createRoleIfNotExist(String name) {
        Role userRole = roleRepos.getByNameIgnoreCase(name);
        if (userRole != null) {
            return userRole;
        }
        userRole = new Role();
        userRole.setName(name);
        return roleRepos.saveAndFlush(userRole);


    }


    @Override
    public Role getrole(String name) {
        return roleRepos.getByNameIgnoreCase(name);
    }


    @Override
    public Role getrole(Long id) {
        return roleRepos.getReferenceById(id);
    }


    @Override
    public void deleteRole(Long id) {
        roleRepos.deleteById(id);
    }


    @Override
    public void changeUserRole(User user, Role oldRole, Role newRole) {
        user.getRole().remove(oldRole);
        user.addRole(newRole);
        userRepos.save(user);
    }


    @Override
    public boolean userExists(Example<User> example) {
        return userRepos.exists(example);
    }


    @Override
    public Optional<User> getById(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }


    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return null;
    }


}
