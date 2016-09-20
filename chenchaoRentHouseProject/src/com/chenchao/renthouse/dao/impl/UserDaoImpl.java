package com.chenchao.renthouse.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.chenchao.renthouse.base.dao.impl.IBaseDaoImpl;
import com.chenchao.renthouse.dao.IUserDao;
import com.chenchao.renthouse.entity.District;
import com.chenchao.renthouse.entity.HouseUser;
import com.chenchao.renthouse.entity.Street;

/**
 * <p>
 * Description: 和用户相关数据库交互的接口类的实现类
 * </p>
 * 
 * @author <a href="mailto: xxx@gaotai.cn">chenchao</a>
 * @version 1.0
 */
@Repository
public class UserDaoImpl extends IBaseDaoImpl implements IUserDao
{
	@Override
	//复写父类的查找方法,实现增加的功能
	public void save(Object t)
	{
		//调用hibernateTemplate的存储方法实现对对象的保存功能
		this.getHibernateTemplate().save(t);
	}

	@Override
	//复写父类的查找方法,根据hql语句进行操作,返回List
	public List findByHql(String hql)
	{
		Query q = super.getSession().createQuery(hql);
		return q.list();
	}

	//复写父类的查找方法,根据Id实现对HouseUser的查找
	@Override
	public HouseUser findById(Class cla, Integer id)
	{
		String hql = "FROM " + cla + " as u WHERE u.id=?";
		Query q = super.getSession().createQuery(hql);
		q.setString(0, "HouseUser");
		q.setString(1, String.valueOf(id));
		return (HouseUser) q.uniqueResult();
	}

	//复写父类方法,实现根据用户指定的任意属性值的查找
	@Override
	public List<HouseUser> findByProperty(String className, String propertyName, Object value)
	{
		String hql = "FROM " + className + " as o WHERE o." + propertyName + " = ?";
		Query q = super.getSession().createQuery(hql);
		q.setParameter(0, value);
		return q.list();
	}

	//复写父类方法,实现对所需class内容的查找
	@Override
	public List findAll(Object t)
	{
		if("HouseType".equalsIgnoreCase(t.toString()
				.substring(t.toString().lastIndexOf(".") + 1, t.toString().length())))
		{
			String hql = "FROM HouseType";
			Query q = super.getSession().createQuery(hql);
			return q.list();
		}
		else if("District".equalsIgnoreCase(t.toString().substring(t.toString().lastIndexOf(".") + 1,
			t.toString().length())))
		{
			String hql = "FROM District"; //一对多查询会有问题
			Query q = super.getSession().createQuery(hql);
			List<District> d_list = new ArrayList<District>();
			for (int i = 0; i < q.list().size(); i++)
			{
				District d = (District) q.list().get(i);
				//				Set set = d.getStreets();
				//				if(set == null || set.isEmpty())
				//				{
				//					System.out.println("null");
				//				}
				//				Iterator<Street> it = d.getStreets().iterator(); //查询set集合
				//				while (it.hasNext())
				//				{
				//					Street s = it.next();
				//					System.out.println(s.getName());
				//				}
				d.setStreets(null); //不把streets设置成空会出现错误
				d_list.add(d);
			}
			return d_list;
			//			return q.list();
		}
		else if("Street".equalsIgnoreCase(t.toString().substring(t.toString().lastIndexOf(".") + 1,
			t.toString().length())))
		{
			String hql = "FROM Street";
			Query q = super.getSession().createQuery(hql);
			List<Street> s_list = new ArrayList<Street>();
			for (int i = 0; i < q.list().size(); i++)
			{
				Street s = (Street) q.list().get(i);
				s.setHouses(null);
				s.setDistrict(null);
				s_list.add(s);
			}
			return q.list();
		}
		return null;
	}

	@Override
	//复写父类方法,实现根据原生态sql语句实现查询返回List的方法
	public List findAllBySql(String sql)
	{
		List list = new ArrayList();
		SQLQuery query = super.getSession().createSQLQuery(sql);
		System.out.println(query.list().size());

		return query.list();
	}
}
