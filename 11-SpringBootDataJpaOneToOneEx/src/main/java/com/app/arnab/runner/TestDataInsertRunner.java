package com.app.arnab.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Role;
import com.app.arnab.entity.User;
import com.app.arnab.repo.RoleRepository;
import com.app.arnab.repo.UserRepository;

@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository rrepo;

	@Autowired
	private UserRepository urepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Role r1 = new Role(503, "ADMIN");
		Role r2 = new Role(504, "GUEST");

		rrepo.saveAll(List.of(r1, r2));

		User u1 = new User(10, "SYED", r1);
		User u2 = new User(11, "SAM", r2);

		urepo.saveAll(List.of(u1, u2));

	}

}
