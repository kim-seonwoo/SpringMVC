package com.bookSpring.bookSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication으로 인해 스프링 부트 자동 설정, 스프링 Bean 읽기와 생 모두 자동으로 설정.
@SpringBootApplication
public class BookSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookSpringApplication.class, args);
	}

}
