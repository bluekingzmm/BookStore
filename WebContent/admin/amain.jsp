<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理中心</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/pintuer.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/admin.css" />
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
</head>
<body style="background-color: #f2f9fd;">
	<div class="header bg-main">
		<div class="logo margin-big-left fadein-top">

			<h1>
				<img src="${pageContext.request.contextPath}/images/y.jpg"
					class="radius-circle rotate-hover" height="50" alt="" />后台管理中心
			</h1>
		</div>
		<div class="head-l">
			<a class="button button-little bg-green"
				href="<%=request.getContextPath()%>/ProductAction?operato=listAll"
				target="_blank"><span class="icon-home"></span> 前台首页</a>
			&nbsp;&nbsp; &nbsp;&nbsp; <a class="button button-little bg-red"
				href="<%=request.getContextPath()%>/ProductAction?operato=listAll"><span
				class="icon-power-off"></span> 退出登录</a>
		</div>
	</div>
	<div class="leftnav">
		<div class="leftnav-title">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul>
			<li><a
				href="<%=request.getContextPath()%>/admin/modifyPassword.jsp"
				target="right"><span class="icon-caret-right"></span>修改密码</a></li>
			<li><a
				href="<%=request.getContextPath()%>/AdminAction?method=list"
				target="right"><span class="icon-caret-right"></span>管理员管理</a></li>
			<li><a href="<%=request.getContextPath()%>/admin/save.jsp"
				target="right"><span class="icon-caret-right"></span>添加管理员</a></li>
		</ul>
		<h2>
			<span class="icon-user"></span>用户管理
		</h2>
		<ul>
			<li><a
				href="<%=request.getContextPath()%>/UserAction?operato=list"
				target="right"><span class="icon-caret-right"></span>用户信息维护</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>商品管理
		</h2>
		<ul>
			<li><a
				href="<%=request.getContextPath()%>/ProductAction?method=create"
				target="right"><span class="icon-caret-right"></span>添加书籍</a></li>
			<li><a
				href="<%=request.getContextPath()%>/ProductAction?method=list"
				target="right"><span class="icon-caret-right"></span>书籍列表</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>订单管理
		</h2>
		<ul>
			<li><a href="<%=request.getContextPath()%>/user/Order.jsp"
				target="right"><span class="icon-caret-right"></span>订单列表</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>类型管理
		</h2>
		<ul>
			<li><a href="<%=request.getContextPath()%>/book/addCate.jsp"
				target="right"><span class="icon-caret-right"></span>添加分类</a></li>
			<li><a
				href="<%=request.getContextPath()%>/CategoryAction?method=list"
				target="right"><span class="icon-caret-right"></span>分类列表</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<!-- <li><b>当前语言：</b><span style="color:red;">中文</php></span>
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a href="##">英文</a> </li> -->
	</ul>
	<div class="admin">
		<iframe scrolling="auto" rameborder="0" src="" name="right"
			width="100%" height="100%"></iframe>
	</div>
</body>
</html>