
//实现从数据库中拿元素并且显示在多选框中的方法
$(document).ready(function(){
				
	//当失去焦点时触发方法
//	$("#search_type").blur(function(){
				
		//构建ajax发送的url
	 	var login_url = "search.action";
				
	 	//ajax实现从数据库提取数据
	 	$.ajax({
	 			
	 		url:login_url,
	 		type : "post",
	 		dataType:"json",
	 		success: function (result) {     //回调函数，服务器返回result;
	 			
//	 			alert("Success!!");
//    	 		alert(result.strstrType);

	 			//房屋类型
    	 		var typeListJson = eval(result.strType);  //将str转换成json格式的数据
//  	 		alert(typeListJson);
    	 		
    	 		//要取typeListJson中的name属性的值
	 			//将数据库拿到的内容内容填充在select的<option>标签之内(要加一个不限这个选项卡)
				$('#search_type').append("<option value=\"not limited\">不限</option>");
				for(var i = 0;i < typeListJson.length; i++)
				{
					for(var item in typeListJson[i])
					{
						if(item == 'name')
						{
							var houseType = typeListJson[i][item];
//							alert(houseType);
							//将houseType的值加入option
							var html = "<option value=\""+ houseType+ "\">"+houseType+"</option>";
//测试						alert(html);	
							$('#search_type').append(html);//插入到select标签当中
						}
					}
				}
			
				//房屋位置里面的区
				var disPoiListJson = eval(result.strDisPos);  //将str转换成json格式的数据
				$('#search_position_district').append("<option value=\"not limited\">不限</option>");
				for(var i = 0;i < disPoiListJson.length; i++)
				{
					for(var item in disPoiListJson[i])
					{
						if(item == 'name')
						{
							var housePoiDis = disPoiListJson[i][item];
							var html = "<option value=\""+ i+ "\">"+housePoiDis+"</option>";
							$('#search_position_district').append(html);//插入到select标签当中
						}
					}
				}
				
			   //当区的属性值改变的时候自动触发后续街道的查询并且显示操作
			   $('#search_position_district').change(function()
			   	{
				   //第一步要先清空street的内容
				   $('#search_position_street').empty();
			   	   
			   	   //房屋位置里面的区对应的街道
				   var streetPoiListJson = eval(result.strDisStreet);  //将str转换成json格式的数据
					$('#search_position_street').append("<option value=\"not limited\">不限</option>");
					var i = $('#search_position_district').val(); //拿到区的option的value的值
					
					var disPoi = disPoiListJson[i]['id'];//拿到区的id值，准备后续判断操作
//					alert(disPoi);
					for(var j = 0;j < streetPoiListJson.length; j++)
					{
						for(var item in streetPoiListJson[j])
						{
							if(item == 'name' && disPoi == streetPoiListJson[j]['districtId'])
							{
//								alert("ok");
								var housePoiStreetDis = streetPoiListJson[j][item];
								var html = "<option value=\""+ housePoiStreetDis+ "\">"+housePoiStreetDis+"</option>";
								$('#search_position_street').append(html);//插入到select标签当中
							}
						}
					}
			   });	
			}
		});
	});
//});
