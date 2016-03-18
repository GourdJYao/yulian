package com.yaojian.model;

import java.sql.Date;

public class CoachCarLink {
	private Coach coach;
	private Car car;
	private Date createdate= new java.sql.Date(new java.util.Date().getTime());
	
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
