package com.book.dao;

import java.util.List;

import com.book.dto.User;

public interface IUserDAO {
public boolean save(User user)throws Exception; 
public boolean delete(User user)throws Exception;
public boolean update(User user)throws Exception;
public User get(int uid)throws Exception;
public User get(String name)throws Exception;
public List<User> list(int pageSize, int pageNo)throws Exception;
public User login(String name,String psw)throws Exception;
int getCount() throws Exception;
}
