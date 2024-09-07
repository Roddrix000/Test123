package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Mars_And_Saturn {
	
	public static  AndroidDriver driver; 
	public static WebDriverWait wait;
	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("newCommandTimeout", 100000);
        // Name of the OS: Android, iOS or FirefoxOS
        capabilities.setCapability("platformName", "Android");
        //set the name of the connected device.you have to give same name in both server and the code
        capabilities.setCapability("deviceName","sdk_gphone64_x86_64");
        //set the package name of the app 
        capabilities.setCapability("appPackage", "com.fivepaisa.trade");
        //set the Launcher activity name of the app
        capabilities.setCapability ("appActivity","com.fivepaisa.activities.SplashActivity");
        
        capabilities.setCapability("udid", "emulator-5554");
        //No Reset Capability 
       // capabilities.setCapability("noReset",false);
		//driver object with new Url and Capabilities
		 driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		 System.out.println("Launched");
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			System.out.println("Before Execution "+timeStamp);
		 //loging to application
		// wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		 Login_to_app(); 
	 }
	
	public static void Login_to_app() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		boolean rr = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.ImageView[@package='com.ghc.marsapp']|//android.widget.ImageView[@package='com.ghc.saturnapp']")))).isDisplayed();
		System.out.println(rr);
		wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.xpath("(//android.widget.Button[@package='com.ghc.marsapp'])[1]|(//android.widget.Button[@package='com.ghc.saturnapp'])[1]")))).click();
		// Validating the logout
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.view.View[@content-desc='Login']|//android.view.View[@content-desc='Logout']"))));
		String v1 = driver.findElement(By.xpath("//android.view.View[@content-desc='Login']|//android.view.View[@content-desc='Logout']")).getAttribute("content-desc");
		System.out.println(v1);
		if("Logout".equals(v1))
		{
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.View[@content-desc='Logout']")))).click();
			driver.findElement(By.xpath("//android.widget.Button[@content-desc='Yes']")).click();
			driver.findElement(By.xpath("(//android.widget.Button[@package='com.ghc.saturnapp'])[1]|(//android.widget.Button[@package='com.ghc.marsapp'])[1]")).click();
			System.out.println("Logged Out..!!!");
		}
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.View[@content-desc='Login']|//android.view.View[@content-desc='Logout']")))).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Username')]")))).click();
		driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Username')]")).sendKeys("fireflinktest180124@mailinator.com");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Password')]")))).click();
		driver.findElement(By.xpath("//android.widget.EditText[contains(@text,'Password')]")).sendKeys("testuser");
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Sign in with email')]")))).click();
         boolean f1 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.view.View[@content-desc='0']|//android.widget.ImageView[1]")))).isDisplayed();
		System.out.println(f1+" Logged In..");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("After Execution "+timeStamp);
		driver.quit();
	}

}

