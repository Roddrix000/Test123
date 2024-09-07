package testCases;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
public class FivePaisaApplication {
	public static 	WebDriver driver;
	public static AndroidDriver andriod_driver;
	public static DesiredCapabilities capabilities;
	public static String GoogleappPackage="com.google.android.apps.authenticator2";
	public static String GoogleappActivity="com.google.android.apps.authenticator.AuthenticatorActivity";
	public static String clint_code="52187400";
	public static String mob_number;
	public static String pincode="123580";
	public static String username="ronaldfredricka_aTtZ6p";
	public static String accessKey="qzwZpKJMSfqzq8AgZ6cx";
	public static String browserStackUrl="https://"+username+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub";
	public static String platform="local";
	public static String clear_btn="//android.widget.TextView[contains(@content-desc,'Clear')]";
	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 5; i++) {
			System.out.println(i+" time Running");
			driver=settingCapabilities(platform);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.5paisa.com/");
			driver.manage().window().maximize();
			WebElement loginBtn = driver.findElement(By.xpath("//a[@id='tm-login']"));
			waitUntil(driver, loginBtn);
			loginBtn.click();
			String parentwind = driver.getWindowHandle();
			ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(windows.get(1));
			WebElement proceed = driver.findElement(By.id("btnGenerateOTP"));
			waitUntil(driver, proceed);
			driver.findElement(By.xpath("//input[@id='loginUser']")).sendKeys(clint_code);
			//Switching to android 
			andriod_driver = CreatingInstanceOpenApp();
			clearNotification();
			//Switching to web
			proceed.click();
			String TwoOTP = TOTP_Verification(capabilities,andriod_driver);
			//Entering TOPT 
			enterTOTP(TwoOTP);
			Thread.sleep(1000);
			driver.findElement(By.id("btnVerifyTOTP")).click();
			//ENter PIN
			enterPIN(pincode);
			driver.findElement(By.xpath("(//div[@class='button_wrap'])[2]/child::button[text()='Submit']")).click();
			Linking_Limit_Exceeded();
			LogOut();
			driver.quit();
		}
	}

	public static void waitUntil(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public static AndroidDriver CreatingInstanceOpenApp() throws MalformedURLException
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Galaxy A13");
		capabilities.setCapability("platformVersion", "13");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("autoGrantPermissions", "true");
		AndroidDriver andriod_driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		andriod_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return andriod_driver;
	}

	public static WebDriver settingCapabilities(String platform) throws Exception
	{
		switch (platform) {
		case "local":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			opt.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(opt);		
			break;

		case "browserStack":
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("os", "windows");
			capabilities.setCapability("os_version", "11");	
			capabilities.setCapability("browser", "chrome");
			capabilities.setCapability("browser_version", "123");
			capabilities.setCapability("name", "Lauch FivePaisa App");
			ChromeOptions opt1=new ChromeOptions();
			opt1.addArguments("--disable-notifications");
			opt1.addArguments("--remote-allow-origins=*");
			capabilities.merge(opt1);
			driver= new RemoteWebDriver(new URL(browserStackUrl),capabilities);
			break;
		}
		return driver;
	}

	public static void clearNotification()
	{
		andriod_driver.openNotifications();
		WebElement cbtn = andriod_driver.findElement(By.xpath(clear_btn));
		boolean flag = cbtn.isEnabled();
		if (flag==true) {
			cbtn.click();
		}else
		{
			andriod_driver.pressKey(new KeyEvent(AndroidKey.BACK));
		}
	}

	public static String TOTP_Verification(DesiredCapabilities capabilities, AndroidDriver andriod_driver)
	{
		andriod_driver.startActivity(new Activity(GoogleappPackage, GoogleappActivity));
		String TwoOTP = andriod_driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'com.google.android.apps.authenticator2:id/pin_value')]")).getText();
		return TwoOTP.replaceAll(" ", "");

	}

	public static void enterTOTP(String TwoOTP)
	{   
		for (int i = 0; i < TwoOTP.length(); i++) {
			char v = TwoOTP.charAt(i);
			String v1= String.valueOf(v);
			driver.findElement(By.xpath("//input[@id='dvLoginTOTP"+(i+1)+"']")).sendKeys(v1);
		}
	}

	public static void enterPIN(String PIN)
	{   
		WebElement pintextfield = driver.findElement(By.xpath("//input[@id='dvPin1']"));
		waitUntil(andriod_driver, pintextfield);
		for (int i = 0; i < PIN.length(); i++) {
			char v = PIN.charAt(i);
			String v1= String.valueOf(v);
			driver.findElement(By.xpath("//input[@id='dvPin"+(i+1)+"']")).sendKeys(v1);
		}
	}
	public static void Linking_Limit_Exceeded()
	{
		WebElement YesBind = driver.findElement(By.xpath("(//button[text()='Yes, Bind'])[2]"));
		boolean flag = YesBind.isDisplayed();
		if (flag==true) {
			YesBind.click();
		}
	}

	public static void LogOut()
	{
		WebElement profile = driver.findElement(By.xpath("//button[@id='dropdownMenuButton']"));
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		waitUntil(andriod_driver, profile);
		profile.click();
		waitUntil(andriod_driver, logout);
		logout.click();
	}

}
