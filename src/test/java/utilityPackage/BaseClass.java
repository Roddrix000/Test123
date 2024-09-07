package utilityPackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

	public WebDriver driver;
	
	@BeforeClass
	public void browserSetup() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	@AfterClass
	public void browserTearDown() {
		
		driver.quit();
	}
}
