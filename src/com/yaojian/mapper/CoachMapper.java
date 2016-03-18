package com.yaojian.mapper;

import java.util.List;

import com.yaojian.model.Coach;
import com.yaojian.model.CoachCarLink;

public interface CoachMapper{

	void save(Coach coach);
	void saveCoachCar(CoachCarLink coachCarLink);
	boolean update(Coach coach);
	boolean delete(int id);
	Coach findById(int id);
	Coach findByCoach(Coach coach);
	List<Coach> findAll();
	List<Coach> findCoachCarfield();
}
