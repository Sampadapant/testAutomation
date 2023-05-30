package utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.testBase;

public class commonUtils extends testBase {
	
	public commonUtils (WebDriver driver) {
		testBase.driver = driver;
	}
	
	//getPageTitle()
	public String getPageTitle() {
		try {
			System.out.println("The title of page is "+ driver.getTitle());
			return driver.getTitle();
		}
		catch(Exception e){
			throw new Error("title not found");
		}
	}
	
	// getElemnent
	
	public WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		}
		catch(Exception NoSuchElementException) {
			throw new Error ("element not found");
		}
		//return null;
	}
	
	//sendKeys()
	public void SendKeys (String text, By selector) {
		try {
			clearText(selector);
			getElement(selector).sendKeys(text); 
		}
		catch(Exception NoSuchElementException) {
			throw new Error ("text not found");
		}
	}
	
	// clear text
	
	public void  clearText (By selector) {
		try {
			getElement (selector).clear();
		}
		catch(Exception NoSuchElementException) {
			throw new Error ("element not found");
		}
	}
	
	// switch to Alert()
	public Alert switchToAlert(WebDriver driver) {
		try {
			return driver.switchTo().alert();

		}
		catch(Exception NoAlertPresentException) {
			throw new Error("no alert present"+ NoAlertPresentException.getMessage());
		}
	}
	
	// switch to iFrame()
	public WebElement switchToIFrame(WebDriver driver, int a) {
		try {
		return (WebElement) driver.switchTo().frame(a);	
		}
		catch (Exception NoIFramePresenttExcepetion) {
			throw new Error("no iframe found"+ NoIFramePresenttExcepetion.getMessage());
		}
	}
	
	// wait for element to be visible
	public void waitForElementVisible(By selector, Duration timeout) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeout);
		     wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		}
		catch(Exception NoSuchElementException) {
			System.out.println("Element not found within the specified timeout!" + timeout +"seconds");
		}
	}
	// wait for element to be clickable
       public void waitForElementClickable(By selector, Duration timeout) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver,timeout);
		     wait.until(ExpectedConditions.elementToBeClickable(selector));
		}
		catch(Exception NoSuchElementException) {
			System.out.println("Element not found within the specified timeout!" + timeout +"seconds");
		}
	}
	
	
	// maximize ()
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	// findElements
	public List<WebElement> findElements(By selector) {
        return driver.findElements(selector);
    }
	// isDisplayed()
	public boolean isDisplayed(By selector) {
        WebElement element = driver.findElement(selector);
        return element.isDisplayed();
    }
	// isSelected()
	public boolean isSelected(By selector) {
		try {
        return ((WebElement) selector).isSelected();
		}
       catch(Exception notSelectedException) {
    	   throw new Error("element not selected"+ notSelectedException.getMessage());
       }
    }
	
	
	// is Enabled()
	public boolean isEnabled(By selector) {
        WebElement element2 = driver.findElement(selector);
        return element2.isEnabled();
    }
	
	// Drop Down()
	public void selectDropdownByVisibleText(By selector, String visibleText) {
        WebElement dropdownElement = driver.findElement(selector);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
	
	public void selectDropdownByValue(By selector, String value) {
        WebElement dropdownElement1 = driver.findElement(selector);
        Select dropdown1 = new Select(dropdownElement1);
        dropdown1.selectByValue(value);
    }

	public void selectDropdownByIndex(By selector, String index) {
		WebElement dropdownElement2 = driver.findElement(selector);
        Select dropdown2 = new Select(dropdownElement2);
        dropdown2.selectByValue(index);
	}
	
	// radioButton()
	public void selectRadioButton(By selector) {
        WebElement radioButton = driver.findElement(selector);
        radioButton.click();
    }
	// windowHandles()s
	 public Set<String> getWindowHandles() {
	        return driver.getWindowHandles();
	    }
	 
	
	// click()
	 public void clickElement(By selector) {
	        WebElement element = driver.findElement(selector);
	        element.click();
	    }
	// navigate to pages()
	 public void navigateTo(String url) {
	        driver.get(url);
	    }
	//scrollIntoView
	 public static void scrollIntoView(WebDriver driver, By selector) {
		 WebElement ele = driver.findElement(selector);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 String script = "arguments[0].scrollIntoView();";
		 js.executeScript(script, ele);
		
	 }
	 
	 //screenshot
	 public static void takeScreenShot(WebDriver driver, String filepath) throws IOException {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src = ts.getScreenshotAs(OutputType.FILE);
		 File des = new File (filepath);
		 FileUtils.copyFile(src, des);
		 
	 }

	// Actions
	
	// fluent wait ()
	
	

}
