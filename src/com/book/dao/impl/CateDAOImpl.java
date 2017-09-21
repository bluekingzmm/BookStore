package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.ICateDAO;
import com.book.database.DataBase;
import com.book.dto.CateGory;

public class CateDAOImpl implements ICateDAO {

	@Override
	public boolean save(CateGory cate) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();	
		String sql="insert into category (cid,cate) values (?,?)";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cate.getCid());
		ps.setString(2, cate.getCate());
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
	public boolean delete(CateGory cate) throws Exception {
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("delete from category where cid=?");
		ps.setInt(1,cate.getCid());
		if(ps.executeUpdate()>0)
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			ps.close();
			conn.close();
		}
		return false;
		
	}

	@Override
	public boolean update(CateGory cate) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("update category set cate=? where cid=?");
			ps.setInt(2,cate.getCid());
			ps.setString(1, cate.getCate());
			if(ps.executeUpdate()>0)
				return true;
			else
				return false;
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				DataBase.commit();
				ps.close();
				conn.close();
			}
			return false;
	}

	@Override
	public CateGory get(int num) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		CateGory category=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from category where cid=?");
		ps.setInt(1, num);
		rs=ps.executeQuery();
		if(rs.next()){
			category=new CateGory();
			category.setCid(rs.getInt("cid"));
			category.setCate(rs.getString("cate"));
		}	
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return category; 
	
	}
	

	@Override
	public List<CateGory> list() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		CateGory category=null;
		List<CateGory> cateList=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from category");
			cateList=new ArrayList<CateGory>();
			rs=ps.executeQuery();
			while(rs.next()){
				category=new CateGory();
				category.setCid(rs.getInt("cid"));
				category.setCate(rs.getString("cate"));
				cateList.add(category);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return cateList;
	}

	@Override
	public CateGory get(String cate) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		CateGory category=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from category where cate=?");
		ps.setString(1, cate);
		rs=ps.executeQuery();
		if(rs.next()){
			category=new CateGory();
			category.setCid(rs.getInt("cid"));
			category.setCate(rs.getString("cate"));
		}	
		}catch(Exception e){
			throw e;
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();
		}
		return category; 
	
	}

	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
