package com.actitime.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectAndCustomer {
	@FindBy(xpath = "//span[text()='Create Customer']")
	private WebElement createCustomerBtn;
	@FindBy(xpath = "//span[@class='successmsg']")
	private WebElement successMsg;

	public void clickOnCreateCustomerBtn() {
		createCustomerBtn.click();
	}

	public WebElement getSuccessMsg() {
		return successMsg;
	}

}
