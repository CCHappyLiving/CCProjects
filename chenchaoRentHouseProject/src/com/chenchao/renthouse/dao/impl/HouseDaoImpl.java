package com.chenchao.renthouse.dao.impl;

import com.chenchao.renthouse.base.dao.impl.IBaseDaoImpl;
import com.chenchao.renthouse.dao.IUserDao;
import com.chenchao.renthouse.entity.House;
import com.chenchao.renthouse.entity.HousePicture;

public class HouseDaoImpl extends IBaseDaoImpl implements IUserDao
{
	//复写父类方法,实现存储用户发布租房信息的功能
	@Override
	public void save(Object t)
	{
		House house = (House)t;
		int id =(Integer)this.getHibernateTemplate().save(house); //返回house主健值
		HousePicture housePicture = house.getHousePicture();
		if(housePicture != null)
		{
			housePicture.setId(id);
			this.getHibernateTemplate().save(housePicture);
		}
	}
	
}
