package com.acttitime.genericlib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Tapaswini
 * This class contains WebDriver related methods
 *
 */
public class WebDriverCommonLib {
	/**
	 * This method is used for implicit wait
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	/**
	 * This method is used for explicit wait
	 * @param driver
	 * @param element
	 */
	public void waitForElementToPresent(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used for selecting dropDown
	 * @param element
	 * @param option
	 */
	public void select(WebElement element,String option) {
		Select sel = new Select(element);
		sel.selectByVisibleText(option);
	}
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void waitAndClick(WebElement element) {
		try {
			element.click();
		}catch(Throwable e) {
			System.out.println("wait.....");
		}
	}

}
