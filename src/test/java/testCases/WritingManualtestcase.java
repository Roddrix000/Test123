package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WritingManualtestcase {

	public static void main(String[] args) throws IOException, Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/Ronald/AppData/Roaming/fire-flink-client/localnode/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		WebDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();
//		//driver.get("http://demowebshop.tricentis.com");
//		FileInputStream fis = new FileInputStream("‪D:/Test/Sample.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet sheet = workbook.getSheetAt(0);
//                    //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
//                    //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
//        System.out.println(cell);
//		System.out.println(sheet.getRow(0).getCell(0));
//		//String cellval = cell.getStringCellValue();
		// System.out.println(cellval);

		driver.get("https://saathiuat.motilaloswal.com/ba/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='EmployeeCode']")).sendKeys("6160");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Mosl_123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='btnLogin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@onclick='ForceLogin()']")).click();
	}

}
