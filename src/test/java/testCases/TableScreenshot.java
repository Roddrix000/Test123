package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class TableScreenshot {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Maximize the browser window
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-web-security");
        WebDriver driver = new ChromeDriver(options);
        System.out.println("DOne");
        driver.get("https://www.techlistic.com");


        // Replace "Paper QR" with the header value you want to search for
        String headerValue = "Contact";

        // Find the table element
        WebElement table = driver.findElement(By.id("revenue-summary"));

        // Find the column index based on the header value
        int columnIndex = table.findElements(By.xpath(".//th[contains(text(), '" + headerValue + "')]/preceding-sibling::th")).size() + 1;

        // Take a screenshot of the column
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            ImageIO.write(ImageIO.read(screenshot).getSubimage(0, table.getLocation().getY(), table.getSize().getWidth(), table.getSize().getHeight()), "png", screenshot);
            File outputFile = new File("column_screenshot.png");
            ImageIO.write(ImageIO.read(screenshot).getSubimage(table.findElement(By.xpath(".//tr[" + columnIndex + "]")).getLocation().getX(), 0, table.findElement(By.xpath(".//tr[" + columnIndex + "]")).getSize().getWidth(), table.getSize().getHeight()), "png", outputFile);
            screenshot.delete();
            System.out.println("Screenshot of the column '" + headerValue + "' saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
