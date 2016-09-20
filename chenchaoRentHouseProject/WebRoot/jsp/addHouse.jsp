<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="ss" uri="/struts-dojo-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新房屋信息发布界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link  rel="stylesheet" type="text/css" href="<%=path%>/css/Main.css" />
  	<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.js"></script>
  	<script type="text/javascript" src="<%=path %>/js/addHouse.js"></script>
  </head>
 
 <!-- 勿忘加这个  -->
  <ss:head parseContent="true" />
  
  <body id="body" style="text-align: center;">
  	
	<form action="doAddHouse.action" onsubmit="return validate();" enctype="multipart/form-data" >
	   	
	   	标题:<input type="text" name="house.title"/><br/>	
	   
	   	户型:<select name="house.houseType">
	   			<option value="0">three_rooms two res</option>
	   			<option value="1">one_room one res</option>
	   		</select><br/>
	   
	          面积:<input type="text" name="house.floorage" id="floorage" />
	        <span id="error-floorage"><font color="red">只能输入数字</font></span><br/>  
	          
	   	价格:<input type="text" name="house.price" id="price"/>
	   		<span id="error-price"><font color="red">只能输入数字</font></span><br/>
	   		
	   	房产证日期:
	    <ss:datetimepicker id="datePicker" name="house.pubDate" ></ss:datetimepicker><br/>
	   
	   	位置:<select>
	   			<option value="0">LianYG</option>
	   			<option value="1">HuaiA</option>
	   	   </select>
	   	   <select>
	   			<option value="0">XinP</option>
	   			<option value="1">GuanY</option>
	   			<option value="2">GuanN</option>
	   			<option value="3">ChuZ</option>
	   			<option value="4">HuaiY</option>
	   			<option value="5">QingH</option>
	   	   </select><br/>
	   
	        上传图片:
	   	   <input type="file" name="img" id="img" onchange="validateFileType(this)"><br/>	
	   
	         图片标题:
	   	   <input type="text" name="uploadFile.title"><br/>
	   	   
	         联系方式:
	       <input type="text" name="house.contact"><br/>  	   
	   	   
	   	详细信息:   
	   	   <textarea rows="10" cols="20" name="house.description"></textarea><br/>
	   	   
	   	   <input type="submit" value="立即发布" style="background: blue"/>
	
	</form> 
	   
  </body>
</html>
