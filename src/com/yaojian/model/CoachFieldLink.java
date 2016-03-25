package com.yaojian.model;

import java.sql.Date;

public class CoachFieldLink {
	private Coach coach;
	private Field field;
	private Date createdate= new java.sql.Date(new java.util.Date().getTime());
	
	public Coach getCoach() {
		return coach;
	}
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Field getField() {
		return field;
	}
	public void setField(Field field) {
		this.field = field;
	}
	
}
