package com.fangyuan.myschool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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

	@Query(value = "select u from Student u where u.name like CONCAT(?1, '%')", 
		countQuery = "select count(*) from Student u where u.name like CONCAT(?1, '%')",
		nativeQuery = false)
	Page<Student> findByText(String text, Pageable pageable);
}
