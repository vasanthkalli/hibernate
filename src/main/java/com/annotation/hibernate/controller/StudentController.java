package com.annotation.hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.annotation.hibernate.mapping.beans.Address;
import com.annotation.hibernate.mapping.beans.Marks;
import com.annotation.hibernate.mapping.beans.Student;
import com.annotation.hibernate.request.StudentRequest;
import com.annotation.hibernate.service.StudentServiceMysql;

@Controller
public class StudentController {
	
    @Autowired
	private StudentServiceMysql studentSqlService;
	
	@ResponseBody
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public ResponseEntity<Student> getStudentResponseId(@PathVariable("id") Long id) {
		Student student=studentSqlService.getStudentById(id);
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	@RequestMapping(value="/student/{id}/?starts=abc",method=RequestMethod.GET)
	public ResponseEntity<List<Student>> getStudentResponseIdAndName(@PathVariable("id") Long id,@RequestParam("starts") String startsWith) {
		List<Student> students= studentSqlService.getStudentByIdAndName(id, startsWith);
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	@RequestMapping(value="/student/submit",method=RequestMethod.POST)
	public ResponseEntity<Student> processStudent(@RequestBody StudentRequest request ) {
		Student student=new Student();
		student.setName("sudent");
		Address address=new Address();
		address.setDoorNum(1010);
		address.setStreet("ABC");
		student.setAddress(address);
		List<Marks> markList=new ArrayList<Marks>();
		Marks marks=new Marks();
		marks.setMathMarks(90);
		marks.setScienceMarks(50);
		markList.add(marks);
		student.setMarks(markList);
		Student studentResp=studentSqlService.submitStudent(student);
		return new ResponseEntity<Student>(studentResp,HttpStatus.OK);
	}
}
