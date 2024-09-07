package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_to_Application {
	@Test
	public static void test() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ronald\\AppData\\Roaming\\fire-flink-client\\localnode\\chromedriver.exe");
      //  WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
	}
}
