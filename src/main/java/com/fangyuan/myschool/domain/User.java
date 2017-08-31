package com.fangyuan.myschool.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	@NonNull
	private String username;
	
	@NonNull
	private String password;
}
