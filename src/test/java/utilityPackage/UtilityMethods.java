package utilityPackage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityMethods {

	public static String getConfig(String key) throws Exception {
		
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(new File("./TestConfiguration/TestProperties.properties"));
		properties.load(fis);
		return properties.getProperty(key);
	}
	
	public static Object[][] getExcelData(String sheetName) throws Exception {
		
		FileInputStream fis = new FileInputStream(new File("./ExternalFile/TestData.xlsx"));
		Workbook book = new XSSFWorkbook(fis);
		Sheet sheet = book.getSheet(sheetName);
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][]data = new Object[rows-1][cols];
		for(int i=0; i<rows-1; i++) {
			for(int j=0; j<cols; j++) data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
		}
		book.close();
		return data;
	}
}
