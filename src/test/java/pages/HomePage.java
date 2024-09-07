package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Tricentis Demo Web Shop']") 
	WebElement demoWebShopLogo;
	@FindBy(xpath = "//a[text()='Register']") 
	WebElement registerLink;
	@FindBy(xpath = "//a[@class='account']") 
	WebElement myAccountLink;
	@FindBy(xpath = "//a[text()='Log in']")	
	WebElement loginLink;
	@FindBy(xpath = "//a[text()='Log out']") 
	WebElement logoutLink;
	@FindBy(xpath = "//span[contains(text(),'Shopping cart')]")	
	WebElement shoppingCartLink;
	@FindBy(xpath = "//span[contains(text(),'Wishlist')]") 
	WebElement wishlistLink;
	@FindBy(id = "small-searchterms") 
	WebElement searchTextfield;
	@FindBy(xpath = "//input[@value='Search']") 
	WebElement searchButton;
	
	public void clickOnLogo() {
		demoWebShopLogo.click();
	}
	
	public void clickOnRegisterLink() {
		registerLink.click();
	}
	public boolean verifyIfMyAccountLinkIsDisplayed() {
		return myAccountLink.isDisplayed();
	}
	
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	
	public void clickOnShoppingCartLink() {
		shoppingCartLink.click();
	}
	
	public void clickOnWishlistLink() {
		wishlistLink.click();
	}
	
	public void enterValueIntoSearchTextfield(String value) {
		searchTextfield.sendKeys(value);
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
}
