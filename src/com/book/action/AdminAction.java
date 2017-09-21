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

import com.book.dao.IAdminDAO;
import com.book.dao.impl.AdminDAOImpl;
import com.book.dto.Admin;

/**
 * Servlet implementation class AdminAction
 */
@WebServlet("/AdminAction")
public class AdminAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAction() {
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
	String method=request.getParameter("method");
	try {
	if(method.equals("login")){
		login(request,response);
	}else if(method.equals("changepsw")){	
		ChangePsw(request,response);
	}else if(method.equals("save")){
		save(request,response);
	}else if(method.equals("list")){
		list(request,response);
	}else if(method.equals("delete")){
		delete(request,response);
	}else if(method.equals("modify")){
		modify(request,response);
	}else if(method.equals("edit")){
		edit(request,response);
	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num=Integer.parseInt(request.getParameter("id"));
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		try{
			admin=admImpl.get(num);
			if(admin!=null){
				request.setAttribute("admin", admin);
				request.getRequestDispatcher("/admin/modify.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		 try{ 
	        	int num=Integer.parseInt(request.getParameter("Num"));
	        	admin=admImpl.get(num);
	        	 String name=request.getParameter("name");
	        	 admin.setAdminName(name);
	            String sex=request.getParameter("sex");
	            admin.setSex(sex);
	            String psw=request.getParameter("password");
	            admin.setPsw(psw);
	            if(admImpl.update(admin)){
	            	request.setAttribute("msg", "修改成功！！");
					list(request,response);
	            }else{
	            	request.setAttribute("msg", "修改成功！！");
	            	request.getRequestDispatcher("/admin/modify.jsp").forward(request, response);
	            }
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int num=Integer.parseInt(request.getParameter("id"));
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		try{
			admin=admImpl.get(num);
			if(admImpl.delete(admin)){
				request.setAttribute("msg", "删除成功！！");
				list(request,response);
			}else{
				request.setAttribute("msg", "删除失败！！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		List<Admin> admList=new ArrayList<Admin>();
		admList=admImpl.list();
		request.setAttribute("list", admList);
		request.getRequestDispatcher("/admin/list.jsp").forward(request, response);
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		try{
			String adminName=request.getParameter("name");
			admin.setAdminName(adminName);
			String password=request.getParameter("password");
			admin.setPsw(password);
			String sex=request.getParameter("sex");
			admin.setSex(sex);
			if(admImpl.save(admin)){
				request.setAttribute("msg", "添加成功！");
				list(request, response);
			}else{
				request.setAttribute("msg", "添加失败！");
				request.getRequestDispatcher("/admin/save.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String username=request.getParameter("name");
		String password=request.getParameter("password");
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		admin=admImpl.login(username, password);
		if(admin!=null){
			session.setAttribute("admin", admin);
			request.getRequestDispatcher("admin/amain.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("admin/adminLogin.jsp").forward(request, response);
		}
	}
	/**
	 * @param request
	 * @param response
	 */
	private void ChangePsw(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		IAdminDAO admImpl=new AdminDAOImpl();
		Admin admin=new Admin();
		
	    try{
	    	admin=(Admin)session.getAttribute("admin");
            
			String password=request.getParameter("password");
			if(admin.getPsw().equals(password)){
				String newpassword=request.getParameter("newpassword");
				String repassword=request.getParameter("repassword");
				if(newpassword.equals(repassword)){
					admin.setPsw(newpassword);
					if(admImpl.update(admin)){
						
						request.getRequestDispatcher("admin/adminLogin.jsp").forward(request, response);
					}else{
						request.getRequestDispatcher("admin/modifyPassword.jsp").forward(request, response);
					}
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
