package com.fangyuan.myschool;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;

import groovyjarjarcommonscli.CommandLine;

@SpringBootApplication
public class MyschoolApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(MyschoolApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner students(StudentRepository repository){
		return (args)->{
			log.info("create default students");
			repository.deleteAll();
			repository.save(new Student("张三", 5,  "2017-01-01", "男", "张大", "122343545"));
			repository.save(new Student("张四", 5,  "2017-01-01", "男", "张大", "122343545"));
			repository.save(new Student("张五", 5,  "2017-01-01", "男", "张大", "122343545"));
			log.info("intialize students info success.");
		};
	}
}


