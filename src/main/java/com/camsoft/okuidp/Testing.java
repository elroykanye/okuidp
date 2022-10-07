package com.camsoft.okuidp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.camsoft.okuidp.Service.ProblemService;
import com.camsoft.okuidp.Service.UserService;
import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.User;
import com.camsoft.okuidp.repository.CategoryRepository;

@Component
public class Testing implements CommandLineRunner{

	@Autowired
	private ProblemService probService;
	
	@Autowired
	private UserService userService;

	@Override
	public void run(String... args) throws Exception {

		Problem problem = new Problem();
		
		try {
			problem = probService.createProblem("Health", "Maleria", 0l);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			if(problem != null) {
				System.err.println(problem.toString());
			}
		}
		
		
		
		User user = new User();
		user.setUsername("admin");
		user.setName("Oku IDP User");
		
		Example<User> userExample = Example.of(user);
		
		user.setPassword("Admin213");
		
		
		if(!userService.userExists(userExample)) {
			User createdUser = userService.createUser(user, "ROLE_ADMIN");
			System.err.println(createdUser.toString());
		
		}
		
	}
}
