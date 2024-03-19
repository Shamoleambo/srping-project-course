package com.tiagolearnspring.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiagolearnspring.course.entities.User;
import com.tiagolearnspring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Mano", "mano@mail.com", "999888777", "pass123");
		User u2 = new User(null, "Truta", "truta@mail.com", "999777555", "pass123");

		userRepository.saveAll(Arrays.asList(u1, u2));

	}
}