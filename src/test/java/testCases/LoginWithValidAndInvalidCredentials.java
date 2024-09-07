package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.LoginPage;
import utilityPackage.BaseClass;
import utilityPackage.UtilityMethods;

public class LoginWithValidAndInvalidCredentials extends BaseClass {

	@DataProvider(name = "loginData")
	public Object loginData() throws Exception {
		
		return UtilityMethods.getExcelData("Login Credentials");
	}
	
	@Test(dataProvider = "loginData")
	public void loginWithValidAndInvalidCredentials(String email, String password) throws Exception {
		
		SoftAssert asrt = new SoftAssert();
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("homePageTitle"), "Home page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnLoginLink();
		
		asrt.assertEquals(driver.getTitle(), UtilityMethods.getConfig("loginPageTitle"), "Login page"+UtilityMethods.getConfig("pageTitleDoesntMatchMessage"));
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterValueIntoEmailTextfield(email);
		loginPage.enterValueIntoPasswordTextfield(password);
		loginPage.clickOnLoginButton();
		asrt.assertTrue(homePage.verifyIfMyAccountLinkIsDisplayed());
		
		asrt.assertAll();
	}
}
