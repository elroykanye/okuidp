package com.camsoft.okuidp;

import com.camsoft.okuidp.repository.IDPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SqlBootstrap implements CommandLineRunner {
    @Autowired
    IDPRepository idpRepository;

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
    }
}
