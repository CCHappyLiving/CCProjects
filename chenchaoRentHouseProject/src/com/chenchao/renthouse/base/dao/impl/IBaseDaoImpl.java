package com.chenchao.renthouse.base.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import com.chenchao.renthouse.base.dao.IBaseDao;

@Repository
public class IBaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T>
{
	@Autowired
	//为UserDaoImpl装配SessionFactory
	public void setMySessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
	
	@Override
	public T findById(Class cla,Integer id)
	{
		return null;
	}

	@Override
	public List<T> findByProperty(String className, String propertyName, Object value)
	{
		return null;
	}

	@Override
	public List<T> findAll(T t)
	{
		return null;
	}

	@Override
	public List findByHql(String hql)
	{
		return null;
	}

	@Override
	public List findAllBySql(String sql)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(T t)
	{
		// TODO Auto-generated method stub
		
	}

}
