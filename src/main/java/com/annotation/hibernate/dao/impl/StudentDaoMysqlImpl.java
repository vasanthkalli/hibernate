package com.annotation.hibernate.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.annotation.hibernate.dao.StudentDaoMysql;
import com.annotation.hibernate.mapping.beans.Student;



@Component
public class StudentDaoMysqlImpl implements StudentDaoMysql{
    
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Student getStudentById(Long id) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Student student=session.load(Student.class, id);//Here we need to see the difference between load and get
		transaction.commit();//we need to see the states of objects in hibernate
		session.close();
		return student;
	}

	@Override
	public List<Student> getStudentByIdAndName(Long id, String starName) {
		//begin transaction even for read operations .recommented by hibernate team
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		Query query=session.createQuery("FROM student s WHERE s.id=:student_id");
		query.setParameter("student_id", id);
		List<Student> result=query.list();
		transaction.commit();
		session.close();
		return result;
	}

	@Override
	public Student submitStudent(Student student) {
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	    session.save(student);
	    transaction.commit();
	    session.close();
		return student;
	}
	

}
