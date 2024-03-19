package com.tiagolearnspring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiagolearnspring.course.entities.Category;
import com.tiagolearnspring.course.entities.Order;
import com.tiagolearnspring.course.entities.OrderItem;
import com.tiagolearnspring.course.entities.Payment;
import com.tiagolearnspring.course.entities.Product;
import com.tiagolearnspring.course.entities.User;
import com.tiagolearnspring.course.entities.enums.OrderStatus;
import com.tiagolearnspring.course.repositories.CategoryRepository;
import com.tiagolearnspring.course.repositories.OrderItemRepository;
import com.tiagolearnspring.course.repositories.OrderRepository;
import com.tiagolearnspring.course.repositories.ProductsRepository;
import com.tiagolearnspring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductsRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Mano", "mano@mail.com", "999888777", "pass123");
		User u2 = new User(null, "Truta", "truta@mail.com", "999777555", "pass123");

		Product p1 = new Product(null, "Smart TV", "A TV that is smart", 5000., "none");
		Product p2 = new Product(null, "SmartPhone", "phone", 2500., "none");
		Product p3 = new Product(null, "Book 1", "Super book", 50.99, "none");
		Product p4 = new Product(null, "Book 2", "super book part 2", 55.49, "none");
		Product p5 = new Product(null, "Computer", "A computer", 7500., "none");

		Category cat1 = new Category(null, "Electronic");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat1);
		p5.getCategories().add(cat3);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		Order o1 = new Order(null, Instant.parse("2023-03-17T18:31:04Z"), OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2023-03-18T08:11:54Z"), OrderStatus.PAID, u2);
		Order o3 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u1);

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2023-03-18T10:11:54Z"), o2);
		o2.setPayment(pay1);
		
		orderRepository.save(o2);

	}
}
