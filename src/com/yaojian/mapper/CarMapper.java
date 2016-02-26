package com.yaojian.mapper;

import java.util.List;

import com.yaojian.model.Car;

public interface CarMapper {
	void save(Car car);
	boolean update(Car car);
	boolean delete(Integer id);
	Car findById(Integer id);
	List<Car> findAll();
}
