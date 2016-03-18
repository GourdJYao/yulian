package com.yaojian.model;

import java.sql.Date;
import java.util.List;

public class Coach {
	private Integer id;
	private String coachname;
	private String coachcardnumber;
	private String coachcardimage;
	private String coachidcardnumber;
	private String coachidcardimage;
	private String coachdesc; 
	private Date coachdate= new java.sql.Date(new java.util.Date().getTime());;;
	//0未审核   1审核通过   2 投诉删除
	private int isreview=0;
	private String reviewdesc;
	private String userid;
	private String coachiddrivercarno;
	private String coachiddrviercarimg;
	private List<Car> carlist;
	private List<Field> fieldlist;
	
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
	public int getIsreview() {
		return isreview;
	}
	public void setIsreview(int isreview) {
		this.isreview = isreview;
	}
	public String getReviewdesc() {
		return reviewdesc;
	}
	public void setReviewdesc(String reviewdesc) {
		this.reviewdesc = reviewdesc;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCoachiddrivercarno() {
		return coachiddrivercarno;
	}
	public void setCoachiddrivercarno(String coachiddrivercarno) {
		this.coachiddrivercarno = coachiddrivercarno;
	}
	public String getCoachiddrviercarimg() {
		return coachiddrviercarimg;
	}
	public void setCoachiddrviercarimg(String coachiddrviercarimg) {
		this.coachiddrviercarimg = coachiddrviercarimg;
	}
	public List<Car> getCarlist() {
		return carlist;
	}
	public void setCarlist(List<Car> carlist) {
		this.carlist = carlist;
	}
	public List<Field> getFieldlist() {
		return fieldlist;
	}
	public void setFieldlist(List<Field> fieldlist) {
		this.fieldlist = fieldlist;
	}
	
}
