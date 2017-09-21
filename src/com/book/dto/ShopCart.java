package com.book.dto;

public class ShopCart {
private int cartid;//���ﳵ���
private int num;//����
private User user;//�û���Ϣ
private Product book;//��Ʒ��Ϣ
public int getCartid() {
	return cartid;
}
public void setCartid(int cartid) {
	this.cartid = cartid;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Product getBook() {
	return book;
}
public void setBook(Product book) {
	this.book = book;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((book == null) ? 0 : book.hashCode());
	result = prime * result + cartid;
	result = prime * result + num;
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
	ShopCart other = (ShopCart) obj;
	if (book == null) {
		if (other.book != null)
			return false;
	} else if (!book.equals(other.book))
		return false;
	if (cartid != other.cartid)
		return false;
	if (num != other.num)
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
	return "ShopCart [cartid=" + cartid + ", num=" + num + ", user=" + user + ", book=" + book + "]";
}

}

