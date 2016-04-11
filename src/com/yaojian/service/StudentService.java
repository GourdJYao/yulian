package com.yaojian.service;

import java.util.List;

import com.yaojian.model.Student;

public interface StudentService {
	void save(Student student);

	boolean update(Student student);

	boolean delete(int id);

	Student findById(int id);

	Student findByUserId(int id);

	List<Student> findAll();
}
