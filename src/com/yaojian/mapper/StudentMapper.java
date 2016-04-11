package com.yaojian.mapper;

import java.util.List;

import com.yaojian.model.Student;

public interface StudentMapper {
	void save(Student student);
	boolean update(Student student);
	boolean delete(Integer id);
	Student findById(Integer id);
	List<Student> findAll();
	Student findByUserId(Integer userid);
}
