package com.annotation.hibernate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.annotation.hibernate.mapping.beans.Student;

@Service
public interface StudentServiceMysql {

	public Student getStudentById(Long id);
	
	public  List<Student> getStudentByIdAndName(Long id,String starName);
	
	public Student submitStudent(Student student);
}
