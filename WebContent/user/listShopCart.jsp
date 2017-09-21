<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/pintuer.js"></script>
    
<body>

<div class="top_panel">
    <div class="top">
        <div class="top_logo">
        <img src="${pageContext.request.contextPath}/images/shuji.jpg" class="logo">
        <span class=label>EBOOKSTORE</span>
        </div>
        <div class="top_links">
				<ul>
					<li class="i_22_search search_icon">
						<div class="top_tooltip right_direction">
							<div>
								<form class="top_search_form" action="<%=request.getContextPath()%>/ProductAction?method=select" method="post">
									<input type="text" class="top_search_input" />
									<input type="image" class="top_search_submit" src="${pageContext.request.contextPath}/images/i_22_search.png" value="" />
								</form>
							</div>
						</div>
					</li>
					<c:if test="${!empty sessionScope.user }">
					<li>
					<a href="/BookStore/UserAction?operato=quit" >退出</a>
					</li>
					<li>
					<a href="<%=request.getContextPath()%>/ShopCartAction?method=list" >购物车</a>
					</li>
					<li>
					<a href=#>个人中心</a>
					<ul>
					<li>
					<a href="/ProductStore/user/Person.jsp">个人信息</a>
					</li>
					<li>
					<a href="/ProductStore/user/modifyPassword.jsp">修改密码</a>
					</li>
					<li>
					<a href=#>我的订单</a>
					</li>
					</ul>
					</li>
					<li>
					欢迎您：${sessionScope.user.name}
					</li>
					</c:if>
					<c:if test="${empty sessionScope.user}" >
					<li>
					<a href="login.jsp">登录[注册]</a>
					</li>
					</c:if>
				</ul>
    </div>
    
</div>
<div class="header_a">
     <div class="header_logo">
     <a href="main"><img alt="" src="${pageContext.request.contextPath}/images/biaozhi.jpg"></a>
     </div>
<form action="<%=request.getContextPath()%>/ProductAction?method=select" method="post">    
 <div id="search_main">
  <div id="search">
    <input name="keyWord" id="txt_Search_Keywords"  type="text">
  </div>
  <input id="btn_search" name="Submit" value="搜 索"  class="search_btn" type="submit">
</div>
</form>
<div class="nav">
<div class="nav_a">
     <ul id="ass">
<li><a href="<%=request.getContextPath()%>/ProductAction?operato=listAll" >首页</a></li>     
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=1" >文学</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=2" >社科</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=5" >少儿</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=4" >生活</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=7" >艺术</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=3" >文教</a></li>
</ul>
</div>
</div>
</div>


    
    <table class="table table-hover text-center">
      
       <tr>
				<th align="center">
					图像
				</th>
				<th align="center">
					商品名称
				</th>
				<th align="center">
					图书类别
				</th>
				<th align="center">
					价格
				</th>
				<th align="center" >
					数量
				</th>
				<th align="center" >
					操作
				</th>
			</tr>           
      	
	<c:forEach items="${cartList}"  var="shopcart">
			<tr>		
					<td>
						<img width="60px" height="80px" src="<c:if test="${!empty shopcart.book.imgUrl }">
													<c:url value="/Bimages/${shopcart.book.imgUrl}"></c:url>
												</c:if>
												<c:if test="${empty shopcart.book.imgUrl }">
												images/default.png
												</c:if>" />
					</td>
					<td>
						${ shopcart.book.name}
					</td>
					<td>
						${shopcart.book.cate.cate }
					</td>
					    
					<td>
						${shopcart.book.price*shopcart.num}		
					</td>
					<td>
						<form action="<%=request.getContextPath()%>/ShopCartAction?method=update" method="post">
						<input type="hidden" value="${shopcart.cartid}" name="id">
						<input type="text" value="${shopcart.num}" name="quantity">
									<button type="submit" class="button border-red ">更改</button>
						</form>		
					</td>
					<td>

					<a class="button border-red" href="<%=request.getContextPath()%>/ShopCartAction?method=delete&id=${shopcart.cartid}" class="button"><button type="button" class="button border-red ">删除</button></a></div>
						
					</td>
				</tr>	
	</c:forEach>
				   <tr>
				   <td>总价：￥<%=request.getAttribute("totalPrice") %></td>
                     <td colspan="8"><div class="pagelist"><a href="<%=request.getContextPath()%>/ShopCartAction?method=deleteAll" ><button type="button" class="button border-red ">清空购物车</button></a><a href="<%=request.getContextPath()%>/ProductAction?operato=listAll" ><button type="button" class="button border-red ">继续购物</button></a><a href="#" ><button type="button" class="button border-red ">结算</button></a></div></td>
                  </tr>
		</table>
		
</div>


</body>
</html>