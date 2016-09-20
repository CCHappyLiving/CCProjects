
$(document).ready(function(){

	//为必填字段加一个"*"号
//	$("form .required").each(function(){
//		
//		alert("success!!");
//		//创建元素
//		var $required = $("<span style='color:red'>*</span>");
//		
//		//将它追加到文档之中
//		alert($(this)[0].text());
//		$(this).append($required);
//		
//	});
	
	
	//进行用户名,密码,确认密码,电话,用户真实姓名的校验
		var ok_username=false;
		var ok_username_exiseInDB = false;
		var ok_passwd=false;
        var ok_repasswd=false;
        var ok_phone=true;
        var ok_realname=true;
        
        // 验证用户名
        $('input[name="user.username"]').focus(function(){
          $(this).next().text('用户名应该为3-12位之间').removeClass('state1').addClass('state2');
        }).blur(function(){
          if($(this).val().length >= 3 && $(this).val().length <=12 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok_username=true;
          }else{
            $(this).next().text('用户名应该为3-20位之间').removeClass('state1').addClass('state3');
          }
        });
        
         //验证密码
        $('input[name="user.password"]').focus(function(){
          $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state2');
        }).blur(function(){
          if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok_passwd=true;
          }else{
            $(this).next().text('密码应该为6-20位之间').removeClass('state1').addClass('state3');
          }
        });
  
        //验证确认密码
          $('input[name="repassword"]').focus(function(){
          $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同').removeClass('state1').addClass('state2');
        }).blur(function(){
          if($(this).val().length >= 6 && $(this).val().length <=20 && $(this).val()!='' && $(this).val() == $('input[name="user.password"]').val()){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok_repasswd=true;
          }else{
            $(this).next().text('输入的确认密码要和上面的密码一致,规则也要相同').removeClass('state1').addClass('state3');
          }
        });
  
		//验证电话(选填)
		$('input[name="user.telephone"]').focus(function(){
          $(this).next().text('请输入正确的电话号码的格式');
        }).blur(function(){
          if(null != $(this).val() && "" != $(this).val())
          {
	          if($(this).val().search(/^1[34578]\d{9}$/)==-1){
	            $(this).next().text('请输入正确的电话号码的格式').removeClass('state1').addClass('state3');
	          }else{         
	            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
	            ok_phone=true;
	          }
          }
          else
          {
          	ok_phone=true;//没填则跳过校验
          }
        });
	
        //验证用户真实姓名
        $('input[name="user.realname"]').focus(function(){
          $(this).next().text('用户名应该为2-10位之间');
        }).blur(function(){
          if(null != $(this).val() && "" != $(this).val())
          {
	          if($(this).val().length >= 2 && $(this).val().length <=10 && $(this).val()!=''){
	            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
	            ok_realname=true;
	          }else{
	            $(this).next().text('用户名应该为2-10位之间').removeClass('state1').addClass('state3');
	          }
          }else
          {
          	ok_realname = true;//没填则跳过校验
          }
        });
		
        //提交按钮,所有验证通过才可提交
        $('.submit').click(function(){
          
        	//点击立即注册按钮时候的绑定函数
          var registerName = $("#username").attr('value');
		  var url = "validateName.action?user.username="+registerName;
		
//		alert("进去ajax方法!!");
		//ajax验证函数
		$.ajax({
			
			url:url,
			dataType:"json",
			success:function(data) {	
				//测试msg
				alert(data.msg);
				if(data.msg == 'true')	
				{
					//用户名数据库里不存在,可以注册
					ok_username_exiseInDB = true;
					if(ok_username && ok_passwd && ok_repasswd && ok_phone && ok_realname && ok_username_exiseInDB)
				 	{
      	  				alert("用户注册成功!!");
      	  				$("#register_form").submit();
     				}
				}else
					{
						//用户名数据库里存在,不可以注册
						alert("您所注册用户名已经存在!!");
						return false;
					}
				}
		});
    });
});

