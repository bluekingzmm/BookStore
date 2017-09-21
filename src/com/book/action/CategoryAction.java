package com.book.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.ICateDAO;
import com.book.dao.impl.CateDAOImpl;
import com.book.dto.CateGory;

/**
 * Servlet implementation class CategoryAction
 */
@WebServlet("/CategoryAction")
public class CategoryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAction(){
        super();   // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		try {
		 if(method.equals("save")){
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
		}catch(Exception e){
		e.printStackTrace();
	}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ICateDAO cateImpl=new CateDAOImpl();
		CateGory category=new CateGory();
		
		int cid=Integer.parseInt(request.getParameter("id"));	
		try{
			category=cateImpl.get(cid);
			if(category!=null){
				request.setAttribute("category", category);
				request.getRequestDispatcher("/book/modifyCate.jsp").forward(request, response);;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("num"));
		ICateDAO cateImpl=new CateDAOImpl();
		CateGory category=null;
		try{
			String cate=request.getParameter("category");
			category=cateImpl.get(cid);
			if(category!=null){
				category.setCate(cate);
				if(cateImpl.update(category)){
					request.setAttribute("msg", "修改成功！");
					list(request, response);
				}else{
					request.setAttribute("msg", "修改失败！");
					list(request, response);
				}
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int cid=Integer.parseInt(request.getParameter("id"));
		ICateDAO cateImpl=new CateDAOImpl();
		CateGory category=new CateGory();
		try{
			category=cateImpl.get(cid);
			if(category!=null){
				if(cateImpl.delete(category)){
					request.setAttribute("msg", "删除成功！");
					list(request, response);
				}else{
					request.setAttribute("msg", "删除失败！");
					list(request, response);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ICateDAO cateImpl=new CateDAOImpl();
		CateGory category=new CateGory();
		List<CateGory> cList=new ArrayList<CateGory>();
		try{
			cList=cateImpl.list();
			request.setAttribute("list", cList);
			request.getRequestDispatcher("/book/catelist.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ICateDAO cateImpl=new CateDAOImpl();
		CateGory category=new CateGory();
		String cate=request.getParameter("category");
		if(cateImpl.get(cate)!=null){
			request.setAttribute("msg","类型已存在，不可添加" );
			request.getRequestDispatcher("/book/addCate.jsp").forward(request, response);
		}else{
		category.setCate(cate);
		if(cateImpl.save(category)){
			request.setAttribute("msg","添加成功！" );
			list(request,response);
		}else{
			request.setAttribute("msg","添加成功！" );
		}
		}
	}

}
