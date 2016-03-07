package com.yaojian.mapper;

import java.util.List;

import com.yaojian.model.Coach;
import com.yaojian.model.User;

public interface CoachMapper{

	void save(Coach coach);
	boolean update(Coach coach);
	boolean delete(int id);
	Coach findById(int id);
	Coach findByCoach(Coach coach);
	List<Coach> findAll();
}
