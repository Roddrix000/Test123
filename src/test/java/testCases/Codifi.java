package testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Codifi {
	
	
	public static ChromeOptions sample()
	{
		
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		opt.addArguments("--headless");
		return opt;
	    
		
	}
	
public static void main(String[] args) throws IOException, InterruptedException {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ronald\\AppData\\Roaming\\fire-flink-client\\exec\\chromedriver.exe");
	ChromeOptions options = sample();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	//options.merge(capabilities);
	WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);		
	driver.get("https://www.google.com");
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.xpath("(//input[@value='Google Search'])[2]")).isDisplayed());
	System.out.println("DOne");
}
}
