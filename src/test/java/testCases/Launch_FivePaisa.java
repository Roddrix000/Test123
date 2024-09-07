package testCases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch_FivePaisa {

	public static String username="ronaldfredricka_aTtZ6p";
	public static String accessKey="qzwZpKJMSfqzq8AgZ6cx";
	public static String browserStackUrl="https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	public static String platform="local";
	public static void main(String[] args) throws Exception {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("app","bs://14ae7e0d0e718db5fe53b411834fedc4b1db2891");
		AndroidDriver driver = new AndroidDriver(new URL(browserStackUrl),capabilities);  
	}
	
}


