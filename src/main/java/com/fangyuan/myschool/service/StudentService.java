package com.fangyuan.myschool.service;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentRepository studentRepository;

    public List<Student> findByName(String name){
        return studentRepository.findByName(name);
    }
}
