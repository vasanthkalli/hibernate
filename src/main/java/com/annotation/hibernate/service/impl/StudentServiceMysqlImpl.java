package com.annotation.hibernate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.annotation.hibernate.dao.StudentDaoMysql;
import com.annotation.hibernate.mapping.beans.Student;
import com.annotation.hibernate.service.StudentServiceMysql;

@Component
public class StudentServiceMysqlImpl implements StudentServiceMysql{
    
	@Autowired
	private StudentDaoMysql daosql;
	
	@Override
	public Student getStudentById(Long id) {
		// TODO Auto-generated method stub
		return daosql.getStudentById(id);
	}

	@Override
	public  List<Student> getStudentByIdAndName(Long id, String starName) {
		// TODO Auto-generated method stub
		return daosql.getStudentByIdAndName(id, starName);
	}

	@Override
	public Student submitStudent(Student student) {
		// TODO Auto-generated method stub
		return daosql.submitStudent(student);
	}

}
