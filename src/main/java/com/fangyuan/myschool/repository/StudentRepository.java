package com.fangyuan.myschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fangyuan.myschool.domain.Student;

import java.util.List;

import javax.transaction.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long>{

	List<Student> findByName(String name);
	
	Student findById(Long id);
	
	@Transactional
	Long deleteById(Long id);
}
