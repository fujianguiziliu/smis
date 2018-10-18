package com._520it._01_pss.dao;

import java.util.List;

import com._520it._01_pss.domain.Student;

public interface IStudentDAO {

	/**
	 * @param student
	 */
	void save(Student student); 
	
	
	
	
	/**
	 * @param id
	 */
	void delete(Long id);
	
	
	
	
	/**
	 * @param id
	 * @param student
	 */
	void update(Student student);
	
	
	
	
	/**
	 * @param id
	 * @return 
	 */
	Student get(Long id);
	
	
	
	
	/**
	 * @return
	 */
	List<Student> listAll();
}
