package com.chenchao.renthouse.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.chenchao.renthouse.base.controller.BaseController;
import com.chenchao.renthouse.entity.District;
import com.chenchao.renthouse.entity.HouseType;
import com.chenchao.renthouse.entity.HouseUser;
import com.chenchao.renthouse.entity.Street;
import com.chenchao.renthouse.service.IUserService;
import com.chenchao.renthouse.util.Constant;
import com.google.gson.Gson;

/**
 * 
 * <p>
 * Description: 用户注册控制层类
 * </p>
 * 
 * @author <a href="mailto: xxx@gaotai.cn">chenchao</a>
 * @version $Revision$
 */
@Controller
public class UserAction extends BaseController
{
	@Resource private IUserService userService;

	private HouseUser user; //为了和jsp里面form表单的内容对应上去

	private String msg; //设置提示语

	private String strType;//设置typeList转换成json的内容

	private String strDisPos;//设置districtList转换成json的内容
	
	private String strDisStreet;//设置streetList转换成json的内容

	public String getStrDisStreet()
	{
		return strDisStreet;
	}

	public void setStrDisStreet(String strDisStreet)
	{
		this.strDisStreet = strDisStreet;
	}

	public String getStrDisPos()
	{
		return strDisPos;
	}

	public void setStrDisPos(String strDisPos)
	{
		this.strDisPos = strDisPos;
	}

	public String getStrType()
	{
		return strType;
	}

	public void setStrType(String strType)
	{
		this.strType = strType;
	}

	public HouseUser getUser()
	{
		return user;
	}

	public void setUser(HouseUser user)
	{
		this.user = user;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	/*
	 * 实现用户登陆的校验功能
	 */
	public String doLogin()
	{
		Map<String, Object> map = userService.login(user);
		user = (HouseUser) map.get("user");
		if(null != user)
		{
			session.put(Constant.LOGIN_USER, user); //放入session当中,用于后续发布租房管理时需要发布的信息和houseUser一一对应
			msg = "true";
			return SUCCESS;
		}
		else
		{
			//获得提示语
			msg = (String) map.get("msg");
		}
		return INPUT;
	}

	/*
	 * 实现下拉框的搜索内容的查询
	 */
	@SuppressWarnings("unchecked")
	public String findAll()
	{
		List<HouseType> typeList = userService.findAll(HouseType.class);

		List<District> districtList = userService.findAll(District.class);
		
		List<Street> streetList = userService.findAll(Street.class);

		//  	if(null != typeList && !typeList.isEmpty() && null != districtList && !districtList.isEmpty())
		//		{
		//			Gson gson = new Gson();
		//			strType = gson.toJson(typeList); //将list转换成json,需要将其设置成全局变量
		//			System.out.println(strType);
		//			strDisPos =  gson.toJson(districtList);
		//			System.out.println(strDisPos);
		//			return SUCCESS;
		//		}

		if(null != typeList && !typeList.isEmpty() && null != districtList && !districtList.isEmpty() && null != streetList && !streetList.isEmpty())
		{
			strType = new Gson().toJson(typeList); //将list转换成json,需要将其设置成全局变量
			System.out.println(strType);
			strDisPos = new Gson().toJson(districtList); //将list转换成json,需要将其设置成全局变量
			System.out.println(strDisPos);
			strDisStreet = new Gson().toJson(streetList);
			System.out.println(strDisStreet);
			return SUCCESS;
		}
		return INPUT;
	}
	
	/*
	 *实现新用户注册的时候的用户名是否可以使用的方法实现  
	 */
	public String validateName()
	{
		//调用service的方法实现对注册名称是否可用的方法
		if(userService.validateName(user.getUsername()))
		{//存在,不能注册
			msg="false";
			return INPUT;
			
		}
		else
		{
			msg = "true";
			return SUCCESS;
		}
	}
	
	/*
	 * 实现注册的校验方法
	 */
	public String register()
	{
		if(userService.register(user))
		{
			//注册成功
			return SUCCESS;
		}
		//注册失败
		return INPUT;
	}
	
}
