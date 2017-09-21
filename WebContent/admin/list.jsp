<%@page import="java.util.ArrayList"%>
<%@page import="com.book.dto.Admin"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
      </ul>
    </div>
    <table class="table table-hover text-center">
      
       <tr>
				<th align="center">
					管理员编号
				</th>
				<th align="center">
					姓名
				</th>
				<th align="center">
					性别
				</th>
			
				<th align="center">
					密码
				</th>
				<th align="center" >
					操作
				</th>
			</tr>           
      	
		<%
		List<Admin> list=(ArrayList)request.getAttribute("list"); 
		Admin admin=null;
		    for(int i=0;i<list.size();i++){
		    	admin=list.get(i);
		   
		%>
			<tr>		
					<td>
						<%=admin.getAdminId()%>
					</td>
					<td>
						<%=admin.getAdminName()%>
					</td>
					<td>
						<%=admin.getSex()%>
					</td>
					
					<td>
						<%=admin.getPsw()%>		
					</td>
					<td>
					<div class="button-group"><a class="button border-main" href="<%=request.getContextPath()%>/AdminAction?method=edit&id=<%=admin.getAdminId()%>" class="button"><span class="icon-edit"></span>更新</a>
					<a class="button border-red" href="<%=request.getContextPath()%>/AdminAction?method=delete&id=<%=admin.getAdminId()%>" class="button"><span class="icon-trash-o"></span>删除</a></div>
						
					</td>
				</tr>	
				<%}%>
				  <tr>
                     <td colspan="8"><div class="pagelist"><a href="#" onclick="changePage('frist')">首页</a><a href="" onclick="changePage('previous')">上一页</a> <a href="" onclick="changePage('next')">下一页</a><a href="" onclick="changePage('end')">尾页</a> </div></td>
                  </tr>
		</table>
</div>

</body>
</html>