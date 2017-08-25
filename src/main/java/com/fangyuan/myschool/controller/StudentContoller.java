package com.fangyuan.myschool.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;

@Controller
@RequestMapping("/students")
public class StudentContoller {

	private static final Logger log = LoggerFactory.getLogger(StudentContoller.class);
	
	@Resource
	private StudentRepository studentRepository;

	@RequestMapping("/test")
    public @ResponseBody Student test(){
	    List<Student> list = studentRepository.findAll();
	    if(list.size() > 0){
	    	return list.get(0);
		}
		return null;
	}
	@RequestMapping("")
	public String students(ModelMap map){
		List<Student> students = studentRepository.findAll();
		map.addAttribute("students", students);
		return "students";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody int addStudent(@RequestBody Student student){
		log.info("add a student: " + student.getName());
		studentRepository.save(student);
		return 0;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public @ResponseBody Student showStudent(@RequestBody Student student){
		log.info("show a student: " + student.getId());
		Student ret = studentRepository.findById(student.getId());
		return ret;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public @ResponseBody Student modifyStudent(@RequestBody Student student){
		log.info("modify a student: " + student.getId());
		Student ret = studentRepository.findById(student.getId());
		ret.update(student);
		studentRepository.save(ret);
		return ret;
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody int deleteStudent(@RequestBody Student student){
		log.info("delete a student: " + student.getId());
		studentRepository.deleteById(student.getId());
		return 0;
	}
}
