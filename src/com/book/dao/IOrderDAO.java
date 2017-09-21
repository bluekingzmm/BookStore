package com.book.dao;

import java.util.List;

import com.book.dto.Order;



public interface IOrderDAO {
	public boolean save(Order or)throws Exception; 
	public boolean delete(Order or)throws Exception;
	public boolean update(Order or)throws Exception;
	public Order get(int oid)throws Exception;
	public List<Order> list(int pageNo,int pageSize)throws Exception;
	
}
