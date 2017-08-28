package com.fangyuan.myschool.controller;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fangyuan.myschool.domain.Student;
import com.fangyuan.myschool.repository.StudentRepository;
import com.fangyuan.myschool.utils.MyUtil;


@Controller
@Slf4j
@RequestMapping("/students")
public class StudentContoller {
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("")
	public String getAll(
			ModelMap map,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String sex,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Date birthday,
			@RequestParam(required = false) String phoneNumber,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String parentName,
			@RequestParam(defaultValue = "1") Integer pageNum, 
			@RequestParam(defaultValue = "${student.page.size}") Integer pageSize) {
		int page = pageNum;
		int size = pageSize;

		Pageable pageable = (Pageable) new PageRequest(page, size);
		Page<Student> students = studentRepository.findAll(pageable);
		map.addAttribute("students", students.getContent());
		int[] pages = MyUtil.range(0, students.getTotalPages(), 1); 
		map.addAttribute("pages", pages);
		map.addAttribute("pageNum", pageNum);
		map.addAttribute("pageSize", pageSize);
		return "students";
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody int addStudent(@RequestBody Student student){
		log.info("add a student: " + student.getName());
		studentRepository.save(student);
		return 0;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public @ResponseBody Student showStudent(@RequestParam Long id){
		log.info("show a student: " + id);
		Student ret = studentRepository.findById(id);
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
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public @ResponseBody int deleteStudent(@RequestParam Long id){
		log.info("delete a student: " + id);
		studentRepository.deleteById(id);
		return 0;
	}
}
