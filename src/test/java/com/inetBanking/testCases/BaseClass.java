package com.inetBanking.testCases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import net.bytebuddy.utility.RandomString;

public class BaseClass {
	
	ReadConfig readconfig= new ReadConfig();
	public String baseURL =readconfig.GetApplicationUrl();
	public String username=readconfig.GetUserName();
	public String password=readconfig.GetPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("Browser")
	@BeforeClass
	public void setUp(String br)
	{
		
	    logger =Logger.getLogger("eBanking");
	    PropertyConfigurator.configure("log4j.properties");
	    
	    if(br.equals("chrome"))
	    {
	    
	    System.setProperty("webdriver.chrome.driver", readconfig.GetChromePath());
	    driver= new ChromeDriver();
	    
	    }
	    else if(br.equals("firefox"))
	    {
	    	System.setProperty("webdriver.gecko.driver", readconfig.GetFireFoxPath());
		    driver= new FirefoxDriver();
	    }
	    else if(br.equals("ie"))
	    {
	    	System.setProperty("webdriver.ie.driver", readconfig.GetIEPath());
	    	driver= new InternetExplorerDriver();
	    	
	    }
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(baseURL);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
//	public void captureScreen(WebDriver driver, String tname)
//	{
//		TakesScreenshot ts= (TakesScreenshot)driver;
//		File source =ts.getScreenshotAs(OutputType.FILE);
//		File target= new File(System.getProperty("user.dir")+"/Screenshots/"+ tname+ ".png");
//		FileUtils.copyfile(source, target);
//	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
}
