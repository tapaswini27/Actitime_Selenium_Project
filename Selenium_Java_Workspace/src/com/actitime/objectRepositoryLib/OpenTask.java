package com.actitime.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenTask {
	@FindBy(xpath = "//a[text()='Projects & Customers']")
	private WebElement projectAndCustLnk;

	public void clickOnProjectAndCustomerLink() {
		projectAndCustLnk.click();
	}

}
