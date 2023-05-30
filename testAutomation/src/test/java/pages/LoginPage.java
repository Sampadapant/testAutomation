package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.testBase;

public class LoginPage extends testBase {
	
	public LoginPage (WebDriver driver) { //constructor; not returning anything and method name is same as class name
		testBase.driver = driver;
	}
	
	//locators
	
	public By userName = By.cssSelector("#user-name");
	By password = By.cssSelector("#password");
	By loginButton = By.cssSelector("#login-button");
	By logo = By.cssSelector(".login_logo");
	By errorMsg = By .className("h3");
	
	//Methods
	
	//login
	public void ValidLogin() {
		driver.findElement(userName).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(loginButton).click();
	}
	
	//invalidLogin
	public Boolean InvalidLogin() {
		driver.findElement(userName).sendKeys("standard");
		driver.findElement(password).sendKeys("secret");
		driver.findElement(loginButton).click();
		return driver.findElement(errorMsg).isDisplayed();
	}
	
	//valid title
	public String validTitle() {
		return driver.getTitle();
	}
	
	//Logo present
	
	public Boolean logoPresent() {
		return driver.findElement(logo).isDisplayed();
	}

}
  