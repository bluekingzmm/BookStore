package com.book.dto;

public class Admin {
  private int adminId; 
  private String adminName;
  private String sex;
  private String psw;
public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + adminId;
	result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
	result = prime * result + ((psw == null) ? 0 : psw.hashCode());
	result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
	Admin other = (Admin) obj;
	if (adminId != other.adminId)
		return false;
	if (adminName == null) {
		if (other.adminName != null)
			return false;
	} else if (!adminName.equals(other.adminName))
		return false;
	if (psw == null) {
		if (other.psw != null)
			return false;
	} else if (!psw.equals(other.psw))
		return false;
	if (sex == null) {
		if (other.sex != null)
			return false;
	} else if (!sex.equals(other.sex))
		return false;
	return true;
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", sex=" + sex + ", psw=" + psw + "]";
}
}
