<%@page import="com.book.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

       
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        
        <link rel="stylesheet" href="assets/css/login2.css">

        

    </head>
<% User user=(User)session.getAttribute("userInfo"); %>
    <body>

        <div class="page-container">
            <div class="login" style="margin-top:50px;">
   
     
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
				<form action="<%=request.getContextPath()%>/UserAction?operato=login" name="loginform" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
              
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">
                    
                    <input type="text" id="u" name="username" class="inputstyle"/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" id="p" name="password" class="inputstyle"/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
              </form>
              <a href="<%=request.getContextPath()%>/user/active.jsp"><span style="float:left;margin-left:80px;font-size:15px;"><%=request.getAttribute("msg") == null ? "" : request.getAttribute("msg").toString()%></span></a>
              <span style="float:left;margin-left:80px;color:#000000;font-size:15px;"><%=request.getAttribute("mseg") == null ? "" : request.getAttribute("mseg").toString()%></span>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>
</div>
  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login"><form name="form2" id="regUser" accept-charset="utf-8"  action="<%=request.getContextPath()%>/UserAction?operato=save" method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">注册请注意格式</div>
                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="user" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="passwd" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" />
                    </div>
                    
                </li>
                <li>
                	
                    <label for="user"  class="input-tips2">性别：</label>
                    <div class="inputOuter2" id="sex">
                       <input type="radio" class="se" name="sex" value="男" required oninvalid="setCustomValidity('性别不能为空！');">
						男
						<input type="radio" class="se" name="sex" value="女" required oninvalid="setCustomValidity('性别不能为空！');">
						女
                    </div>
                    
                </li>
                <li>
                
                 <label for="qq" class="input-tips2">电话：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="tel" name="telephone" maxlength="11" class="inputstyle2"/>
                    </div>
                   
                </li>
                <li>
                
                 <label for="qq" class="input-tips2">E-Mail：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="email" name="email"  class="inputstyle2"/>
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                    </div>
                    
                </li>
                
                <div class="cl"></div>
            </ul></form>
           
    
    
   </div>
  
   
    
    </div>
    <!--注册end-->
</div>
        <script src="assets/js/jquery-1.8.2.min.js" ></script>
        <script src="assets/js/supersized.3.2.7.min.js" ></script>
        <script src="assets/js/supersized-init.js" ></script>
        <script src="assets/js/scripts.js" ></script>
        <script src=assets/js/login.js></script>
        <script src=assets/js/jquery-1.9.0.min.js></script>
    </body>
</html>