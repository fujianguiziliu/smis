package com._520it._01_pss.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com._520it._01_pss.dao.IStudentDAO;
import com._520it._01_pss.dao.impl.StudentDAOImpl;
import com._520it._01_pss.domain.Student;
import com._520it._01_pss.util.JDBCTemplate;

public class StudentDAOTest {

	IStudentDAO studentDAO = new StudentDAOImpl();
	@Test
	public void testSave() {
		Student student = new Student();
		student.setName("Poal");
		student.setAge(33);
		
		studentDAO.save(student);
	}

	@Test
	public void testDelete() {
		studentDAO.delete(4L);
	}

	@Test
	public void testUpdate() {
		/*Student student = new Student();
		student.setName("Chris");
		student.setAge(32);
		student.setId(2L);
		studentDAO.update(student);*/
		Student student =new Student();
		student.setName("Chris");
		student.setAge(32);
		student.setId(2L);
		studentDAO.update(student);
	}

	@Test
	public void testGet() {
		Student student = studentDAO.get(3L);
		System.out.println(student);
	}

	@Test
	public void testListAll() {
		List<Student> students = studentDAO.listAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	
}
