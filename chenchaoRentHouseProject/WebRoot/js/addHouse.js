
//校验发布房屋信息的各项数据信息
$(document).ready(function(){

	var reg = /^\d+\.?\d*$/;
	$("#error-floorage").hide();
	$("#error-price").hide();
	
	//面积输入验证	
	$("#floorage").keyup(function(){
		
		if(reg.test($("#floorage").val()))
		{
			$("#error-floorage").hide();
		}else
		{
			$("#error-floorage").show();
		}
	});
	
	//价格输入验证
	$("#price").keyup(function(){
		if(  reg.test($("#price").val()) ){
			$("#error-price").hide();
		}else{
			$("#error-price").show();
		}
	});
});
	
//提交验证
function validate()
{
	validateFileType();//验证图片格式
	//面积验证
	if($("#floorage").val()=='' || reg.test($("#floorage").val()) ){
		$("#error-floorage").hide();
	}else{
		$("#error-floorage").show();
		return false;
	}
	//价格验证
	if($("#price").val()=='' || reg.test($("#price").val()) ){
		$("#error-price").hide();
	}else{
		$("#error-price").show();
		return false;
	}
	return true;
}

//验证图片格式
function validateFileType(obj)
{
	var fileValue = obj!=null ? obj.value : document.getElementById("img").value;
	//验证图片格式
	if(fileValue !=null && fileValue.length > 0){
		var suffix = fileValue.substring(fileValue.length - 3, fileValue.length);
		if(!(suffix == "jpg" || suffix == "JPG")) {
			alert("请选择JPG格式的图片!");
			
			return false;
		}
	}
}

