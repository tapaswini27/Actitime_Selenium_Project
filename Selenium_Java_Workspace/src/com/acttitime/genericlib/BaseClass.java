package com.acttitime.genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.objectRepositoryLib.Home;
import com.actitime.objectRepositoryLib.Login;

public class BaseClass {
	public static WebDriver driver;
	public static String url;
	/* create an object to generic libraries class */
	public WebDriverCommonLib wLib = new WebDriverCommonLib();
	public FileLib fLib = new FileLib();

	@BeforeSuite(groups = "SmokeTest")
	public void configBeforeSuite() {
		System.out.println("connect to database");
	}

	/*
	 * @Parameters("browser")
	 * 
	 * @BeforeTest(groups="SmokeTest") public void configBT(String browserValue) {
	 * if(browserValue.equals("firefox")) driver = new FirefoxDriver(); else
	 * if(browserValue.equals("chrome")) driver = new ChromeDriver(); }
	 */

	@BeforeClass(groups = "SmokeTest")
	public void configBC() throws Throwable {
		String BROWSER = fLib.getPropertyKeyValue("browser");
		url = fLib.getPropertyKeyValue("url");
		if (BROWSER.equals("firefox"))
			driver = new FirefoxDriver();
		else if (BROWSER.equals("chrome"))
			driver = new ChromeDriver();

		wLib.waitForPageToLoad(driver);
		System.out.println("===========LAUNCH THE BFROWSER=============");

		/* redirect to particular site */
		driver.get(url);
		driver.manage().window().maximize();
	}

	@BeforeMethod(groups = {"SmokeTest"})
	public void configBM() throws Throwable {
		System.out.println("Login");
		wLib.waitForPageToLoad(driver);
		Login login = PageFactory.initElements(driver, Login.class);
		login.loginToApp();

	}

	@AfterMethod(groups = "SmokeTest")
	public void configAM() {
		System.out.println("Logout");
		Home home = PageFactory.initElements(driver, Home.class);
		home.logout();

	}

	@AfterClass(groups = "SmokeTest")
	public void configAC() {
		System.out.println("===========ClOSE THE BROWSER=============");
		driver.close();

	}

}
