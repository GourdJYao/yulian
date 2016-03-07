package com.yaojian.model;

import java.sql.Date;

public class Coach {
	private Integer id;
	private String coachname;
	private String coachcardnumber;
	private String coachcardimage;
	private String coachidcardnumber;
	private String coachidcardimage;
	private String coachdesc; 
	private Date coachdate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCoachname() {
		return coachname;
	}
	public void setCoachname(String coachname) {
		this.coachname = coachname;
	}
	public String getCoachcardnumber() {
		return coachcardnumber;
	}
	public void setCoachcardnumber(String coachcardnumber) {
		this.coachcardnumber = coachcardnumber;
	}
	public String getCoachcardimage() {
		return coachcardimage;
	}
	public void setCoachcardimage(String coachcardimage) {
		this.coachcardimage = coachcardimage;
	}
	public String getCoachidcardnumber() {
		return coachidcardnumber;
	}
	public void setCoachidcardnumber(String coachidcardnumber) {
		this.coachidcardnumber = coachidcardnumber;
	}
	public String getCoachidcardimage() {
		return coachidcardimage;
	}
	public void setCoachidcardimage(String coachidcardimage) {
		this.coachidcardimage = coachidcardimage;
	}
	public String getCoachdesc() {
		return coachdesc;
	}
	public void setCoachdesc(String coachdesc) {
		this.coachdesc = coachdesc;
	}
	public Date getCoachdate() {
		return coachdate;
	}
	public void setCoachdate(Date coachdate) {
		this.coachdate = coachdate;
	}


}
