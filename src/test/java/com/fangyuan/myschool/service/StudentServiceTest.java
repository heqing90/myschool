package com.fangyuan.myschool.service;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Resource
    private StudentService studentService;

    @Resource
    private StudentRepository studentRepository;

    @Before
    public void setup() {
        studentRepository.save(new Student("张三test", 5, "2017-01-01", "男", "张大", "122343545"));
        studentRepository.save(new Student("张四test", 5, "2017-01-01", "男", "张大", "122343545"));
        studentRepository.save(new Student("张五test", 5, "2017-01-01", "男", "张大", "122343545"));
    }

    @After
    public void clear() {
        studentRepository.deleteAll();
    }

    @Test
    public void testFindByName() {
        Assert.assertEquals(studentService.findByName("张三test").size(), 1);
    }
}

