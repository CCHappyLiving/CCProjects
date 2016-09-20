<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>租房管理系统主页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link  rel="stylesheet" type="text/css" href="<%=path%>/css/Main.css" />
  	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/login.js"></script> 
	<script type="text/javascript" src="<%=path %>/js/search.js"></script> 
  </head>
  
  <body id="body">
  	
	    <div id="picture">
			<img src="<%=path%>/pic/logo.gif" alt="青鸟租房" />
	    </div>
	  		
	  	 <div id="login">
	  	 	
	  	 	<div id="msg" align="center"></div>
			<form id="login_form" action="doLogin.action" method="post">
				用户名: <input id="login_name"  type="text" name="user.username" />
				密码:  <input id="login_password" type="password" name="user.password" /> 
				<input type="button" value="登陆" onclick="doLogin();" />
				<input type="button" value="注册" onclick="document.location='<%=path %>/jsp/doRegister.jsp'">
			</form>
			
			<input type="button" id="addHouse" value="发布房屋信息" onclick="document.location='<%=path %>/jsp/addHouse.jsp'">
			
			<div id="login_info"></div>
			
			
		</div>
		
		<div id="clear"></div>
		
	<div id="houseUser_search">
		
		<div id="clear"></div>
		
		<b>房屋信息:</b><br/><br/>
		<input type="button" style="margin-left: 20px; margin-right: 10px;" value="开始搜索" onclick="doSearch();"/>
		
		房屋类型:<select id="search_type">
			   </select>
			   
		房屋位置:<select id="search_position_district">
			   </select>
			   <select id="search_position_street">
			   </select>
			   
	</div>
	
	<!--所有的住房管理信息的列表  -->
	<jsp:include page="house_list.jsp"></jsp:include>
	
	
	
  </body>
</html>
