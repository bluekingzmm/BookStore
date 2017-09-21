package com.book.dao;

import java.util.List;

import com.book.dto.CateGory;



public interface ICateDAO {
	public boolean save(CateGory cate)throws Exception;
    public boolean delete(CateGory cate)throws Exception;
    public boolean update(CateGory cate)throws Exception;
    public CateGory get(int num)throws Exception;
    public CateGory get(String cate)throws Exception;
    public List<CateGory> list()throws Exception;
    public int getCount()throws Exception;
}
