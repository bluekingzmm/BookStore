package com.book.dto;

public class Product {
   private int pid;//商品编号
   private String name;//商品名
   private double relprice;//商品进价
   
private double price;//商品售价
  
   private CateGory cate;//分类编号
  private String author;
private int state;//商品状态
private String imgUrl;//商品图片
   private String message;//商品信息
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getRelprice() {
	return relprice;
}
public void setRelprice(double relprice) {
	this.relprice = relprice;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public CateGory getCate() {
	return cate;
}
public void setCate(CateGory cate) {
	this.cate = cate;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
public String getImgUrl() {
	return imgUrl;
}
public void setImgUrl(String imgUrl) {
	this.imgUrl = imgUrl;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((cate == null) ? 0 : cate.hashCode());
	result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
	result = prime * result + ((message == null) ? 0 : message.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + pid;
	long temp;
	temp = Double.doubleToLongBits(price);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	temp = Double.doubleToLongBits(relprice);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + state;
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
	Product other = (Product) obj;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (cate == null) {
		if (other.cate != null)
			return false;
	} else if (!cate.equals(other.cate))
		return false;
	if (imgUrl == null) {
		if (other.imgUrl != null)
			return false;
	} else if (!imgUrl.equals(other.imgUrl))
		return false;
	if (message == null) {
		if (other.message != null)
			return false;
	} else if (!message.equals(other.message))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (pid != other.pid)
		return false;
	if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
		return false;
	if (Double.doubleToLongBits(relprice) != Double.doubleToLongBits(other.relprice))
		return false;
	if (state != other.state)
		return false;
	return true;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", name=" + name + ", relprice=" + relprice + ", price=" + price + ", cate=" + cate
			+ ", author=" + author + ", state=" + state + ", imgUrl=" + imgUrl + ", message=" + message + "]";
}
 


}
