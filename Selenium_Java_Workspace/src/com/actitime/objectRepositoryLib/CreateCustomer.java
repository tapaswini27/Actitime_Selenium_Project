package com.actitime.objectRepositoryLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * @author Tapaswini
 *
 */
public class CreateCustomer {
	@FindBy(name = "name")
	private WebElement customerNameEdit;
	@FindBy(name = "description")
	private WebElement customerDescEdit;
	@FindBy(name = "createCustomerSubmit")
	private WebElement createCustomerBtn;

	public void createCustomer(String customerName) {
		customerNameEdit.sendKeys(customerName);
		createCustomerBtn.click();
	}

	public void createCustomer(String customerName, String customerDesc) {
		customerNameEdit.sendKeys(customerName);
		customerDescEdit.sendKeys(customerDesc);
		createCustomerBtn.click();
	}

}
