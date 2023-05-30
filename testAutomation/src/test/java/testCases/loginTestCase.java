package testCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import base.testBase;
import pages.LoginPage;
import utilities.commonUtils;

public class loginTestCase extends testBase {
	
	static LoginPage login = new LoginPage(driver);
	static commonUtils utils = new commonUtils(driver);
	@Test 
	
	public static void validateLogin() {
		login.ValidLogin();
		
	}
	@Test
	public static void validateLogo() {
		Boolean actualValue = login.logoPresent();
		Assert.assertTrue(actualValue);
		System.out.println(login.userName);
		utils.getElement(login.userName);
		
	}
	@Test
	public static void validateTitle() {
		String title = login.validTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	

}

