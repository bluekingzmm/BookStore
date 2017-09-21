<%@page import="java.util.ArrayList"%>
<%@page import="com.book.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
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
<% List<User> userList=(ArrayList)request.getAttribute("list"); %>

  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 用户信息列表</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
      </ul>
    </div>
    <table class="table table-hover text-center">
        
        <tr>
            <th align="center">用户ID</th>
            <th align="center">用户名</th>
            <th align="center">密码</th>
            <th align="center">性别</th>
            <th align="center">Email</th>
            <th align="center">联系电话</th>
            <th align="center">注册时间</th>
            <th align="center">操作</th>
        </tr>        
    
    
   
  <% User user=null;
  for(int i=0;i<userList.size();i++){
	  user=userList.get(i);
 
  %>
    	<tr>
            <td><%=user.getUid() %></td>
            <td><%=user.getName() %></td>
            <td><%=user.getPsw() %></td>
            <td><%=user.getSex() %></td>
            <td><%=user.getEmail() %></td>
            <td><%=user.getPhone() %></td>
            <td><%=user.getSaveTime() %></td>
            <td><div class="button-group"><a class="button border-main" href="<%=request.getContextPath()%>/UserAction?operato=edit&id=<%=user.getUid()%>"><span class="icon-edit"></span>更新</a>
            <a class="button border-red" href="<%=request.getContextPath()%>/UserAction?operato=delete&id=<%=user.getUid()%>"><span class="icon-trash-o"></span>删除</a></div>
                
            </td>
        </tr>    
  <% } %>
    <tr>
    <td colspan="10"><div class="pagelist"><a>共有<%=request.getAttribute("count")%>条记录，当前第<%=request.getAttribute("pageNo")%>/<%=request.getAttribute("totalPage")%>页</a>
    <a href="UserAction?operato=list&pageNo=1" >首页</a>
    <c:if test="${!(pageNo==1)}">
    <a href="UserAction?operato=list&pageNo=${pageNo-1}" >上一页</a>
    </c:if> 
    <c:forEach var="p" begin="1" end="${totalPage}">
                            <a href="UserAction?operato=list&pageNo=${p}">${p}</a>
    </c:forEach>
    
    <c:if test="${!(pageNo==totalPage)}">
    <a href="UserAction?operato=list&pageNo=${pageNo+1}" >下一页</a>
    </c:if>
    <a href="UserAction?operato=list&pageNo=${totalPage}" >尾页</a> </div></td>
    </tr>

</table>
</div>

</body>
</html>