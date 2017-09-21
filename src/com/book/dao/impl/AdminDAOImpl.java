package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IAdminDAO;
import com.book.dto.Admin;

import com.book.database.DataBase;;

public class AdminDAOImpl implements IAdminDAO{

	@Override
	public boolean save(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
		ps=conn.prepareStatement("insert into admin (adminId,adminName,sex,psw) values (?,?,?,?)");
		ps.setInt(1, admin.getAdminId());
		ps.setString(2, admin.getAdminName());
		ps.setString(3, admin.getSex());
		ps.setString(4, admin.getPsw());
		
		if(ps.executeUpdate()>0)
			return true;
		else
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			ps.close();
			conn.close();
		}
	}

	@Override
	public boolean delete(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("delete from admin where adminId=?");
		ps.setInt(1, admin.getAdminId());
		if(ps.executeUpdate()>0)
			return true;
		else
			return false;
		}catch(Exception e){
			throw e;
		}finally {
			DataBase.commit();
			ps.close();
			conn.close();
		}
		
	}

	@Override
	public boolean update(Admin admin) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
		ps=conn.prepareStatement("update admin set adminName=?,sex=?,psw=? where adminId=?");
		ps.setInt(4, admin.getAdminId());
		ps.setString(1, admin.getAdminName());
		ps.setString(2, admin.getSex());
		ps.setString(3, admin.getPsw());
		
		if(ps.executeUpdate()>0)
			return true;
		else
			return false;
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			ps.close();
			conn.close();
		}
	}

	@Override
	public Admin get(int num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Admin admin=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from admin where adminId=?");
			ps.setInt(1, num);
			rs=ps.executeQuery();
			if(rs.next()){
			admin=new Admin();
			admin.setAdminId(rs.getInt("adminId"));
			admin.setAdminName(rs.getString("adminName"));
			admin.setSex(rs.getString("sex"));
			admin.setPsw(rs.getString("psw"));
}
			
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return admin;
	}

	@Override
	public List<Admin> list() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Admin> adList=null;
		Admin admin=null;
		try{
			conn=DataBase.getConn();
			adList=new ArrayList();
			ps=conn.prepareStatement("select * from admin");
			rs=ps.executeQuery();
			while(rs.next()){
			admin=new Admin();
			admin.setAdminId(rs.getInt("adminId"));
			admin.setAdminName(rs.getString("adminName"));
			admin.setSex(rs.getString("sex"));
			admin.setPsw(rs.getString("psw"));
			adList.add(admin);
}
			
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return adList;
	
	}

	@Override
	public Admin login(String name, String password) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Admin admin=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from admin where adminName=? and psw=?");
			ps.setString(1, name);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
			admin=new Admin();
			admin.setAdminId(rs.getInt("adminId"));
			admin.setAdminName(rs.getString("adminName"));
			admin.setSex(rs.getString("sex"));
			admin.setPsw(rs.getString("psw"));
}
			
		}catch(Exception e){
			throw e;
		}finally{
			
			rs.close();
			ps.close();
			conn.close();
		}
		return admin;
	}

}
