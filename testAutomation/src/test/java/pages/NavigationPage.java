package pages;

import org.openqa.selenium.By;

import base.testBase;

public class NavigationPage extends testBase{
	
	public NavigationPage() {
		testBase.driver = driver;
	}
	public By userName = By.cssSelector("#user-name");
	By password = By.cssSelector("#password");
	By loginButton = By.cssSelector("#login-button");
	
	
	
	By navigation = By.id("react-burger-menu-btn");
	By boxes = By.className("bm-item menu-item");
	
	//login
		public void ValidLogin() {
			driver.findElement(userName).sendKeys("standard_user");
			driver.findElement(password).sendKeys("secret_sauce");
			driver.findElement(loginButton).click();
		}
	public void validateNavigation() {
		driver.findElement(navigation).click();
		
	}
	
	public int getSize() {
		return driver.findElements(boxes).size();
	}

}
