
<%@page import="com.book.dto.User"%>
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
<% User user=(User)request.getAttribute("user"); %>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span>修改信息</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/UserAction?operato=modify" >
        <input type="hidden" name="Num" value="<%=user.getUid()%>" />
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
        <input  class="input w50" type="text" name="name"  size="50"   value="<%=user.getName()%>" readonly="readonly" />    
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="password" value="<%=user.getPsw()%>" />       
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
          <input type="radio" name="sex" checked="checked" value="<%=user.getSex()%>"  >
						男
		<input type="radio" name="sex" value="<%=user.getSex()%>" >
						女
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">E-mail：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="email" value="<%=user.getEmail()%>"/>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">联系电话：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="phone" value="<%=user.getPhone()%>"/>       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">注册时间：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="savetime" value="<%=user.getSaveTime()%>" readonly="readonly" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <input class="button bg-main icon-check-square-o" type="submit" value="提交">
          <input class="button bg-main icon-check-square-o" type="reset" value="重置">   
        </div>
      </div>
      </form>
      </div>
      </div>
</body>
</html>