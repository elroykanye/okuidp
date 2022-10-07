package com.camsoft.okuidp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.camsoft.okuidp.Service.CategoryService;
import com.camsoft.okuidp.Service.ProblemService;
import com.camsoft.okuidp.Service.UserService;
import com.camsoft.okuidp.domain.Category;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.User;

@RestController
public class HomeController {

	@Autowired
	private ProblemService probService;
	
	@Autowired
	private CategoryService catService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/problems")
	public List<Problem> getProblems(){
		return probService.getAllProblems();
	}
	
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userService.getUsers();
	}
}
