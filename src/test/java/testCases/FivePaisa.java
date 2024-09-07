package testCases;

import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class FivePaisa {

	
public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
	String platformName = "Android";
	String loctorValue = "//android.widget.TextView[contains(@content-desc,'Clear')]";
	String URL = "http://localhost:4723/wd/hub";
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("platformName", platformName);
	AndroidDriver driverInstance=null;
	driverInstance = new AndroidDriver(new URL(URL), cap);
	driverInstance.openNotifications();
	driverInstance.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(2000);
	if (driverInstance.findElements(By.xpath(loctorValue)).size() > 0) {
		
		try {
			driverInstance.findElement(By.xpath(loctorValue)).click();
			
		}
		catch (ElementClickInterceptedException e) {
			// TODO: handle exception
			driverInstance.pressKey(new io.appium.java_client.android.nativekey.KeyEvent().withKey(AndroidKey.BACK));
//			nlpResponseModel.setStatus(CommonConstants.pass);
//			nlpResponseModel.setMessage("Notification is not present at the movement");
		}
	} else {
		driverInstance.pressKey(new io.appium.java_client.android.nativekey.KeyEvent().withKey(AndroidKey.BACK));
//		nlpResponseModel.setStatus(CommonConstants.pass);
//		nlpResponseModel.setMessage("Notification is not present at the movement");
	}
	
}
}

