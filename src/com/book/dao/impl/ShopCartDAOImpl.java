package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.book.dao.IShopCartDAO;
import com.book.database.DataBase;
import com.book.dto.CateGory;
import com.book.dto.Product;
import com.book.dto.ShopCart;
import com.book.dto.User;

public class ShopCartDAOImpl implements IShopCartDAO{

	@Override
	public boolean save(ShopCart shopCart) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("insert into shopcart(cartId,uid,pid,num) values (?,?,?,?)");
		ps.setInt(1, shopCart.getCartid());
		ps.setInt(2, shopCart.getUser().getUid());
		ps.setInt(3, shopCart.getBook().getPid());
		ps.setInt(4, shopCart.getNum());
		if(ps.executeUpdate()>0){
			return true;
		}else{
			return false;
		}
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
	public boolean delete(ShopCart shopCart) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("delete from shopcart where cartId=?");
			ps.setInt(1, shopCart.getCartid());
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
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
	public boolean deleteAll(User user) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("delete from shopcart where uid=?");
			ps.setInt(1, user.getUid());
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
			
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
	public boolean update(ShopCart shopCart) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("update shopcart set uid=?,pid=?,num=? where cartId=?");	
			ps.setInt(1,shopCart.getUser().getUid());
			ps.setInt(2, shopCart.getBook().getPid());
			ps.setInt(3, shopCart.getNum());
			ps.setInt(4,shopCart.getCartid());
			if(ps.executeUpdate()>0){
				return true;
			}else{
				return false;
			}
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
	public ShopCart get(int shopCartId) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		ShopCart shopCart=null;
		Product product=null;
		User user=null;
		CateGory category=null;
	try{
		conn=DataBase.getConn();
		ps=conn.prepareStatement("select * from shopcart_view where cartId=?");
		ps.setInt(1, shopCartId);
		rs=ps.executeQuery();
		if (rs.next()){
			shopCart=new ShopCart();
			shopCart.setNum(rs.getInt("num"));
			shopCart.setCartid(rs.getInt("cartId"));
			
			product=new Product();
        	product.setPid(rs.getInt("pid"));
        	product.setName(rs.getString("pname"));
        	product.setRelprice(rs.getDouble("relprice"));;
        	product.setPrice(rs.getDouble("price"));
        	product.setImgUrl(rs.getString("imgurl"));
        	product.setMessage(rs.getString("message"));
        	product.setAuthor(rs.getString("author"));
        	
        	
        	category=new CateGory();
        	category.setCid(rs.getInt("cid"));
        	category.setCate(rs.getString("cate"));
        	product.setCate(category);
        	shopCart.setBook(product);
        	
        	user=new User();
			user.setUid(rs.getInt("uid"));
			user.setName(rs.getString("name"));
			user.setSex(rs.getString("sex"));
			user.setPsw(rs.getString("psw"));
			user.setPhone(rs.getString("phone"));
			user.setEmail(rs.getString("email"));
			user.setSaveTime(rs.getDate("savetime"));
			shopCart.setUser(user);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
	return shopCart;
		
	}

	@Override
	public ShopCart get(User userInfo, Product book) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		ShopCart shopCart=null;
		Product product=null;
		User user=null;
		CateGory category=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from shopcart_view where uid=? and pid=?");
			ps.setInt(1, userInfo.getUid());
			ps.setInt(2, book.getPid());
			rs=ps.executeQuery();
			if (rs.next()){
				shopCart=new ShopCart();
				shopCart.setNum(rs.getInt("num"));
				shopCart.setCartid(rs.getInt("cartId"));
				
				product=new Product();
	        	product.setPid(rs.getInt("pid"));
	        	product.setName(rs.getString("pname"));
	        	product.setRelprice(rs.getDouble("relprice"));;
	        	product.setPrice(rs.getDouble("price"));
	        	product.setImgUrl(rs.getString("imgurl"));
	        	product.setMessage(rs.getString("message"));
	        	product.setAuthor(rs.getString("author"));
	        	
	        	
	        	category=new CateGory();
	        	category.setCid(rs.getInt("cid"));
	        	category.setCate(rs.getString("cate"));
	        	product.setCate(category);
	        	shopCart.setBook(product);
	        	
	        	user=new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPsw(rs.getString("psw"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSaveTime(rs.getDate("savetime"));
				shopCart.setUser(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return shopCart;
		
	}

	@Override
	public List<ShopCart> list(User userInfo) throws Exception {
		// TODO Auto-generated method stub
		Connection conn=null;
		ResultSet rs=null;
		PreparedStatement ps=null;
		ShopCart shopCart=null;
		List<ShopCart> cartList=null;
		Product product=null;
		User user=null;
		CateGory category=null;
		try{
			conn=DataBase.getConn();
			ps=conn.prepareStatement("select * from shopcart_view where uid=?");
			ps.setInt(1, userInfo.getUid());
			rs=ps.executeQuery();
			cartList=new ArrayList<ShopCart>();
			while (rs.next()){
				shopCart=new ShopCart();
				shopCart.setNum(rs.getInt("num"));
				shopCart.setCartid(rs.getInt("cartId"));
				
				product=new Product();
	        	product.setPid(rs.getInt("pid"));
	        	product.setName(rs.getString("pname"));
	        	product.setRelprice(rs.getDouble("relprice"));;
	        	product.setPrice(rs.getDouble("price"));
	        	product.setImgUrl(rs.getString("imgurl"));
	        	product.setMessage(rs.getString("message"));
	        	product.setAuthor(rs.getString("author"));
	        	
	        	category=new CateGory();
	        	category.setCid(rs.getInt("cid"));
	        	category.setCate(rs.getString("cate"));
	        	product.setCate(category);
	        	shopCart.setBook(product);
	        	
	        	user=new User();
				user.setUid(rs.getInt("uid"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setPsw(rs.getString("psw"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setSaveTime(rs.getDate("savetime"));
				shopCart.setUser(user);
				cartList.add(shopCart);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
		        if(conn!=null){
		            conn.close();
		        }
		        if(ps!=null){
		            ps.close();
		        }
		        if(rs!=null){
		            rs.close();
		        }
		         
		    }catch( SQLException e)
		    {e.printStackTrace();
		    }
		}
		return cartList;
	}

}
