package com.chenchao.renthouse.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.chenchao.renthouse.dao.IHouseDao;
import com.chenchao.renthouse.entity.House;
import com.chenchao.renthouse.entity.HousePicture;
import com.chenchao.renthouse.service.IHouseService;
import com.chenchao.renthouse.util.UpLoadFile;

@Service
public class HouseService implements IHouseService
{
	@Resource private IHouseDao houseDao;
	
	@Override
	public boolean save(House house, UpLoadFile file)
	{
		if(null != file && upload(file))
		{
			HousePicture p = new HousePicture();
			p.setTitle(file.getTitle());
			p.setUrl(file.getFileName());
			house.setHousePicture(p);
		}
		
		//调用dao方法保存房屋信息
		house.setAdddate(new Date());
		houseDao.save(house);
		return true;
	}

	/*
	 * 判断上传的文件是否符合标准
	 */
	private boolean upload(UpLoadFile file)
	{
		try
		{
			String filePath = file.getPath(); 
			File tagFile = new File(filePath + file.getFileName()); 
			if(!tagFile.getParentFile().exists())
			{
				tagFile.getParentFile().mkdirs();//找补到则自动创建文件
			}
			FileUtils.copyFile(file.getImgFile(), tagFile);
			return true;
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
