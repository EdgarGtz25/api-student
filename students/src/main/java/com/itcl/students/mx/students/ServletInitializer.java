package com.itcl.students.mx.students;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ServletInitializer.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));	}
}