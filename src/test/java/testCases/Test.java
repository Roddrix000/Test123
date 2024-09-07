package testCases;
import java.time.Duration;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Test {

			public static void main(String[] args) throws MalformedURLException, InterruptedException 
			{
				ChromeOptions driver1 = new ChromeOptions();
				DesiredCapabilities cap = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.setPageLoadStrategy(PageLoadStrategy.EAGER);
				cap.merge(options);
				cap.setBrowserName("chrome");
				WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.get("https://katana.roofandfloor.com/chennai#");
			}
	}