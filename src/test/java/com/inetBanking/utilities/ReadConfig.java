package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./configurations\\config.properties");
		 
		try
		{
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
			
		}catch (Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
		
	}
	
	public String GetApplicationUrl()
	{
		String url =pro.getProperty("baseURL");
		return url;
	}
	
	public String GetUserName()
	{
		String Username =pro.getProperty("username");
		return Username;
	}
	
	public String GetPassword()
	{
		String Password =pro.getProperty("password");
		return Password;
	}
	
	public String GetChromePath()
	{
		String chromepath =pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String GetIEPath()
	{
		String IEPath =pro.getProperty("iepath");
		return IEPath;
	}
	
	public String GetFireFoxPath()
	{
		String FireFoxpath =pro.getProperty("firefoxpath");
		return FireFoxpath;
	}

}
