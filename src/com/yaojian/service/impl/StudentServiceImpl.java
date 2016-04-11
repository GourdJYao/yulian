package com.yaojian.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yaojian.mapper.StudentMapper;
import com.yaojian.model.Student;
import com.yaojian.service.StudentService;
@Service
@Transactional //此处不再进行创建SqlSession和提交事务，都已交由spring去管理了。
public class StudentServiceImpl implements StudentService{
	@Resource
	StudentMapper studentMapper;
	
	@Override
	public void save(Student student) {
		studentMapper.save(student);
	}

	@Override
	public boolean update(Student student) {
		if(student.getUserid()!=null&&student.getUserid()!=-1){
			Student tempStudent=studentMapper.findByUserId(student.getUserid());
			if(tempStudent!=null){
				student.setId(tempStudent.getId());
				return studentMapper.update(student);	
			}else{
				studentMapper.save(student);
				return true;
			}
		}
		return false;
		
	}

	@Override
	public boolean delete(int id) {
		return studentMapper.delete(id);
	}

	@Override
	public Student findById(int id) {
		return studentMapper.findById(id);
	}

	@Override
	public Student findByUserId(int id) {
		return studentMapper.findByUserId(id);
	}

	@Override
	public List<Student> findAll() {
		return studentMapper.findAll();
	}}
