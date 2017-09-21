package com.book.dto;

public class OrderItem {
private int mid;//订单详情编号
private Product prod;//产品信息
private Order order;//订单信息
private String buynum;//购买数量
private double buyprice;//购买价格

public Product getProd() {
	return prod;
}
public void setProd(Product prod) {
	this.prod = prod;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public String getBuynum() {
	return buynum;
}
public void setBuynum(String buynum) {
	this.buynum = buynum;
}
public double getBuyprice() {
	return buyprice;
}
public void setBuyprice(double buyprice) {
	this.buyprice = buyprice;
}
public int getMid() {
	return mid;
}
public void setMid(int mid) {
	this.mid = mid;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((buynum == null) ? 0 : buynum.hashCode());
	long temp;
	temp = Double.doubleToLongBits(buyprice);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + mid;
	result = prime * result + ((order == null) ? 0 : order.hashCode());
	result = prime * result + ((prod == null) ? 0 : prod.hashCode());
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
	OrderItem other = (OrderItem) obj;
	if (buynum == null) {
		if (other.buynum != null)
			return false;
	} else if (!buynum.equals(other.buynum))
		return false;
	if (Double.doubleToLongBits(buyprice) != Double.doubleToLongBits(other.buyprice))
		return false;
	if (mid != other.mid)
		return false;
	if (order == null) {
		if (other.order != null)
			return false;
	} else if (!order.equals(other.order))
		return false;
	if (prod == null) {
		if (other.prod != null)
			return false;
	} else if (!prod.equals(other.prod))
		return false;
	return true;
}
@Override
public String toString() {
	return "OrderItem [mid=" + mid + ", prod=" + prod + ", order=" + order + ", buynum=" + buynum + ", buyprice="
			+ buyprice + "]";
}


}
