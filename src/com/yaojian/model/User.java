package com.yaojian.model;

import java.sql.Date;

/**
 * 用户
 * @author GourdJYao
 *
 */
public class User {

	private Integer id;
	private String username;
	private String password;
	private String nickname;
	private String truename;
	private String driverslicense;
	private Date updatedatetime;
	private String phonenumber;
	private String address;
	private String QQ;
	private String studentcard;
	private String idcard;
	private String headimageurl;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getDriverslicense() {
		return driverslicense;
	}
	public void setDriverslicense(String driverslicense) {
		this.driverslicense = driverslicense;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getStudentcard() {
		return studentcard;
	}
	public void setStudentcard(String studentcard) {
		this.studentcard = studentcard;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getHeadimageurl() {
		return headimageurl;
	}
	public void setHeadimageurl(String headimageurl) {
		this.headimageurl = headimageurl;
	}
	

}
