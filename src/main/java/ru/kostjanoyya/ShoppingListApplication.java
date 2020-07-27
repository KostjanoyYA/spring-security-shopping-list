package ru.kostjanoyya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShoppingListApplication {

	//private UserRepository userRepository;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

//	@Bean
//	public User createAdmin() {
//		User admin = new User();
//		admin.setIsEnabled(true);
//		admin.setUsername("2");
//		admin.setPassword("2");
//		Set roleSet = new HashSet<Role>();
//		roleSet.add(new Role("ROLE_USER"));
//		roleSet.add(new Role("ROLE_ADMIN"));
//		admin.setRoles(roleSet);
//		return admin;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingListApplication.class, args);
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}


}
