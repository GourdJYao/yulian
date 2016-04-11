package com.yaojian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaojian.mapper.CoachMapper;
import com.yaojian.mapper.StudentMapper;
import com.yaojian.model.Coach;
import com.yaojian.model.CoachCarLink;
import com.yaojian.model.CoachFieldLink;
import com.yaojian.model.Student;
import com.yaojian.service.CoachService;
import com.yaojian.service.StudentService;

@Service
@Transactional
// 此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class CoachServiceImpl implements CoachService {
	@Resource
	CoachMapper coachMapper;

	@Override
	public void save(Coach coach) {
		coachMapper.save(coach);
	}

	@Override
	public boolean update(Coach coach) {
		if(coach.getUserid()!=null&&coach.getUserid()!=-1){
			Coach tempCoach=coachMapper.findByUserId(coach.getUserid());
			if(tempCoach!=null){
				coach.setId(tempCoach.getId());
				return coachMapper.update(coach);	
			}else{
				coachMapper.save(coach);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		return coachMapper.delete(id);
	}

	@Override
	public Coach findById(int id) {
		return coachMapper.findById(id);
	}

	@Override
	public Coach findByUserId(int id) {
		return coachMapper.findByUserId(id);
	}

	@Override
	public List<Coach> findAll() {
		return coachMapper.findAll();
	}

	@Override
	public List<Coach> findCoachCarfield(int id) {
		return coachMapper.findCoachCarfield(id);
	}

	@Override
	public void insertCarRelativity(CoachCarLink coachCarLink) {
		coachMapper.insertCarRelativity(coachCarLink);
	}

	@Override
	public void insertFieldRelativity(CoachFieldLink coachFieldLink) {
		coachMapper.insertFieldRelativity(coachFieldLink);
	}
}
