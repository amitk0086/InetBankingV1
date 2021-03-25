package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass 
{
    
	@Test
	public void loginTest()
	{
		
		logger.info("URL is Opened");
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Entered User name");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login test pass");
		}
		
		else 
		{
			Assert.assertTrue(false);
			logger.info("Login Test Fail");
		}
		
	}
	
}
 
