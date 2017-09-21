<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EBOOKSTORE</title>
</head>
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/product.css">
<body>
<script type="text/javascript">
	function gouWuChe() {
		alert("你还没有登陆，请登录后重试！")
	}

	function jiaRu() {
		alert("添加成功")
	}
</script>
<div class="top_panel">
    <div class="top">
        <div class="top_logo">
        <img src="images/shuji.jpg" class="logo">
        <span class=label>EBOOKSTORE</span>
        </div>
        <div class="top_links">
				<ul>
					<li class="i_22_search search_icon">
						<div class="top_tooltip right_direction">
							<div>
								<form class="top_search_form" action="<%=request.getContextPath()%>/ProductAction?method=select" method="post">
									<input type="text" class="top_search_input" name="keyWord"/>
									<input type="image" class="top_search_submit" src="images/i_22_search.png" value="" />
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
					<a href="/BookStore/user/Person.jsp">个人信息</a>
					</li>
					<li>
					<a href="/BookStore/user/modifyPassword.jsp">修改密码</a>
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
     <a href="main"><img alt="" src="images/biaozhi.jpg"></a>
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
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=6" >艺术</a></li>
<li><a href="<%=request.getContextPath()%>/ProductAction?method=listByCate&id=3" >文教</a></li>
</ul>
</div>
</div>
</div>
</div>
<div class="col_1_of_4 span_1_of_4" style="margin-top: 40px;margin-left:200px;margin-bottom:100px;">
<div class="kong"></div>
					<div class="product-desc">
					
						<a href="#"><img width="200px" height="200px" src="<c:if test="${!empty product.imgUrl }">
													<c:url value="/Bimages/${product.imgUrl}"></c:url>
												</c:if>
												<c:if test="${empty product.imgUrl}">
												images/default.png
												</c:if>" /></a>
					</div>
					<div class="prod-inner">
					<span class="name">书名：${product.name}&nbsp;&nbsp;类型：${product.cate.cate}</span>
					<br>
					<span class="author">作者:${product.author}</span>
					<br>
					<span class="price">价格:${product.price}</span>
					<br>
					<c:if test="${!empty sessionScope.user }">
										<a href="<c:url value="ShopCartAction?method=save&pid=${product.pid}"></c:url>"
											onclick="jiaRu()" class="button">Add to cart</a>
									</c:if>
					<c:if test="${empty sessionScope.user }">
										<a href="#" onclick="gouWuChe()" class="button">Add to cart</a>
								</c:if>
						<div class="clear"></div> 
					</div>
					<h1 style="color:#fff;background: #000;">简介</h1><br>
					<hr style="gray"></hr>
					<div style="width:1000px;height:150px;"><p>${product.message}</p></div>
</div>
<div id="over">
		<img src="images/botom.PNG" width="100%" height="200px">
		<p>Believe yourself and you'll make it!!<br>
		地址：安徽省滁州市南谯区丰乐大道2188号滁州职业技术学院新校区   邮编：235000<br>
		版权所有 不容盗取<br><br>
		<a href="<%=request.getContextPath()%>/admin/adminLogin.jsp" target="_blank">进入后台</a>	
		</p>	
		</div>
</body>
</html>
