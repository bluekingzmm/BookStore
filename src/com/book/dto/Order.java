package com.book.dto;

import java.util.Date;

public class Order {
 private int orderId;//订单编号
 private double money;//订单价格
 private String receiverinfo;//物流信息
 private int paystate;//是否支付
 private Date orderTime;//订单时间
 private User user;//用户信息
 private String address;//用户地址

public double getMoney() {
	return money;
}
public void setMoney(double money) {
	this.money = money;
}
public String getReceiverinfo() {
	return receiverinfo;
}
public void setReceiverinfo(String receiverinfo) {
	this.receiverinfo = receiverinfo;
}
public int getPaystate() {
	return paystate;
}
public void setPaystate(int paystate) {
	this.paystate = paystate;
}
public Date getOrderTime() {
	return orderTime;
}
public void setOrderTime(Date orderTime) {
	this.orderTime = orderTime;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	long temp;
	temp = Double.doubleToLongBits(money);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + orderId;
	result = prime * result + ((orderTime == null) ? 0 : orderTime.hashCode());
	result = prime * result + paystate;
	result = prime * result + ((receiverinfo == null) ? 0 : receiverinfo.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	Order other = (Order) obj;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	if (Double.doubleToLongBits(money) != Double.doubleToLongBits(other.money))
		return false;
	if (orderId != other.orderId)
		return false;
	if (orderTime == null) {
		if (other.orderTime != null)
			return false;
	} else if (!orderTime.equals(other.orderTime))
		return false;
	if (paystate != other.paystate)
		return false;
	if (receiverinfo == null) {
		if (other.receiverinfo != null)
			return false;
	} else if (!receiverinfo.equals(other.receiverinfo))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}
@Override
public String toString() {
	return "Order [orderId=" + orderId + ", money=" + money + ", receiverinfo=" + receiverinfo + ", paystate="
			+ paystate + ", orderTime=" + orderTime + ", user=" + user + ", address=" + address + "]";
}



}
