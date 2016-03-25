package com.yaojian.model;

import java.sql.Date;
import java.util.List;

public class Field {
	private Integer field_id;
	private String fieldname;
	private String fieldphoto;
	private String fieldaddress;
	private Date createdate= new java.sql.Date(new java.util.Date().getTime());
	private List<Coach> coachList;

	public Field() {
	}


	public Integer getField_id() {
		return field_id;
	}


	public void setField_id(Integer field_id) {
		this.field_id = field_id;
	}


	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getFieldphoto() {
		return fieldphoto;
	}

	public void setFieldphoto(String fieldphoto) {
		this.fieldphoto = fieldphoto;
	}

	public String getFieldaddress() {
		return fieldaddress;
	}

	public void setFieldaddress(String fieldaddress) {
		this.fieldaddress = fieldaddress;
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
