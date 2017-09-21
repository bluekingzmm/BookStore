<%@page import="java.util.ArrayList"%>
<%@page import="com.book.dto.CateGory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>  
</head>
<body>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 管理员列表</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
       <span style="float:left;margin-left:50px;black;font-size:15px;"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
      </ul>
    </div>
   
    <table class="table table-hover text-center">
      
       <tr>
				<th align="center">
					分类编号
				</th>
				<th align="center">
					分类类名
				</th>
				
				<th align="center" >
					操作
				</th>
			</tr>           
      	
		<%
		List<CateGory> list=(ArrayList)request.getAttribute("list"); 
		CateGory category=null;
		    for(int i=0;i<list.size();i++){
		    	category=list.get(i);
		   
		%>
			<tr>		
					<td>
						<%=category.getCid() %>
					</td>
					<td>
						<%=category.getCate() %>
					</td>
					
					<td>
					<div class="button-group"><a class="button border-main" href="<%=request.getContextPath()%>/CategoryAction?method=edit&id=<%=category.getCid()%>" class="button"><span class="icon-edit"></span>更新</a>
					<a class="button border-red" href="<%=request.getContextPath()%>/CategoryAction?method=delete&id=<%=category.getCid()%>" class="button"><span class="icon-trash-o"></span>删除</a></div>
						
					</td>
				</tr>	
				<%}%>
				  <tr>
                     <td colspan="8"><div class="pagelist"> <a href="">上一页</a> <span class="current">1</span><a href="">2</a><a href="">3</a><a href="">下一页</a><a href="">尾页</a> </div></td>
                  </tr>
		</table>
</div>

</body>
</html>