package com.book.dao;

import java.util.List;
import com.book.dto.Admin;

public interface IAdminDAO {
    public boolean save(Admin admin)throws Exception;
    public boolean delete(Admin admin)throws Exception;
    public boolean update(Admin admin)throws Exception;
    public Admin get(int num)throws Exception;
    public List<Admin> list()throws Exception;
    public Admin login(String name,String password)throws Exception;
	
}
