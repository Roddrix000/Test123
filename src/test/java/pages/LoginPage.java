package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "Email") 
	WebElement emailTextfield;
	@FindBy(id = "Password") 
	WebElement passwordTextfield;
	@FindBy(xpath = "//input[@value='Log in']") 
	WebElement loginButton;
	@FindBy(xpath = "//input[@value='Register']") 
	WebElement registerButton;
	
	public void enterValueIntoEmailTextfield(String email) {
		emailTextfield.sendKeys(email);
	}
	
	public void enterValueIntoPasswordTextfield(String password) {
		passwordTextfield.sendKeys(password);
	}
	
	public void clickOnLoginButton() {
		loginButton.click();
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
}
