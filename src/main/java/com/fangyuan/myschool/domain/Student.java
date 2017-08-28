package com.fangyuan.myschool.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@RequiredArgsConstructor
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
    @NonNull
	private String name;
	
	@Column(nullable = false)
	private int age;

    @NonNull
	private String sex;
	
	@Column(nullable = false)
    @NonNull
	private Date birthday;
	
	@Column(nullable = false)
    @NonNull
	private String parentName;
	
	@Column
    @NonNull
	private String phoneNumber;
	
	@Column
	private String address;

	public Student() {
		
	}
	
	public Student(Long id) {
		this.id = id;
		this.name = "";
		this.age = 0;
		this.birthday = new Date();
		this.sex = "";
		this.parentName = "";
		this.phoneNumber = "";
		this.address = "";
	}
	
	public Student(String name, int age, String sex, Date birthday, String phoneNumber, String address, String parentName) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.parentName = parentName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public Student update(Student student) {
		this.name = student.name;
		this.age = student.age;
		this.birthday = student.birthday;
		this.sex = student.sex;
		this.parentName = student.parentName;
		this.phoneNumber = student.phoneNumber;
		this.address = student.address;
		return this;
	}
}
