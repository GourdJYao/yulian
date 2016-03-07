package com.yaojian.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaojian.mapper.CoachMapper;
import com.yaojian.model.Car;
import com.yaojian.model.Coach;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class CoachTest {

	@Autowired
	private CoachMapper coachMapper;
	
	@Test
	public void testAdd(){
		Coach coach = new Coach();
		coach.setCoachname("你好");
		coachMapper.save(coach);
		
	}
	
	@Test
	public void testFindAll(){
		List<Coach> findAllList = coachMapper.findAll();
		System.out.println(findAllList.size());
	}
	
	@Test
	public void testFindById(){
		List<Coach> coachList = coachMapper.findAll();
		if(coachList!=null&&coachList.size()>0){
			Coach coach=coachMapper.findById(coachList.get(0).getId());
			System.out.println(coach.getId());
			System.out.println(coach.getCoachname());
		}
	}


	@Test
	public void testUpdate(){
		List<Coach> coachList = coachMapper.findAll();
		if(coachList!=null&&coachList.size()>0){
			Coach coach=coachMapper.findById(coachList.get(0).getId());
			coach.setCoachname("EDDAFDA");
			coachMapper.update(coach);
		}
	}
	
	@Test
	public void testDelete(){
//		CarMapper.delete(1);
	}
}
