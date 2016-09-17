package com.chenchao.renthouse.base;

import java.util.List;

/**
 * 
 * <p>Description: 数据库操作基类</p>
 * @author  <a href="mailto: xxx@gaotai.cn">作者中文名</a>
 * @version $Revision$
 */
public interface IBaseDao<T>
{
	//根据Id查找
	public T findById(Class cla,Integer id);
	
	//根据类的属性值进行查找
	public List<T> findByProperty(String className,String propertyName, Object value);
	
	//根据类名来进行搜索所有的数据
	public List<T> findAll(T t);
	
	//根据Hql语句查询返回List
	public List findByHql(String hql);
	
	//根据原生态sql语句查询返回List
	public List findAllBySql(String sql);
	
}
