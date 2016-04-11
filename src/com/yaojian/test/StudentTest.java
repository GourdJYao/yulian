package com.yaojian.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaojian.mapper.CarMapper;
import com.yaojian.mapper.StudentMapper;
import com.yaojian.model.Car;
import com.yaojian.model.Car;
import com.yaojian.model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class StudentTest {

	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void testFindStudent(){
		Student student=studentMapper.findById(1);
		System.out.println("================="+student.getStudentname());
	}
	@Test
	public void testDelete(){
//		CarMapper.delete(1);
	}
}
