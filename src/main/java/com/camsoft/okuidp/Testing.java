package com.camsoft.okuidp;

import com.camsoft.okuidp.service.*;
import com.camsoft.okuidp.domain.IDP;
import com.camsoft.okuidp.domain.Interest;
import com.camsoft.okuidp.domain.Problem;
import com.camsoft.okuidp.domain.User;
import com.camsoft.okuidp.util.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Objects;

@Component
public class Testing implements CommandLineRunner {

    @Autowired
    private ProblemService probService;

    @Autowired
    private UserService userService;

    @Autowired
    private IDPService idpService;

    @Autowired
    private InterestService interestService;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {

        Problem problem = new Problem();
        Problem problem1 = new Problem();
        Problem problem2 = new Problem();
        Problem problem3 = new Problem();

        try {
            problem = probService.createProblem("Health", "Maleria", 0L);
            problem1 = probService.createProblem("Education", "Scholarship", 0L);
            problem2 = probService.createProblem("Health", "cancer", 0L);
            problem3 = probService.createProblem("Self-sustainable help", "Project", 0L);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (problem != null) {
                System.err.println(problem);
            }
        }

        Interest interest = new Interest();
        interest.setName("Business");

        try {

            interest = interestService.createInterestIfNotExist("Business");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            if (interest != null) {
                System.err.println(interest);
            }
        }


        User user = new User();
        user.setUsername("admin");
        user.setName("Oku IDP User");
        user.setPassword("Admin213");

        Example<User> userExample = Example.of(user);


        User userOp = userService.getUser("admin");


        if (userService.userExists(userExample)) {
            User createdUser = userService.createUser(user, "ROLE_ADMIN");
            System.err.println(createdUser.toString());
        }

        IDP idp = new IDP();
        idp.setName("Dahlia");
        idp.setAge(21);
        idp.setDob(LocalDate.of(2000, 04, 30));
        idp.setGender(Gender.FEMALE);
        idp.setAddress("Sisia");

        IDP idpExist = idpService.getIDP("Dahlia");

        if (Objects.isNull(idpExist)) {
            idpExist = idpService.createIDP(null, idp);
        }

        System.err.println(idpExist.toString());


        IDP idp1 = new IDP();
        idp1.setName("Eric");
        idp1.setAge(31);
        idp1.setDob(LocalDate.of(1989, 04, 25));
        idp1.setGender(Gender.MALE);
        idp1.setAddress("Carrefour centre, Etoug Ebe");

        IDP idpExist1 = idpService.getIDP("Eric");

        if (Objects.isNull(idpExist1)) {
            idpExist1 = idpService.createIDP(null, idp1);
        }

        System.err.println(idpExist);

        IDP idp2 = new IDP();
        idp2.setName("Boris");
        idp2.setAge(25);
        idp2.setDob(LocalDate.of(1998, 07, 18));
        idp2.setGender(Gender.MALE);
        idp2.setAddress("Bambili, 3-Corners");

        IDP idpExist2 = idpService.getIDP("Boris");

        if (Objects.isNull(idpExist2)) {
            idpExist2 = idpService.createIDP(null, idp2);
        }

        System.err.println(idpExist);


    }


}


