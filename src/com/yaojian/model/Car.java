package com.yaojian.model;

public class Car {
	private Integer id;
	private String platenumber;
	private Integer cartype=0;
	private String carimage;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlatenumber() {
		return platenumber;
	}
	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}
	public int getCartype() {
		return cartype;
	}
	public void setCartype(int cartype) {
		this.cartype = cartype;
	}
	public String getCarimage() {
		return carimage;
	}
	public void setCarimage(String carimage) {
		this.carimage = carimage;
	}
	
}
