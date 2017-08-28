package com.fangyuan.myschool.domain;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class StudentId {
	@NonNull
	private Long id;
}
