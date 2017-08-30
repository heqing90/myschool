package com.fangyuan.myschool;

import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;


@SpringBootApplication
@Slf4j
public class MyschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyschoolApplication.class, args);
    }

    @Bean
    public CommandLineRunner students(StudentRepository repository) {
        return (args) -> {
            log.info("create default students");
            repository.deleteAll();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse("2017-01-01");
            repository.save(new Student("张三", 5, "男", "大班", date, "122343545", "杰兴", "张大"));
            repository.save(new Student("张四", 5, "男", "大班", date, "122343546", "杰兴", "张大"));
            repository.save(new Student("张五", 5, "男", "大班", date, "122343547", "杰兴", "张大"));
            log.info("intialize students info success.");
        };
    }
}


