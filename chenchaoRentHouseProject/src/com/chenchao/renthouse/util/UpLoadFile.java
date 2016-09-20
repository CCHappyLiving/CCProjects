package com.chenchao.renthouse.util;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;



/**
 * <p>
 * Description: 用于表明上传文件的实体类
 * </p>
 * 
 * @author <a href="">chenchao</a>
 * @version 1.0
 */
public class UpLoadFile
{
	private File imgFile; //上传的图片文件

	private String title; //图片的标题

	private String fileName;//上传的文件名

//	private String contentType;//上传的文件类型

	private String path; //上传的文件路径

	public File getImgFile()
	{
		return imgFile;
	}

	public void setImgFile(File imgFile)
	{
		this.imgFile = imgFile;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	//实现对文件名进行重命名的重载方法
	public void setFileName(String profix, String fileName)
	{
		if(null != fileName && fileName.indexOf('.') > 0)
		{
			fileName = (profix != null ? "/" + profix + "/" : "") + UUID.randomUUID().toString()
					+ fileName.substring(fileName.indexOf("."), fileName.length());
		}
	}

//	public String getContentType()
//	{
//		return contentType;
//	}
//
//	public void setContentType(String contentType)
//	{
//		this.contentType = contentType;
//	}

	public String getPath()
	{
		return ServletActionContext.getServletContext().getRealPath(Constant.UPLOAD_PATH);
	}

	public void setPath(String path)
	{
		this.path = path;
	}

	//测试文件名的命名方法是否正确
	public static void main(String[] args)
	{
		UpLoadFile up = new UpLoadFile();
//		up.setFileName(null, "ABC.doc");
		up.setFileName("chenchao", "ABC.doc");
		System.out.println(up.getFileName());
	}
}
