package testCases;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader_Verify_DataPresent {
	public static String filePath = "C://Users//Ronald//Desktop//Paycraft//paycraft.xlsx";
	// public static final String headerToSearch = "Shift Details";
	public static final String searchedData = "Shift Wise Total  NON Cash(QR)";
	public static Object fetchedData;
	public static int dataindex;
	public static int datarowIndex;

	public static void main(String[] args) {

		ArrayList arr = new ArrayList();

		try {

			FileInputStream file = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(file);
			// Assuming data is in the first sheet, change index if needed
			Sheet sheet = workbook.getSheetAt(0);
			// Find the header row
			int indexValue = 0;
			outerloop:
			for (Row row : sheet) {
				for (Cell cell : row) {
					// Check if the Header value matches the search string
					if (cell != null && cell.getCellType() != CellType.BLANK) {
						switch (cell.getCellType()) {
						case STRING:
							fetchedData=cell.getStringCellValue();
							break;
						case NUMERIC:
							fetchedData=cell.getNumericCellValue();
							break;
						case BOOLEAN:
							fetchedData=cell.getBooleanCellValue();
							break;
						}
						if (searchedData.equals(fetchedData)) {
							dataindex = cell.getColumnIndex();
							datarowIndex=cell.getRowIndex();
							indexValue++;
							break outerloop;
						}
						

					}
					
				}
			}
			if (indexValue <= 0)
				System.out.println("Expecting Data is Not found");
			else
				System.out.println(fetchedData + " Row Index " +datarowIndex+ " Column Index "+dataindex);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
