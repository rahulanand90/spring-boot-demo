package com.coderahul.springbootdemo;

import com.coderahul.springbootdemo.models.Student;
import com.coderahul.springbootdemo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			List<Student> students = new ArrayList<>();
			students.add(new Student("Akash", "Anand", "akashanand@gmail.com", 30));
			students.add(new Student("Rahul", "Anand", "rahulanand@gmail.com", 34));
			studentRepository.saveAll(students);
		};
	}
}
