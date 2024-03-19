package com.tiagolearnspring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiagolearnspring.course.entities.Order;
import com.tiagolearnspring.course.entities.User;
import com.tiagolearnspring.course.repositories.OrderRepository;
import com.tiagolearnspring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Mano", "mano@mail.com", "999888777", "pass123");
		User u2 = new User(null, "Truta", "truta@mail.com", "999777555", "pass123");

		Order o1 = new Order(null, Instant.parse("2023-03-17T18:31:04Z"), u1);
		Order o2 = new Order(null, Instant.parse("2023-03-18T08:11:54Z"), u2);
		Order o3 = new Order(null, Instant.now(), u1);

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}
}
