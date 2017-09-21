package com.book.action;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.dao.IProductDAO;
import com.book.dao.IUserDAO;
import com.book.dao.impl.ProductDAOImpl;
import com.book.dao.impl.UserDAOImpl;
import com.book.dto.Product;
import com.book.dto.User;
import com.book.util.Mail;
import com.book.util.MailUtils;
import com.book.util.Uuid;


/**
 * Servlet implementation class UserAction
 */
@WebServlet("/UserAction")
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAction() {
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
		String operato=request.getParameter("operato");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		try {
			if(operato.equals("login")){
				login(request,response);
			}else if(operato.equals("save")){
				save(request,response);
			}else if(operato.equals("modify")){
				modify(request,response);
			}else if(operato.equals("list")){
				list(request,response);
			}else if(operato.equals("changePsw")){
				changepsw(request,response);
			}else if(operato.equals("quit")){
				quit(request,response);
			}else if(operato.equals("delete")){
				delete(request,response);
			}else if(operato.equals("edit")){
				edit(request,response);
			}else if(operato.equals("person"))
				person(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IUserDAO userImpl=new UserDAOImpl();
        User user=new User();
        try{
        	int id=Integer.parseInt(request.getParameter("id").trim());
        	user=userImpl.get(id);
        	if(user!=null){
        		request.setAttribute("user", user);
        		request.getRequestDispatcher("/user/modify.jsp").forward(request, response);
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	private void person(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IUserDAO userImpl=new UserDAOImpl();
        User user=new User();
        IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
        try{ 
        	int num=Integer.parseInt(request.getParameter("Num"));
        	user=userImpl.get(num);
        String name=request.getParameter("name");
         user.setName(name);
        String sex=request.getParameter("sex");
        user.setSex(sex);
        String psw=request.getParameter("password");
        user.setPsw(psw);
        String email=request.getParameter("email");
        user.setEmail(email);
        String phone=request.getParameter("phone");
        user.setPhone(phone);
        if(userImpl.update(user)){
        	request.setAttribute("msg", "修改成功！！");
        	List<Product> proList=proImpl.list();
        	request.setAttribute("proList", proList);
        	request.getRequestDispatcher("/lomain.jsp").forward(request, response);
        }else{
        	request.setAttribute("msg", "修改失败！！");
        	request.getRequestDispatcher("/lomain.jsp").forward(request, response);
        }
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IUserDAO userImpl=new UserDAOImpl();
        User user=new User();
        try{ 
        	int num=Integer.parseInt(request.getParameter("Num"));
        	user=userImpl.get(num);
        String name=request.getParameter("name");
         user.setName(name);
        String sex=request.getParameter("sex");
        user.setSex(sex);
        String psw=request.getParameter("password");
        user.setPsw(psw);
        String email=request.getParameter("email");
        user.setEmail(email);
        String phone=request.getParameter("phone");
        user.setPhone(phone);
        if(userImpl.update(user)){
        	request.setAttribute("msg", "修改成功！！");
        	
        	list(request,response);
        }else{
        	request.setAttribute("msg", "修改失败！！");
        	request.getRequestDispatcher("/admin/modify.jsp").forward(request, response);
        }
        	
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IUserDAO userImpl=new UserDAOImpl();
        User user=new User();
        try{
        	int id=Integer.parseInt(request.getParameter("id").trim());
        	user=userImpl.get(id);
        	if(userImpl.delete(user)){
        		list(request,response);
        	}else{
        		request.setAttribute("msg", "删除失败，请核对信息后删除");
        		list(request,response);
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

	private void quit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
		try{
			if(session!=null){	
			session.removeAttribute("user");
			List<Product> proList=proImpl.list();	
			request.setAttribute("proList", proList);
			request.getRequestDispatcher("/lomain.jsp").forward(request, response);
			}	
		}catch(Exception e){
			throw e;
		}
	}

	private void changepsw(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		 IUserDAO userImpl=new UserDAOImpl();
         User user=new User();
         try{
		 user=(User) session.getAttribute("user");
		 String password=request.getParameter("password");
		 if(user.getPsw().equals(password)){
			 String newpassword=request.getParameter("newpassword");
			 String repassword=request.getParameter("repassword");
			 if(newpassword.equals(repassword)){
				 user.setPsw(newpassword);
				 if(userImpl.update(user)){
					 request.setAttribute("mseg", "修改成功，请重新登录！");
					 request.getRequestDispatcher("login.jsp").forward(request, response);
				 }else{
					 request.setAttribute("mseg", "修改失败");
					 request.getRequestDispatcher("user/modifyPassword").forward(request, response);
				 }
			 }else{
				 request.setAttribute("msg", "两次密码输入不一致");
			 }
		 }else{
			 request.setAttribute("msg", "原密码输入错误"); 
		 }
         }catch(Exception e){
        	 e.printStackTrace();
        	 throw e;
         }
		
		
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IUserDAO userImpl=new UserDAOImpl();
		List<User> uList=new ArrayList<User>();
		User user=null;
		int pageNo = 1;
		int pageSize = 7;
		int count = 0;
		try{
			if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals(""))
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
			count=userImpl.getCount();
			uList=userImpl.list(pageSize,pageNo);
			request.setAttribute("list", uList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", (int) Math.ceil((float) count / pageSize));
			request.getRequestDispatcher("/user/list.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession sessio=request.getSession();
	         IUserDAO userImpl=new UserDAOImpl();
	         User user=new User();
	         try{
	         String username=request.getParameter("user");
	         if(username!=null||!username.equals("")){
	        	 user.setName(username);
	         }
	         String userpsw=request.getParameter("passwd");
	         if(userpsw!=null||!userpsw.equals("")){
	        	 user.setPsw(userpsw);
	         }
	         String sex=request.getParameter("sex");
	         if(sex!=null||!sex.equals("")){
	        	user.setSex(sex); 
	         }
	         String phone=request.getParameter("telephone");
	         if(phone!=null||!phone.equals("")){
	        	 user.setPhone(phone);
	         }
	         String email=request.getParameter("email");
	         if(email!=null||!email.equals("")){
	        	 user.setEmail(email);
	         }
	         SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();// 得到系统当前时间
				String strDate = dateformat.format(date);// 将系统当前时间格式化
				Date regtime = java.sql.Date.valueOf(strDate);
				user.setSaveTime(regtime);
				user.setState(0);
				if(userImpl.get(user.getName())==null){
				   if(userImpl.save(user)){
					request.setAttribute("mseg", "恭喜，注册成功！请登录");

					request.getRequestDispatcher("/login.jsp").forward(request, response);
					
				} else {
					request.setAttribute("mseg", "注册失败！");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				}else{
					request.getRequestDispatcher("/login.jsp").forward(request, response);
					}   
	         }catch(Exception e){
	        	e.printStackTrace();
	         }
			}
				

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		IUserDAO userImpl=new UserDAOImpl();
		User user=new User();
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
		user=userImpl.login(username, password);
		if(user!=null){
		    List<Product> proList=proImpl.list();	
			session.setAttribute("user", user);
			request.setAttribute("proList", proList);
			request.getRequestDispatcher("/lomain.jsp").forward(request, response);
			request.setAttribute("mseg", "登录成功！");
		  
		}else{
			request.setAttribute("mseg", "登录失败！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	

	}


