
//实现用户点击登陆的ajax实现方式
function doLogin()
{
	//获取表单中的用户名和密码
 	var userName = $('#login_name').attr('value');
 	var password = $('#login_password').attr('value');
 	
 	//构建ajax发送的url
 	var login_url = "login.action?user.username="+userName+"&user.password="+password;
// 	alert(login_url);  测试url
 	
 	//第一部:进行用户名或者密码是否为空的判断
 	if(null != userName && "" != userName && null != password && "" != password)
 	{
	 	//ajax实现用户登陆的功能
	 	$.ajax({
	 			
	 		url:login_url,
	 		type : "post",
	 		dataType:"json",
	 		success: function (result) {     //回调函数，服务器返回result;
				
	 			//测试	
		 		alert(result);
//		 		alert(result.houseUser);
		 		//测试服务器返回的数据是否为空	
		 		if(result.houseUser != null)	
			 	{
//					alert("success!!");
//					alert(result.houseUser.username);
			 		
			 		$('#login_form').hide(); //隐藏表单
			 		//构造html
			 		/*var html = "欢迎您："+nbsp;&nbsp;+
			 		result.houseUser.username+
			 		"<input type=\"button\" value=\"退出\" name=\"search\" "+
			 		+"onclick=\"document.location=\"logout.action\" />";*/
			 		
			 		var html = "欢迎  &nbsp; "
							+ result.houseUser.username
							+ "&nbsp;&nbsp;&nbsp;<input type='button' name='search' value='退   出'"
							+ "onclick='document.location=\"logout.action\"'/>";
			 		
			 		window.alert(html); 	//测试
			 		
			 		$("#msg").html(html);
		 		}
		 		else
		 		{
		 			//测试
					alert("失败!!无user");
					
					$("#login_info").html(result.msg);
					$("#login_info").css("color", "red");
		 		
		 		}
        	}	
 		});
 	}else
 	{
 		alert("请您输入用户名或密码!");
 	}
 		
}