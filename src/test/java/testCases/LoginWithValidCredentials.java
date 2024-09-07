package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.*;
import utilityPackage.*;

public class LoginWithValidCredentials extends BaseClass {

	@Test
	public void loginWithValidCredentials() throws Exception {
		
		SoftAssert asrt = new SoftAssert();
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("homePageTitle"), "Login page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginLink();
		
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("loginPageTitle"), "Login page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueIntoEmailTextfield("prasannabhat@uspmail.com");
		loginPage.enterValueIntoPasswordTextfield("asdfghjkl;");
		loginPage.clickOnLoginButton();
		asrt.assertTrue(homePage.verifyIfMyAccountLinkIsDisplayed());
		
		asrt.assertAll();
	}
}
