package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.*;
import utilityPackage.*;

public class RegisterWithValidCredentials extends BaseClass {

	@Test
	public void registerWithValidCredentials() throws Exception {

		SoftAssert asrt = new SoftAssert();
		
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("homePageTitle"), "Home page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnRegisterLink();
		
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("registerPageTitle"), "Register page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnMaleRadioButton();
		registerPage.enterFirstNameIntoTextfield("Prasanna");
		registerPage.enterLastNameIntoTextfield("Bhat");
		registerPage.enterEmailIntoTextfield("prasannabhat@uspmail.com");
		registerPage.enterPasswordIntoTextfield("asdfghjkl;");
		registerPage.enterConfirmPasswordIntoTextfield("asdfghjkl;");
		registerPage.clickOnRegisterButton();
		asrt.assertTrue(registerPage.verifyIfSuccessfulMessageIsDisplayed());
		
		asrt.assertAll();
	}
}
