<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>全部租房信息展示页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	
		#rentHouse_information{ border: 1px solid red; height: 500px; margin-top: 10px;}
		#infor_title { padding-left: 50px;}
		#infor_position{ padding-left: 50px; }
		#information { padding-left: 20px;padding-top: 20px;}
		#infor_img { float: left; width: 150px; height: 90px}
		#infor_contact{ padding-left: 20px;}
		#infor_modify {float: right; margin-right: 50px; width: 80px; height: 25px;}
		#infor_delete {float: right; margin-right: 50px;  width: 80px; height: 25px;}
		#clear{ clear: both;}
	
	</style>
		
	
  </head>
  
  <body>
  		
  		<!-- 利用EL表达式和JSTL表达式完成相应的租房信息的循环显示 -->
  		<div id="rentHouse_information">
			
			<!--具体一条租房信息 -->			    		
    		<div id=information>
    		
    			<img id="infor_img" alt="租房信息图" src="<%=path%>/pic/thumb_house.jpg"></img>
    			<a href="" id="infor_title">超级好房出租</a><br/><br/>
    			<span id="infor_position">淮安区,200.0平米</span><br/><br/>
    			<span id="infor_contact">联系方式:13505145324</span>
    		
    			<input id="infor_modify" type="button" value="修改">
    			
    			<input id="infor_delete" type="button" value="删除">
    			
    			<div id="clear"></div>
    		
    		
    		</div>
    	
    	</div>
    	
  </body>
</html>
