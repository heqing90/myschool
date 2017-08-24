package com.fangyuan.myschool.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private int age;
	
	private String sex;
	
	@Column(nullable = false)
	private String birthday;
	
	@Column(nullable = false)
	private String parentName;
	
	@Column
	private String phoneNumber;
	
	@Column
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Student() {}
	
	public Student(long id) {this.id = id;}
	
	public Student(String name, int age, String birthday, String sex, String parent, String phoneNumber) 
	{
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.sex = sex;
		this.parentName = parent;
		this.phoneNumber = phoneNumber;
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
