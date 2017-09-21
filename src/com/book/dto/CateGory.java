package com.book.dto;

public class CateGory {
  private int cid;
  private String cate;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCate() {
	return cate;
}
public void setCate(String cate) {
	this.cate = cate;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cate == null) ? 0 : cate.hashCode());
	result = prime * result + cid;
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
	CateGory other = (CateGory) obj;
	if (cate == null) {
		if (other.cate != null)
			return false;
	} else if (!cate.equals(other.cate))
		return false;
	if (cid != other.cid)
		return false;
	return true;
}
@Override
public String toString() {
	return "CateGory [cid=" + cid + ", cate=" + cate + "]";
}
  
}
