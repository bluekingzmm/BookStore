package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IProductDAO;
import com.book.database.DataBase;
import com.book.dto.CateGory;
import com.book.dto.Product;

public class ProductDAOImpl implements IProductDAO{

	@Override
	public boolean save(Product book) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		int i=1;	
		conn=DataBase.getConn();
		ps=conn.prepareStatement("insert into product (pid,pname,relprice,price,cid,imgurl,message,author,state) values (?,?,?,?,?,?,?,?,?)");
		ps.setInt(i++, book.getPid());
		ps.setString(i++,book.getName());
		ps.setDouble(i++, book.getRelprice());
		ps.setDouble(i++, book.getPrice());
		ps.setInt(i++, book.getCate().getCid());
		ps.setString(i++, book.getImgUrl());
		ps.setString(i++, book.getMessage());
		ps.setString(i++, book.getAuthor());
		ps.setInt(i++, book.getState());
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
	public boolean delete(Product book) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("delete from Product where pid=?");
		ps.setInt(1, book.getPid());
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
	public boolean update(Product book) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			int i=1;	
			conn=DataBase.getConn();
		ps=conn.prepareStatement("update product set pname=?,relprice=?,price=?,cid=?,imgurl=?,message=?,author=? ,state=? where pid=? ");
		
		ps.setString(i++,book.getName());
		ps.setDouble(i++, book.getRelprice());
		ps.setDouble(i++, book.getPrice());
		ps.setInt(i++, book.getCate().getCid());
		ps.setString(i++, book.getImgUrl());
		ps.setString(i++, book.getMessage());
		ps.setString(i++, book.getAuthor());
		ps.setInt(i++, book.getState());
		ps.setInt(i++, book.getPid());
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
	public Product get(int pid)throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		CateGory cate=null;
		try{
			int i=1;
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from pro_cate_view where pid=?");
			ps.setInt(1, pid);
			rs=ps.executeQuery();
        if(rs.next()){
        	product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	product.setState(rs.getInt("state"));
        	cate=new CateGory();
        	cate.setCid(rs.getInt("cid"));
        	cate.setCate(rs.getString("cate"));
        	product.setCate(cate);
        }
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();	
		}
		return product;
	}

	@Override
	public List<Product> list(int pageSize, int pageNo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		CateGory cate=null;
		List<Product> productList=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from pro_cate_view  limit ?,?");
		ps.setInt(1, pageSize * (pageNo - 1));
		ps.setInt(2, pageSize);
		rs=ps.executeQuery();
		productList=new ArrayList<Product>();
		while(rs.next()){
			product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	product.setState(rs.getInt("state"));
        	
        	cate=new CateGory();
        	cate.setCid(rs.getInt("cid"));
        	cate.setCate(rs.getString("cate"));
        	product.setCate(cate);
        	productList.add(product);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();	
		}
		return productList;
	}

	@Override
	public int getCount() throws Exception{
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn=DataBase.getConn();
			ps = conn.prepareStatement("select count(*) from pro_cate_view");
			rs = ps.executeQuery();
			if(rs.next()) {
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
	public List<Product> find(int cid) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		List<Product> productList=null;
		CateGory cate=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from pro_cate_view where cid=?");
		ps.setInt(1, cid);
		rs=ps.executeQuery();
		productList=new ArrayList<Product>();
		while(rs.next()){
			product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	product.setState(rs.getInt("state"));
        	
        	cate=new CateGory();
        	cate.setCid(rs.getInt("cid"));
        	cate.setCate(rs.getString("cate"));
        	product.setCate(cate);
        	productList.add(product);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();	
		}
		return productList;
	}

	@Override
	public List<Product> list() throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		CateGory cate=null;
		List<Product> productList=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from pro_cate_view ");
		rs=ps.executeQuery();
		productList=new ArrayList<Product>();
		while(rs.next()){
			product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	product.setState(rs.getInt("state"));
        	
        	cate=new CateGory();
        	cate.setCid(rs.getInt("cid"));
        	cate.setCate(rs.getString("cate"));
        	product.setCate(cate);
        	productList.add(product);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();	
		}
		return productList;
	}

	@Override
	public List<Product> get(String name) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Product product=null;
		CateGory cate=null;
		List<Product> productList=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from pro_cate_view where pname like '%"+name+"%' or author like '%"+name+"%'");
		rs=ps.executeQuery();
		productList=new ArrayList<Product>();
		while(rs.next()){
			product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	product.setState(rs.getInt("state"));
        	
        	cate=new CateGory();
        	cate.setCid(rs.getInt("cid"));
        	cate.setCate(rs.getString("cate"));
        	product.setCate(cate);
        	productList.add(product);
		}
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DataBase.commit();
			rs.close();
			ps.close();
			conn.close();	
		}
		return productList;
	}

	

	
}	
