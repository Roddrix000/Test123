package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	public RegisterPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "gender-male") 
	WebElement maleRadioButton;
	@FindBy(id = "FirstName") 
	WebElement firstNameTextfield;
	@FindBy(id = "LastName") 
	WebElement lastNameTextfield;
	@FindBy(id = "Email") 
	WebElement emailTextfield;
	@FindBy(id = "Password") 
	WebElement passwordTextfield;
	@FindBy(id = "ConfirmPassword") 
	WebElement confirmPasswordTextfield;
	@FindBy(id = "register-button") 
	WebElement registerButton;
	@FindBy(xpath = "//div[contains(text(),'Your registration completed')]") 
	WebElement registrationSuccessfulMessage;
	
	public void clickOnMaleRadioButton() {
		maleRadioButton.click();
	}
	
	public void enterFirstNameIntoTextfield(String firstName) {
		firstNameTextfield.sendKeys(firstName);
	}
	
	public void enterLastNameIntoTextfield(String lastName) {
		lastNameTextfield.sendKeys(lastName);
	}
	
	public void enterEmailIntoTextfield(String email) {
		emailTextfield.sendKeys(email);
	}
	
	public void enterPasswordIntoTextfield(String password) {
		passwordTextfield.sendKeys(password);
	}
	
	public void enterConfirmPasswordIntoTextfield(String confirmPassword) {
		confirmPasswordTextfield.sendKeys(confirmPassword);
	}
	
	public void clickOnRegisterButton() {
		registerButton.click();
	}
	
	public boolean verifyIfSuccessfulMessageIsDisplayed() {
		return registrationSuccessfulMessage.isDisplayed();
	}
}
