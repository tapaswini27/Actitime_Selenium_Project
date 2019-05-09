package com.actitime.customertest;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.objectRepositoryLib.CreateCustomer;
import com.actitime.objectRepositoryLib.Home;
import com.actitime.objectRepositoryLib.OpenTask;
import com.actitime.objectRepositoryLib.ProjectAndCustomer;
import com.acttitime.genericlib.BaseClass;

@Listeners(com.acttitime.genericlib.ListenerImpClass.class)
public class CustomerTest extends BaseClass {
	@Test
	public void createCustomerTest() throws Throwable {
		/* read the data from excel sheet */
		String customerName = fLib.getExcelData("sheet1", 1, 2);
		/* step 3: navigate to Task page */
		Home home = PageFactory.initElements(driver, Home.class);
		home.clickOnTaskImage();
		/* step 4: navigate to Project And Customer Page */
		OpenTask opTask = PageFactory.initElements(driver, OpenTask.class);
		opTask.clickOnProjectAndCustomerLink();
		/* step 5: navigate to create customer Page */
		ProjectAndCustomer pac = PageFactory.initElements(driver, ProjectAndCustomer.class);
		pac.clickOnCreateCustomerBtn();
		/* step 6: create customer */
		CreateCustomer cp = PageFactory.initElements(driver, CreateCustomer.class);
		cp.createCustomer(customerName);
		/* step 7: verify */
		String actSuccessMsg = pac.getSuccessMsg().getText();
		boolean status = actSuccessMsg.contains("successfully created");
		Assert.assertTrue(status);
	}

}
