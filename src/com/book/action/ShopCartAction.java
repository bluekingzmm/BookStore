package com.book.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.IProductDAO;
import com.book.dao.IShopCartDAO;
import com.book.dao.IUserDAO;
import com.book.dao.impl.ProductDAOImpl;
import com.book.dao.impl.ShopCartDAOImpl;
import com.book.dao.impl.UserDAOImpl;
import com.book.dto.Product;
import com.book.dto.ShopCart;
import com.book.dto.User;



/**
 * Servlet implementation class ShopCartAction
 */
@WebServlet("/ShopCartAction")
public class ShopCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		try {
			String method = request.getParameter("method");
			if (method.equals("save")) {
				save(request, response);
			} else if (method.equals("list")) {
				list(request, response);
			} else if (method.equals("update")) {
				update(request, response);
			} else if (method.equals("delete")) {
				delete(request, response); 
			}else if(method.equals("deleteAll")){
				deleteAll(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void deleteAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user=null;
		IShopCartDAO cartImpl=new ShopCartDAOImpl();
		try{
			user=(User)session.getAttribute("user");
			if(cartImpl.deleteAll(user)){
				request.setAttribute("msg", "清空购物车成功");	
				list(request, response);
			} else {
				request.setAttribute("msg", "清空购物车失败！");
				list(request, response);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Product product=null;
		IProductDAO proImpl=new ProductDAOImpl();
		User user=null;
		IUserDAO userImpl=new UserDAOImpl();
		ShopCart cart=null;
		IShopCartDAO cartImpl=new ShopCartDAOImpl();
		try{
			
			cart = new ShopCart();
			user = (User) session.getAttribute("user");
			int pid = Integer.parseInt(request.getParameter("pid").trim());
			product = proImpl.get(pid);

			if (cartImpl.get(user, product) != null) {
				cart = cartImpl.get(user, product);
				cart.setNum(cart.getNum() + 1);
				if(cartImpl.save(cart)){
					request.setAttribute("msg", "添加成功");	
					list(request, response);
				} else {
					request.setAttribute("msg", "添加失败！");
					list(request, response);
				}
			}
			else {
				cart = new ShopCart();
				int num = 1;
				cart.setNum(num);
				cart.setBook(product);
				cart.setUser(user);
				 if (cartImpl.save(cart)) {
						request.setAttribute("msg", "添加成功");
						
						list(request, response);
					} else {
						request.setAttribute("msg", "添加失败！");
						list(request, response);
					}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IShopCartDAO cartImpl=new ShopCartDAOImpl();
		try{
		if(cartImpl.delete(cartImpl.get(id))){
			request.setAttribute("msg", "删除成功！");
			
			list(request, response);
		} else {
			request.setAttribute("msg", "删除失败！");
			list(request, response);
		}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IShopCartDAO cartImpl=new ShopCartDAOImpl();
	
		ShopCart cart = new ShopCart();
		try {
			int id = Integer.parseInt(request.getParameter("id").trim());
            cart = cartImpl.get(id);
			String num = request.getParameter("quantity");
			if (num == null || num.equals("")) {
				cartImpl.delete(cart);
				
			} else {
				int num1 = Integer.parseInt(request.getParameter("quantity").trim());
				if (num1 < 1){
					cartImpl.delete(cart);
				}else{	
				cart.setNum(num1);
				}
			}
			
				if (cartImpl.update(cart)) {
					request.setAttribute("msg", "修改成功！");
					list(request, response);
				} else {
					request.setAttribute("msg", "修改失败！");
					list(request, response);
				}
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user=null;
		ShopCart cart=null;
		IShopCartDAO cartImpl=new ShopCartDAOImpl();
		double sum=0;
		List<ShopCart> cartList=new ArrayList<ShopCart>();
		try{
		cart=new ShopCart();	
		user=(User)session.getAttribute("user");
	
		cartList=cartImpl.list(user);
		
		for (int i = 0; i < cartList.size(); i++) {
			cart = cartList.get(i);
			sum =sum +cart.getBook().getPrice() * cart.getNum();
		}
		request.setAttribute("totalPrice", sum);
		request.setAttribute("cartList", cartList);
		request.getRequestDispatcher("/user/listShopCart.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
  
	

}
