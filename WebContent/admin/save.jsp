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
  <div class="panel-head"><strong><span class="icon-key"></span> 管理员添加</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/AdminAction?method=save" >
        
      <div class="form-group">
        <div class="label">
          <label for="sitename">姓名：</label>
        </div>
        <div class="field">
        <input  class="input w50" type="text" name="name"  size="50"  placeholder="请输入姓名" data-validate="required:请输入姓名" />    
          
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">密码：</label>
        </div>
        <div class="field">
          <input  type="text" class="input w50" size="50"  name="password"  placeholder="请输入密码" data-validate="required:请输入密码" />       
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">性别：</label>
        </div>
        <div class="field">
          <input type="radio" name="sex" checked="checked" value="男">
						男
		<input type="radio" name="sex" value="女">
						女
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