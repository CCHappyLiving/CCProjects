<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.8.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		//为必填字段加一个"*"号
//		$("form .required").each(function(){
		
			//将它追加到文档之中
//			alert($(this).val());
//			$(this).append("<span style='color:red'>*</span>");
		
//	});

		var ok1=false;
        
        // 验证用户名
        $('input[name="user.username"]').focus(function(){
          $(this).next().text('用户名应该为3-20位之间').removeClass('state1').addClass('state2');
        }).blur(function(){
          if($(this).val().length >= 3 && $(this).val().length <=12 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok1=true;
          }else{
            $(this).next().text('用户名应该为3-20位之间').removeClass('state1').addClass('state3');
          }
            
        });
  
        
 


});



</script>

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

		<form>
    		 用 户 名:<input type="text" name="user.username">
        			<span class='state1'>请输入用户名</span><br/><br/>
  
  
  <!--  		密        码 :<input class="required" type="password" name="user.password" value="bbb"  /><br>
    		确认密码 :<input class="required" type="password" name="repassword" value="ccc" ><br>
		    电        话 :<input type="text" name="user.telephone"><br>
		    用户姓名 :<input type="text" name="user.realname"><br>
    		<input type="submit" value="立即注册">
    	</form>
  -->





</body>
</html>
