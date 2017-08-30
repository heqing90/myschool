package com.fangyuan.myschool.domain;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    
    @NonNull
 	private String grade;
	
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
	
	public Student(String name, int age, String sex, String grade, Date birthday, String phoneNumber, String address, String parentName) {
		this.name = name;
		this.age = age;
		this.grade = grade;
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
		this.grade = student.grade;
		this.sex = student.sex;
		this.parentName = student.parentName;
		this.phoneNumber = student.phoneNumber;
		this.address = student.address;
		return this;
	}
	
	public String getBirthday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(this.birthday).toString();
	}
}
