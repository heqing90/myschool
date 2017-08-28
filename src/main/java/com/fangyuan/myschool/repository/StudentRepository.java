package com.fangyuan.myschool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.fangyuan.myschool.domain.Student;

import java.util.List;

import javax.transaction.Transactional;


public interface StudentRepository extends PagingAndSortingRepository<Student, Integer>{

	List<Student> findByName(String name);
	
	Student findById(Long id);
	
	@Transactional
	Long deleteById(Long id);
	
	Page<Student> findAll(Pageable pageable);

}
