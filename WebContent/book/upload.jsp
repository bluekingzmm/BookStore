<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% String path=request.getContextPath();
   String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<base href="<%=basePath%>">
<body>
	
	<form name="tab" method="post" action="<%=basePath%>/UploadAction" enctype="multipart/form-data">
		<input type="file" id="uploadfile" name="uploadfile"> 
		<input type="submit" value="上传">
	</form>
</body>
<%-- <c:if test="${!empty imgUrl }">
	<script type="text/javascript">
	window.opener.document.getElementById('imgUrl').value = '${imgUrl}';
	window.opener.document.getElementById('photo').src = '<c:url value="/Bimages/${imgUrl}"/>';
	window.close();
	</script>
</c:if> --%>
</html>