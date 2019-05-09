package com.actitime.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home {
	@FindBy(xpath = "//div[text()='Tasks']")
	private WebElement taskImg;
	@FindBy(xpath = "//div[text()='Reports']")
	private WebElement reportsImg;
	@FindBy(xpath = "//div[text()='Users']")
	private WebElement usersImg;
	@FindBy(linkText = "Logout")
	private WebElement logoutLnk;

	public void clickOnTaskImage() {
		taskImg.click();
	}

	public void clickOnUsersImage() {
		usersImg.click();
	}

	public void clickOnReportsImage() {
		reportsImg.click();
	}

	public void logout() {
		logoutLnk.click();
	}

}
