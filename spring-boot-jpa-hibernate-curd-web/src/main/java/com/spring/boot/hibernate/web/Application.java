package com.spring.boot.hibernate.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.spring.boot.hibernate","com.spring.boot.hibernate.web","com.spring.boot.hibernate.controller"})
@EntityScan("com.spring.boot.hibernate.model")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
