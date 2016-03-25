package com.yaojian.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yaojian.mapper.CarMapper;
import com.yaojian.model.Car;
import com.yaojian.model.Car;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/spring-common.xml")
public class CarTest {

	@Autowired
	private CarMapper carMapper;
	
	@Test
	public void testAdd(){
		Car car = new Car();
		car.setPlatenumber("BXD121121");
		carMapper.save(car);
		
	}
	
	@Test
	public void testFindAll(){
		List<Car> findAllList = carMapper.findAll();
		System.out.println(findAllList.size());
	}
	
	@Test
	public void testFindById(){
		List<Car> carList = carMapper.findAll();
		if(carList!=null&&carList.size()>0){
			Car car=carMapper.findById(carList.get(0).getCar_id());
			System.out.println(car.getCar_id());
			System.out.println(car.getPlatenumber());
		}
	}


	@Test
	public void testUpdate(){
		List<Car> CarList = carMapper.findAll();
		if(CarList!=null&&CarList.size()>0){
			Car Car=carMapper.findById(CarList.get(0).getCar_id());
			Car.setPlatenumber("EDDAFDA");
			carMapper.update(Car);
		}
	}
	
	@Test
	public void testDelete(){
//		CarMapper.delete(1);
	}
}
