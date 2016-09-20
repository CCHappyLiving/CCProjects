package com.chenchao.renthouse.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;

import com.chenchao.renthouse.base.controller.BaseController;
import com.chenchao.renthouse.entity.District;
import com.chenchao.renthouse.entity.House;
import com.chenchao.renthouse.entity.HouseType;
import com.chenchao.renthouse.entity.HouseUser;
import com.chenchao.renthouse.entity.Street;
import com.chenchao.renthouse.service.IUserService;
import com.chenchao.renthouse.service.impl.HouseService;
import com.chenchao.renthouse.util.Constant;
import com.chenchao.renthouse.util.UpLoadFile;

/**
 * <p>
 * Description: 租房管理控制层类
 * </p>
 * 
 * @author <a href="mailto: xxx@gaotai.cn">chenchao</a>
 * @version $Revision$
 */
@Controller
public class HouseAction extends BaseController
{
	private House house;
	
	private File img;
	
	private String fileName;
	
	private UpLoadFile upLoadFile;
	
	@Resource private HouseService houseService;
	
	//储存发布的房屋管理信息
	public String addHouse()
	{
		HouseUser user = (HouseUser)session.get(Constant.LOGIN_USER);
		if(null != user)
		{
			house.setHouseUser(user);
		}
		if(null != img)
		{
			upLoadFile.setImgFile(img);
			upLoadFile.setFileName(user.getUsername(),fileName);
		}
		
		//调用service的存储方法
		if(houseService.save(house, upLoadFile))
		{
			//return true
			return SUCCESS;
		}
		else
		{
			return INPUT;
		}
	}
	
	public House getHouse()
	{
		return house;
	}


	public void setHouse(House house)
	{
		this.house = house;
	}
	
	public File getImg()
	{
		return img;
	}

	public void setImg(File img)
	{
		this.img = img;
	}

	public UpLoadFile getUpLoadFile()
	{
		return upLoadFile;
	}

	public void setUpLoadFile(UpLoadFile upLoadFile)
	{
		this.upLoadFile = upLoadFile;
	}
	
}
