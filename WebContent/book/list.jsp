<%@page import="com.book.dto.Product"%>
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
<body>
 <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 商品书籍列表</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
      </ul>
    </div>
    <table class="table table-hover text-center">
      
       <tr>
				<th align="center">
					商品编号
				</th>
				<th align="center">
					书名
				</th>
				<th align="center">
					图片
				</th>
				<th align="center">
					作者
				</th>
				<th align="center">
					类型
				</th>
				<th align="center">
					售价
				</th>
				<th align="center">
					进价
				</th>
				<th align="center">
					商品状态
				</th>
				<th align="center" >
					操作
				</th>
			</tr>           
      	
		<%
		List<Product> list=(ArrayList)request.getAttribute("prolist"); 
		Product product=null;
		    for(int i=0;i<list.size();i++){
		    	product=list.get(i);
		   
		%>
			<tr>		
					<td>
						<%=product.getPid()%>
					</td>
					<td>
						<%=product.getName()%>
					</td>
					<td>
						<img width="125px" height="100px" alt="<%=product.getName()%>" src="<%=request.getContextPath()%>/Bimages/<%=product.getImgUrl()%>">
					</td>
					
					<td>
						<%=product.getAuthor()%>		
					</td>
					<td>
						<%=product.getCate().getCate()%>		
					</td>
					<td>
						<%=product.getPrice()%>		
					</td>
					<td>
						<%=product.getRelprice()%>		
					</td>
					<c:if test="<%=product.getState()==0%>">
					<td>
						未上架	
					</td>
					</c:if>
					<c:if test="<%=product.getState()==1%>">
					<td>
						已上架	
					</td>
					</c:if>
					<td>
					<div class="button-group">
					<a class="button border-main" href="<%=request.getContextPath()%>/ProductAction?method=changeState&id=<%=product.getPid()%>&state=<%=product.getState()%>" class="button">
					<c:if test="<%=product.getState()==0%>"><span class="icon-edit"></span>上架</c:if> 
					<c:if test="<%=product.getState()==1%>"><span class="icon-edit"></span>下架</c:if></a>
					<a class="button border-main" href="<%=request.getContextPath()%>/ProductAction?method=edit&id=<%=product.getPid()%>" class="button"><span class="icon-edit"></span>更新</a>
					<a class="button border-red" href="<%=request.getContextPath()%>/ProductAction?method=delete&id=<%=product.getPid()%>" class="button"><span class="icon-trash-o"></span>删除</a></div>
						
					</td>
				</tr>	
				<%}%>
				  <tr>
                     <td colspan="10"><div class="pagelist"><a>共有<%=request.getAttribute("count")%>条记录，当前第<%=request.getAttribute("pageNo")%>/<%=request.getAttribute("totalPage")%>页</a>
                     <a href="ProductAction?method=list&pageNo=1" >首页</a>
                    <c:if test="${!(pageNo==1)}"> 
                     <a href="ProductAction?method=list&pageNo=${pageNo-1}" >上一页</a>
                    </c:if>
                    <c:forEach var="p" begin="1" end="${totalPage}">
                            <a href="ProductAction?method=list&pageNo=${p}">${p}</a>
                    </c:forEach>
                     <c:if test="${!(pageNo==totalPage)}">
                     <a href="ProductAction?method=list&pageNo=${pageNo+1}" >下一页</a>
                     </c:if>
                     <a href="ProductAction?method=list&pageNo=${totalPage}" >尾页</a> </div></td>
                  </tr>
		</table>
</div>
</body>
</html>