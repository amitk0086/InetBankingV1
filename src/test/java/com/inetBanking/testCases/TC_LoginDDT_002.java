package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObject.LoginPage;
import com.inetBanking.utilities.XLUtils;



public class TC_LoginDDT_002 extends BaseClass
{

	@Test(dataProvider="LoginData")
	public void LoginDDT(String user, String pwd) throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(user);
		logger.info("User name is provided");
		lp.setPassword(pwd);
		logger.info("Password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			
		}
		
		
		
		
		
		
	}
	
	public boolean isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+ "/src/test/java/com/inetBanking/testData/LoginData1.xlsx";
		
		int rownum= XLUtils.getRowCount(path, "sheet1");
		int colcount= XLUtils.getCellCount(path, "sheet1", 1);
		
		String loginData[][]= new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0; j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return loginData;
	}
	
	
}
