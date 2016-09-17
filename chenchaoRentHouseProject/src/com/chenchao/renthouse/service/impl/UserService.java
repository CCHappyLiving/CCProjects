package com.chenchao.renthouse.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chenchao.renthouse.dao.IUserDao;
import com.chenchao.renthouse.entity.District;
import com.chenchao.renthouse.entity.HouseType;
import com.chenchao.renthouse.entity.HouseUser;
import com.chenchao.renthouse.entity.Street;
import com.chenchao.renthouse.service.IUserService;

@Service
public class UserService implements IUserService
{
	@Resource private IUserDao userDao;

	@Override
	public Map<String, Object> login(HouseUser readyToLoginUser)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		List<HouseUser> list = userDao.findByProperty("HouseUser", "username", readyToLoginUser.getUsername());
		if(null != list && !list.isEmpty())
		{
			HouseUser authUser = list.get(0);
			if(authUser.getPassword() == readyToLoginUser.getPassword())
			{
				//密码正确,成功登陆
				map.put("user", readyToLoginUser);
			}
			else
			{
				//用户名或者密码错误
				map.put("msg", "密码错误!!");
			}
		}
		else
		{
			//用户不存在
			map.put("msg", "用户不存在!!");
		}
		return map;
	}

	@Override
	public List findAll(Object t)
	{
		//进行类型的判断操作
		if("HouseType".equalsIgnoreCase(t.toString().substring(t.toString().lastIndexOf(".")+1, t.toString().length())))
		{
			return userDao.findAll(HouseType.class);
		}
		else if("District".equalsIgnoreCase(t.toString().substring(t.toString().lastIndexOf(".")+1, t.toString().length())))
		{
			return userDao.findAll(District.class);
		}
		else if("Street".equalsIgnoreCase(t.toString().substring(t.toString().lastIndexOf(".")+1, t.toString().length())))
		{
			return userDao.findAll(Street.class);
		}
		return null;
	}

	@Override
	public List<Street> findAllStreetsByDisId(Integer districtId)
	{
		return userDao.findByHql("FROM Street WHERE districtId=" + districtId);
	}

	@Override
	public List findAllBySql(String sql)
	{
		return userDao.findAllBySql(sql);
	}
}
