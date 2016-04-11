package com.yaojian.service;

import java.util.List;

import com.yaojian.model.Coach;
import com.yaojian.model.CoachCarLink;
import com.yaojian.model.CoachFieldLink;

public interface CoachService {
	void save(Coach coach);
	boolean update(Coach coach);
	boolean delete(int id);
	Coach findById(int id);
	Coach findByUserId(int id);
	List<Coach> findAll();
	List<Coach> findCoachCarfield(int id);
	void insertCarRelativity(CoachCarLink coachCarLink);
	void insertFieldRelativity(CoachFieldLink coachFieldLink);
}
