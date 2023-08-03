package com.Day3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Day3.entity.Student;
import com.Day3.repository.StudentRepository;

@SuppressWarnings("unused")
@SpringBootApplication
public class ExcelRDay3SpringbootSmsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(ExcelRDay3SpringbootSmsApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;


	@Override
	public void run(String... args) throws Exception {
		
	}
}