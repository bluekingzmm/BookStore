package com.book.dao;

import java.util.List;

import com.book.dto.Product;
import com.book.dto.ShopCart;
import com.book.dto.User;

public interface IShopCartDAO {
	public boolean save(ShopCart shopCart) throws Exception;

	public boolean delete(ShopCart shopCart) throws Exception;

	public boolean deleteAll(User user) throws Exception;

	public boolean update(ShopCart shopCart) throws Exception;

	public ShopCart get(int shopCartId) throws Exception;

	public ShopCart get(User userInfo, Product book) throws Exception;

	public List<ShopCart> list(User user) throws Exception;
}
