package com.chenchao.renthouse.base.controller;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * <p>Description: 控制层基类</p>
 * @author  <a href="mailto: xxx@gaotai.cn">chenchao</a>
 * @version 1.0
 */
@Controller
public class BaseController extends ActionSupport implements SessionAware,RequestAware
{
	protected Map<String ,Object> request;
	
	protected Map<String ,Object> session;	
	
	@Override
	public void setRequest(Map<String, Object> request)
	{
		this.request = request;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

}
