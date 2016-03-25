package com.yaojian.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaojian.mapper.FieldMapper;
import com.yaojian.model.Field;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class FieldTest {

	@Autowired
	private FieldMapper fieldMapper;
	
	@Test
	public void testAdd(){
		Field field = new Field();
		field.setFieldname("yaojian");
		fieldMapper.save(field);
		
	}
	
	@Test
	public void testFindAll(){
		List<Field> findAllList = fieldMapper.findAll();
		System.out.println(findAllList.size());
	}
	
	@Test
	public void testFindById(){
		List<Field> FieldList = fieldMapper.findAll();
		if(FieldList!=null&&FieldList.size()>0){
			Field Field=fieldMapper.findById(FieldList.get(0).getField_id());
			System.out.println(Field.getField_id());
			System.out.println(Field.getFieldname());
		}
	}


	@Test
	public void testUpdate(){
		List<Field> FieldList = fieldMapper.findAll();
		if(FieldList!=null&&FieldList.size()>0){
			Field Field=fieldMapper.findById(FieldList.get(0).getField_id());
			Field.setFieldname("GourdJYao");
			fieldMapper.update(Field);
		}
	}
	
	@Test
	public void testFindFieldAndCoach(){
		List<Field> FieldList = fieldMapper.findAll();
		if(FieldList!=null&&FieldList.size()>0){
			Field Field=fieldMapper.findFieldAndCoach(FieldList.get(0).getField_id());
			if(Field!=null&&Field.getCoachList()!=null){
				System.out.println("====================="+Field.getCoachList().size());
			}
		}
	}
	
	@Test
	public void testDelete(){
//		FieldMapper.delete(1);
	}
}
