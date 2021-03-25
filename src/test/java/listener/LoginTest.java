package listener;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	
	@Test
	public void LoginByEmail()
	{
		System.out.println("Login By Email");
		Assert.assertEquals("Amit", "Amit");
	}
	
	@Test
	public void LoginByFacebook()
	{
		System.out.println("Login By Facebook");
		Assert.assertEquals("Amit", "Kumar");
	}

}
