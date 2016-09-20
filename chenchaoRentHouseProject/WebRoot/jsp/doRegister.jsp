<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新用户注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="<%=path %>/js/register.js"></script> 
	
	<style type="text/css">
	  
	  .state1{
        color:#aaa;
      }
      .state2{
        color:#000;
      }
      .state3{
        color:red;
      }
      .state4{
        color:green;
      }
      
	</style>
	
	
  </head>
  
  <body>
  		  
    	<form id="register_form" action="register.action" style="text-align: center; padding-top: 100px;"> 
    		用 户 名 :<input type="text" class="required" name="user.username" id="username"/>
    		       <span class='state1'>请输入用户名</span><br/><br/>
     		密&nbsp;&nbsp;码 :<input class="required" type="password" name="user.password" />
    						<span class='state1'>请输入密码</span><br/><br/>
    		确认密码 :<input class="required" type="password" name="repassword">
		    	    <span class='state1'>请输入确认密码</span><br/><br/>      
		          电&nbsp;&nbsp;话 :<input type="text" name="user.telephone">
		            <span class='state1'>请输入电话号码(选填)</span><br/><br/>  
		          用户姓名 :<input type="text" name="user.realname">
		           <span class='state1'>请输入用户真实姓名(选填)</span><br/><br/>
    		<input class='submit' type="button" value="立即注册">
    		<input type="button" value="回到首页" onclick="document.location='<%=path %>/jsp/register.jsp'">  
    	</form>	
    
  </body> 
</html>
