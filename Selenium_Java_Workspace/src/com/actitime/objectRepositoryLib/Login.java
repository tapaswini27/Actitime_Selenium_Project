package com.actitime.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.acttitime.genericlib.FileLib;

public class Login { /* Rule 1: create separate java class for every page */

	@FindBy(id = "username") /* Rule 2: find elements by using @FindBy annotation */
	private WebElement usernameEdit;
	@FindBy(name = "pwd")
	private WebElement passwordEdit;
	@FindBy(id = "loginButton")
	private WebElement loginBtn;

	/*
	 * Rule 3: Identify reusable business libraries, which can be used in login
	 * class
	 */
	public void loginToApp() throws Throwable {
		FileLib flib = new FileLib();
		usernameEdit.sendKeys(flib.getPropertyKeyValue("username"));
		passwordEdit.sendKeys(flib.getPropertyKeyValue("password"));
		loginBtn.click();
	}

	public void loginToApp(String userName, String password) throws Throwable {
		usernameEdit.sendKeys(userName);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}

	/* Rule 4: provide getters methods to give read access to specific webElement */
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
