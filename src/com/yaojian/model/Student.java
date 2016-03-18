package com.yaojian.model;

import java.sql.Date;

public class Student {
	private Integer id;
	private String studentname;
	private Integer studenttype;
	private String studentidcard;
	private String studentidcardimg;
	private String studentcardno;
	private String studentcardimg;
	private Integer userid;
	private String studentdrivercardno;
	private String studentdrivercardnoimg;
	private Date createdate = new java.sql.Date(new java.util.Date().getTime());;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public Integer getStudenttype() {
		return studenttype;
	}
	public void setStudenttype(Integer studenttype) {
		this.studenttype = studenttype;
	}
	public String getStudentidcard() {
		return studentidcard;
	}
	public void setStudentidcard(String studentidcard) {
		this.studentidcard = studentidcard;
	}
	public String getStudentidcardimg() {
		return studentidcardimg;
	}
	public void setStudentidcardimg(String studentidcardimg) {
		this.studentidcardimg = studentidcardimg;
	}
	public String getStudentcardno() {
		return studentcardno;
	}
	public void setStudentcardno(String studentcardno) {
		this.studentcardno = studentcardno;
	}
	public String getStudentcardimg() {
		return studentcardimg;
	}
	public void setStudentcardimg(String studentcardimg) {
		this.studentcardimg = studentcardimg;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getStudentdrivercardno() {
		return studentdrivercardno;
	}
	public void setStudentdrivercardno(String studentdrivercardno) {
		this.studentdrivercardno = studentdrivercardno;
	}
	public String getStudentdrivercardnoimg() {
		return studentdrivercardnoimg;
	}
	public void setStudentdrivercardnoimg(String studentdrivercardnoimg) {
		this.studentdrivercardnoimg = studentdrivercardnoimg;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

}
