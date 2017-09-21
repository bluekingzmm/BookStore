package com.book.dao;

import java.util.List;

import com.book.dto.OrderItem;

public interface IOrderItemDAO {
	public boolean save(OrderItem order)throws Exception;
    public boolean delete(OrderItem order)throws Exception;
    public boolean update(OrderItem order)throws Exception;
    public OrderItem get(int tid)throws Exception;
    public List<OrderItem> list()throws Exception;
}
