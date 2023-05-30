 package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testBase {
	public static WebDriver driver;
	public static Properties pro = new Properties(); //this is for config
	//public static Properties loc = new Properties(); // this is for locator
	
	@BeforeTest 
	public void Setup() throws IOException {
		if(driver == null) {
			FileInputStream input = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configFiles/config.properties");
			pro.load(input);
			System.out.println(pro.getProperty("browser"));
		}
		if(pro.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(pro.getProperty("baseUrl"));
		}
		else if (pro.getProperty("browser").equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(pro.getProperty("baseUrl"));
		}
	}
	@AfterTest
	public void TearDown() {
		driver.quit();
	}

}
