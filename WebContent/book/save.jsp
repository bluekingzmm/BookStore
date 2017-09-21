<%@page import="com.book.dto.CateGory"%>
<%@page import="java.util.ArrayList"%>
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
<!-- <script type="text/javascript">
	function upload(){
		window.open('<c:url value='book/upload.jsp' />',"","width=450,height=250")
	}
</script> -->
<body>
<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加内容</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action='<c:url value='/ProductAction?method=save' />'>  
      <div class="form-group">
        <div class="label">
          <label>书名：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="bookname" data-validate="required:请输入书名" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>作者：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="author" data-validate="required:请输入作者" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>进价：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="relprice" data-validate="required:请输入价格" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>售价：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="price" data-validate="required:请输入价格" />
          <div class="tips"></div>
        </div>
      </div>
       <div class="form-group">
        <div class="label">
          <label>图片：</label>
        </div>
        <div class="field">
       <input type="text" name="imgUrl" class="input w50" id="image"   style="float:left;">
          
        </div>
      </div>     
      
      <if condition="$iscid eq 1">
        <div class="form-group">
          <div class="label">
            <label>分类标题：</label>
          </div>
          <div class="field">
            <select name="cid" class="input w50">
            <option value="">请选择分类</option>
           
            <%
		List<CateGory> list=(ArrayList)request.getAttribute("catelist"); 
		CateGory category=null;
		    for(int i=0;i<list.size();i++){
		    	category=list.get(i);
		%>  
           <option value="<%=category.getCid()%>"><%=category.getCate() %></option>
        <%}%>   
            </select>
            <div class="tips"></div>
          </div>
        </div>
        
      </if>
      <div class="form-group">
        <div class="label">
          <label>描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="message" style=" height:90px;"></textarea>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
</body>
</html>