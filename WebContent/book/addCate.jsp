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
  <div class="panel-head"><strong><span class="icon-key"></span> 添加类型</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=request.getContextPath()%>/CategoryAction?method=save" >
        
      <div class="form-group">
        <div class="label">
          <label for="sitename">书籍类型：</label>
        </div>
        <div class="field">
        <input  class="input w50" type="text" name="category"  size="50"  placeholder="请输入类型" data-validate="required:请输入类型" />    
          
        </div>
      </div>      
     <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <input class="button bg-main icon-check-square-o" type="submit" value="提交">
            
        </div>
      </div>
      </form>
      </div>
      </div>
      <span style="float:left;margin-left:50px;black;font-size:15px;"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span>
</body>
</html>