<%@page import="com.book.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
</head>

<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong>欢迎您：${sessionScope.user.name}&nbsp;&nbsp;&nbsp;<span class="icon-key"></span>修改信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/UserAction?operato=person" >
        <input type="hidden" name="Num" value="${user.uid}" />
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
        <input  class="input w50" type="text" name="name"  size="50"   value="${user.name}" />    
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="password" value="${user.psw}" />       
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
          <input type="radio" name="sex" checked="checked" value="${user.sex}"  >
						男
		<input type="radio" name="sex" value="${user.sex}" >
						女
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">E-mail：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="email" value="${user.email}"/>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系电话：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="phone" value="${user.phone}"/>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">注册时间：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="savetime" value="${user.saveTime}" readonly="readonly" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <input class="button bg-main icon-check-square-o" type="submit" value="提交">
          <a class="button bg-main icon-check-square-o" href="<%=request.getContextPath()%>/lomain.jsp">返回</a>   
        </div>
      </div>
      </form>
      </div>
      </div>
</body>
</body>
</html>