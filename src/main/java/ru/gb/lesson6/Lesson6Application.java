package ru.gb.lesson6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.lesson6.config.JpaConfig;
import ru.gb.lesson6.dao.ProductDao;

@SpringBootApplication
public class Lesson6Application {
	public static void main(String[] args) {
		SpringApplication.run(Lesson6Application.class, args);
	}
}
