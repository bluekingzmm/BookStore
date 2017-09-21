package com.book.dao;

import java.util.List;

import com.book.dto.CateGory;
import com.book.dto.Product;
public interface IProductDAO {
	public boolean save(Product book)throws Exception;
    public boolean delete(Product book)throws Exception;
    public boolean update(Product book)throws Exception;
    public Product get(int pid)throws Exception;
    public List<Product> find(int cid)throws Exception;
    public List<Product> list(int pageSize, int pageNo)throws Exception;
	public int getCount() throws Exception;
	public List<Product> list() throws Exception;
	public List<Product> get(String name)throws Exception;
}
