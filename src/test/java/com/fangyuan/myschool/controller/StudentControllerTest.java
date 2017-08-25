package com.fangyuan.myschool.controller;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StudentControllerTest {
    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext context;

    @Resource
    private StudentRepository studentRepository;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(context).build();
        studentRepository.save(new Student("张三test", 5, "2017-01-01", "男", "张大", "122343545"));
        studentRepository.save(new Student("张四test", 5, "2017-01-01", "男", "张大", "122343545"));
        studentRepository.save(new Student("张五test", 5, "2017-01-01", "男", "张大", "122343545"));
    }

    @After
    public void clear() {
        studentRepository.deleteAll();
    }

    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(get("/students/test")
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name", is("张三test")));

    }
}
