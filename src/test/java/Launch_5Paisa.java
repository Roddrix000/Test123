

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Launch_5Paisa {
	public static void main(String[] args) throws MalformedURLException {
		for (int i = 0; i < 15; i++) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("appPackage", "com.fivepaisa.trade");
			cap.setCapability("appActivity", "com.fivepaisa.activities.SplashActivity");
			cap.setCapability("platformName", "Android");
			cap.setCapability("noReset", true);
			cap.setCapability("autoGrantPermission", true);
			AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
			System.out.println("Session Created");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement Hello = driver.findElement(By.xpath("//*[contains(@text,'O')]"));
			wait.until(ExpectedConditions.visibilityOf(Hello));
			Hello.isDisplayed();
			driver.quit();

		}
//			WebElement totp = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='com.fivepaisa.trade:id/totpFields']//android.widget.FrameLayout[@resource-id=\"com.fivepaisa.trade:id/totpFields\"]"));
//			for (int i = 0; i < 6; i++) {
//				totp.click();
//				driver.pressKey(new KeyEvent().withKey(AndroidKey.CLEAR));
//			}

	}

}
