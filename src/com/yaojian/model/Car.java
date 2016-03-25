package com.yaojian.model;

import java.sql.Date;
import java.util.List;

public class Car {
	private Integer car_id;
	private String platenumber;
	private Integer cartype = 0;
	private String carimage;
	private List<Coach> coachList;
	private Date createdate = new java.sql.Date(new java.util.Date().getTime());

	public Integer getCar_id() {
		return car_id;
	}

	public void setCar_id(Integer car_id) {
		this.car_id = car_id;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}

	public Integer getCartype() {
		return cartype;
	}

	public void setCartype(Integer cartype) {
		this.cartype = cartype;
	}

	public String getCarimage() {
		return carimage;
	}

	public void setCarimage(String carimage) {
		this.carimage = carimage;
	}

	public List<Coach> getCoachList() {
		return coachList;
	}

	public void setCoachList(List<Coach> coachList) {
		this.coachList = coachList;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
