package com.chenchao.renthouse.service;

import java.util.List;
import java.util.Map;

import com.chenchao.renthouse.entity.District;
import com.chenchao.renthouse.entity.HouseUser;
import com.chenchao.renthouse.entity.Street;

public interface IUserService<T>
{
	//实现用户登陆的方法
	public Map<String,Object> login(HouseUser user);

	//实现查找所有房屋类型和地理位置区的方法,查找的具体街道需要根据区的id进行选择进行
	public List findAll(Object t);

	//实现根据District的id进行查找出对应的街道的方法
	public List<Street> findAllStreetsByDisId(Integer districtId);

	//根据sql查询出所有的List方法
	public List findAllBySql(String sql);

	
}
