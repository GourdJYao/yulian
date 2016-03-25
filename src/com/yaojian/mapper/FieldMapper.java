package com.yaojian.mapper;

import java.util.List;

import com.yaojian.model.Field;

public interface FieldMapper {
	void save(Field field);
	boolean update(Field field);
	boolean delete(int id);
	Field findById(int id);
	List<Field> findAll();
	Field findFieldAndCoach(int id);
}
