package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IUserDAO;
import com.book.database.DataBase;
import com.book.dto.User;

public class UserDAOImpl implements IUserDAO{
	@Override
	public boolean save(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
	try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("insert into user (uid,name,sex,psw,email,phone,state,savetime) values (?,?,?,?,?,?,?,?)");
		ps.setInt(1, user.getUid());
		ps.setString(2, user.getName());
		ps.setString(3,user.getSex());
		ps.setString(4, user.getPsw());
		ps.setString(5,user.getEmail());
		ps.setString(6, user.getPhone());
		ps.setInt(7,user.getState());
	
		ps.setDate(8, (java.sql.Date)user.getSaveTime());
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
	public boolean delete(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("delete from user where uid=?");
		ps.setInt(1, user.getUid());
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
	public boolean update(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
		ps=conn.prepareStatement("update user set name=?,sex=?,psw=?,email=?,phone=?,state=?,savetime=? where uid=?");
		ps.setInt(8, user.getUid());
		ps.setString(1, user.getName());
		ps.setString(2, user.getSex());
		ps.setString(3, user.getPsw());
		ps.setString(4, user.getEmail());
		ps.setString(5, user.getPhone());
		ps.setInt(6, user.getState());
		
		ps.setDate(7, (java.sql.Date)user.getSaveTime());
		
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
	public User get(int uid) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from user where uid=?");
		ps.setInt(1, uid);
		rs=ps.executeQuery();
		if(rs.next()){
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPsw(rs.getString("psw"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setSaveTime(rs.getDate("savetime"));
		}
			
			
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return user; 
	}

	@Override
	public List<User> list(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> userList=null;
		User user=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select*from user limit ?,?");
			ps.setInt(1, pageSize * (pageNo - 1));
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			userList=new ArrayList<User>();
			while(rs.next()){
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPsw(rs.getString("psw"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSaveTime(rs.getDate("savetime"));
				userList.add(user);
			}
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return userList;
	}
	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn=DataBase.getConn();
			ps = conn.prepareStatement("select count(*) from user");
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			rs.close();
			ps.close();
			conn.close();
		}
		return count;
	
	}

	@Override
	public User login(String name, String psw) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from user where name=? and psw=?");
		ps.setString(1, name);
		ps.setString(2, psw);
		rs=ps.executeQuery();
		if(rs.next()){
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPsw(rs.getString("psw"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setState(rs.getInt("state"));
			user.setSaveTime(rs.getDate("savetime"));
		}
			
			
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return user;
	}

	

	@Override
	public User get(String name) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from user where name=?");
		ps.setString(1, name);
		rs=ps.executeQuery();
		if(rs.next()){
			user=new User();
			user.setUid(rs.getInt("uid"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPsw(rs.getString("psw"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setSaveTime(rs.getDate("savetime"));
		}
			
			
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return user; 
	}

}
