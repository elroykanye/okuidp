package com.camsoft.okuidp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.camsoft.okuidp.repository.IDPRepository;

public class sqlBootstrap implements CommandLineRunner {
	@Autowired
IDPRepository idpRepository;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	}

}
