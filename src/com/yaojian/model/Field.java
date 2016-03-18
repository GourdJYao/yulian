package com.yaojian.model;

import java.sql.Date;
import java.util.List;

public class Field {
	private Integer id;
	private String fieldname;
	private String fieldphoto;
	private String fieldaddress;
	private Date createdate= new java.sql.Date(new java.util.Date().getTime());
	private List<Coach> coachList;

	public Field() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
