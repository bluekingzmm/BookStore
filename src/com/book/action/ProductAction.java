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
import com.book.dao.IProductDAO;
import com.book.dao.impl.CateDAOImpl;
import com.book.dao.impl.ProductDAOImpl;
import com.book.dto.CateGory;
import com.book.dto.Product;



/**
 * Servlet implementation class ProductAction
 */
@WebServlet("/ProductAction")
public class ProductAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductAction() {
        super();
        // TODO Auto-generated constructor stub
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
		 String operato="listAll";
		 String method=request.getParameter("method");
		try {
		 if(method!=null&&method.equals("save")){
			save(request,response);
		}else if(method!=null&&method.equals("list")){
			list(request,response);
		}else if(method!=null&&method.equals("delete")){
			delete(request,response);
		}else if(method!=null&&method.equals("modify")){
			modify(request,response);
		}else if(method!=null&&method.equals("edit")){
			edit(request,response);
	}else if(method!=null&&method.equals("create")){
		create(request,response);
	}else if(method!=null&&method.equals("changeState")){
		changeState(request,response);
	}else if(method!=null&&method.equals("listByCate")){
		listByCate(request,response);
	}else if(method!=null&&method.equals("product")){
		product(request,response);
	}else if(method!=null&&method.equals("select")){
		select(request,response);
	}
	if(operato!=null&&operato.equals("listAll")){
		listAll(request,response);
	}	 
		}catch(Exception e){
		e.printStackTrace();
	}

}
	private void select(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String keyWord=request.getParameter("keyWord");
		IProductDAO proImpl=new ProductDAOImpl();
		List<Product> proList=null;
		try{
			proList=new ArrayList<Product>();
			proList=proImpl.get(keyWord);
			if(proList!=null){
				request.setAttribute("proList", proList);
				request.getRequestDispatcher("/list.jsp").forward(request, response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void product(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
		try{
			product=proImpl.get(id);
			if(product!=null){
				request.setAttribute("product", product);
				request.getRequestDispatcher("/book/Product.jsp").forward(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}

	private void listAll(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
		try{
			List<Product> proList=proImpl.list();
	        request.setAttribute("proList", proList);
	        request.getRequestDispatcher("/lomain.jsp").forward(request, response);
			
       }catch(Exception e){
			e.printStackTrace();
		}
	}

	private void listByCate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int cid = Integer.parseInt(request.getParameter("id").trim());
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
		
		try{
			List<Product> proList=proImpl.find(cid);
	        request.setAttribute("proList", proList);
	        request.getRequestDispatcher("/list.jsp").forward(request, response);
			
       }catch(Exception e){
			e.printStackTrace();
		}
	}

	private void changeState(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		IProductDAO proImpl=new ProductDAOImpl();
		Product product=new Product();
	try{	
		int id = Integer.parseInt(request.getParameter("id").trim());
		product =proImpl.get(id);
		int state = Integer.parseInt(request.getParameter("state").trim());
		if (state == 0) {
			product.setState(1);
		} else {
			product.setState(0);
		}
		if(proImpl.update(product)){
			request.setAttribute("msg", "修改成功！");
			list(request,response);
		}else{
			request.setAttribute("msg", "修改失败！");
			list(request,response);
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ICateDAO cateImpl=new CateDAOImpl();
		List<CateGory> cateList=null;
		try{
			 cateList=new ArrayList<CateGory>();
	            cateList=cateImpl.list();
	            request.setAttribute("catelist", cateList);
	            request.getRequestDispatcher("/book/save.jsp").forward(request, response);
			
        }catch(Exception e){
			e.printStackTrace();
		}
	}

	private void save(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		IProductDAO proImpl=null;
		Product product=null;
		CateGory category=null;
		try{
			proImpl=new ProductDAOImpl();
			product=new Product();
			category=new CateGory();
		String name=request.getParameter("bookname");
		if (name != null ||! name.equals("")) {
		product.setName(name);
		}
		String author=request.getParameter("author");
		if (author != null ||! author.equals("")) {
			product.setAuthor(author);
			}
		
		String price=request.getParameter("price");
		if (price != null ||! price.equals("")) {
			double prices=Double.parseDouble(price);
			product.setPrice(prices);
			}
		String imgUrl=request.getParameter("imgUrl");
		if (imgUrl != null ||! imgUrl.equals("")){
			product.setImgUrl(imgUrl);
		}
		String cid=request.getParameter("cid");
		if (cid != null ||! cid.equals("")) {
			int c=Integer.parseInt(cid);
			category.setCid(c);
			product.setCate(category);
			}
		String message=request.getParameter("message");
		if (message != null ||! message.equals("")) {
			product.setMessage(message);;
			}
		/*
		 * 图片获取
		 */
		double relPrice=Double.parseDouble(request.getParameter("relprice"));
		product.setRelprice(relPrice);
		product.setState(1);
		if(proImpl.save(product)){
			request.setAttribute("msg","添加成功！" );
			
			list(request,response);
		}else{
			request.setAttribute("msg", "添加失败！");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IProductDAO proImpl=new ProductDAOImpl();
		ICateDAO cateImpl=new CateDAOImpl();
		Product product=null;
		CateGory category=null;
		List<CateGory> cateList=null;
		try{
		product=new Product();
		product=proImpl.get(id);
		if(product!=null){
			cateList=new ArrayList<CateGory>();
			cateList=cateImpl.list();
			request.setAttribute("catelist", cateList);
			request.setAttribute("product", product);
			request.getRequestDispatcher("/book/modify.jsp").forward(request, response);
		}
				
		}catch(Exception e){
			e.printStackTrace();
		}
	}
  
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IProductDAO proImpl=null;
		Product product=null;
		CateGory category=null;
		try{
			proImpl=new ProductDAOImpl();
			product=proImpl.get(id);
			category=new CateGory();
      if(product!=null){			
		String name=request.getParameter("bookname");
		if (name != null ||! name.equals("")) {
		product.setName(name);
		}
		String author=request.getParameter("author");
		if (author != null ||! author.equals("")) {
			product.setAuthor(author);
			}
		String price=request.getParameter("price");
		if (price != null ||! name.equals("")) {
			double prices=Double.parseDouble(price);
			product.setPrice(prices);;
			}
		
		String cid=request.getParameter("cid");
		if (cid != null ||! cid.equals("")) {
			int c=Integer.parseInt(cid);
			category.setCid(c);
			product.setCate(category);
			}
		String message=request.getParameter("message");
		if (message != null ||! message.equals("")) {
			product.setMessage(message);;
			}
		/*
		 * 图片获取
		 */

		double relPrice=Double.parseDouble(request.getParameter("relprice"));
		product.setRelprice(relPrice);
		if(proImpl.update(product)){
			request.setAttribute("msg","修改成功！" );
			
			list(request,response);
		}else{
			list(request,response);
			request.setAttribute("msg", "修改失败！");
		}
      }else{
			request.setAttribute("msg", "该商品不存在，请核对后修改");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		IProductDAO proImpl=null;
		Product product=null;
		try{
			proImpl=new ProductDAOImpl();
			product=proImpl.get(id);
			if(product!=null){
				if(proImpl.delete(product)){
					list(request,response);
					request.setAttribute("msg", "删除成功");
				}else{
					list(request,response);
					request.setAttribute("msg", "删除失败");
				}
			}else{
				request.setAttribute("msg", "删除不存在");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		IProductDAO proImpl=new ProductDAOImpl();
		ICateDAO cateImpl=new CateDAOImpl();
		Product product=null;
		CateGory category=null;
		List<Product> productList=null;
		List<CateGory> cateList=null;
		
		
		int pageNo = 1;
		int pageSize = 10;
		int count = 0;
	
		try{
			if (request.getParameter("pageNo") != null && !request.getParameter("pageNo").equals(""))
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
			
			count=proImpl.getCount();
			productList=new ArrayList<Product>();
			productList = proImpl.list(pageSize, pageNo);
            request.setAttribute("prolist", productList);
            
            cateList=new ArrayList<CateGory>();
            cateList=cateImpl.list();
            request.setAttribute("catelist", cateList);
			request.setAttribute("count", count);
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("totalPage", (int) Math.ceil((float) count / pageSize));
			request.getRequestDispatcher("/book/list.jsp").forward(request, response);
		}catch(Exception e){
			
		}
		
	}

	
}
