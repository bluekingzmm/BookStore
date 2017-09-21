package com.book.dto;

import java.util.Date;

public class User {
 private int uid;
 private String name;
 private String psw;
 private String sex;
 private String email;
 private String phone;
 private int state;
 private Date saveTime;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public Date getSaveTime() {
	return saveTime;
}
public void setSaveTime(Date saveTime) {
	this.saveTime = saveTime;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((phone == null) ? 0 : phone.hashCode());
	result = prime * result + ((psw == null) ? 0 : psw.hashCode());
	result = prime * result + ((saveTime == null) ? 0 : saveTime.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
	result = prime * result + state;
	result = prime * result + uid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (email == null) {
		if (other.email != null)
			return false;
	} else if (!email.equals(other.email))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (phone == null) {
		if (other.phone != null)
			return false;
	} else if (!phone.equals(other.phone))
		return false;
	if (psw == null) {
		if (other.psw != null)
			return false;
	} else if (!psw.equals(other.psw))
		return false;
	if (saveTime == null) {
		if (other.saveTime != null)
			return false;
	} else if (!saveTime.equals(other.saveTime))
		return false;
	if (sex == null) {
		if (other.sex != null)
			return false;
	} else if (!sex.equals(other.sex))
		return false;
	if (state != other.state)
		return false;
	if (uid != other.uid)
		return false;
	return true;
}
@Override
public String toString() {
	return "User [uid=" + uid + ", name=" + name + ", psw=" + psw + ", sex=" + sex + ", email=" + email + ", phone="
			+ phone + ", state=" + state + ", saveTime=" + saveTime + "]";
}
 

}
