<%@page import="com.book.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF_*">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/pintuer.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin.css">
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script> 
</head>
<body>
 <% Admin admin=(Admin)session.getAttribute("admin");%>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/AdminAction?method=changepsw" target="_parent">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
            <%=admin.getAdminName()%>
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="password" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="newpassword" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="repassword" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,newpassword#repassword:两次输入的密码不一致" />          
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