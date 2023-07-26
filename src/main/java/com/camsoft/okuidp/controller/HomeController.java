package com.camsoft.okuidp.controller;

import com.camsoft.okuidp.service.*;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private ProblemService probService;

    @Autowired
    private IDPService idpService;

    @Autowired
    private CategoryService catService;

    @Autowired
    private UserService userService;

    @Autowired
    private InterestService intService;

    @GetMapping("/problems")
    public List<Problem> getProblems() {
        return probService.getAllProblems();
    }


    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/woi")
    public ResponseEntity<String> qc(@RequestBody Map<String, Object> sqd) {
        return ResponseEntity.ok(sqd.toString());
    }

    @PostMapping(value = "/idp/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createIDP(@RequestBody IDP idp) {
        System.out.println(idp.getId());
        System.out.println(idp.getAge());
        System.out.println(idp.getName());
        System.out.println(idp.getNumofminors());
        System.out.println(idp.getDob());
        System.out.println(idp.getGender());
        System.out.println(idp.getAddress());
        System.out.println(idp.getNumofminors());
        System.out.println(idp.getPastActivities());
        try {
            idpService.createIDP(null, idp);
            return new ResponseEntity<>("IDP is created successfully", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/idps")
    public List<IDP> addIDPs() {
        return idpService.getIDPs();
    }

    @PostMapping("/problem/create")
    public ResponseEntity<Problem> CreateProblem(@RequestBody String catName, String problemName, Long probId) {
        probService.createProblem(catName, problemName, probId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/interest")
    public Interest CreateInterest(@RequestBody Interest interest) {
        return intService.save(interest);
    }

    @PostMapping("/users")
    public User CreateUser(@RequestBody User user) {
        return userService.save(user);
    }

    //		implemented.
    @GetMapping("/idps/{id}")
    public ResponseEntity<IDP> getById(@PathVariable long id) throws Exception {

        java.util.Optional<IDP> idp = idpService.getById(id);
        if (idp.isPresent()) {
            return new ResponseEntity<>(idp.get(), HttpStatus.OK);
        } else {
            throw new Exception();
        }
    }

    @PutMapping("/idps/{id}")
    public ResponseEntity<IDP> updateIDP(@PathVariable("id") long id, @RequestBody IDP idp) {
        idpService.updateIDP(id, idp);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/interest")
    public List<Interest> getInterests() {
        return intService.getInterests();
    }


}

	


