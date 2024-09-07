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
public class ExcelReader {
	public static String filePath = "C://Users//Ronald//Desktop//Paycraft//paycraft.xlsx";
	public static final String headerToSearch = "Shift Details";
	public static final String searchedData = "shift id";
	public static int rowNum;
	public static int colNum;
	public static void main(String[] args) {
		
		ArrayList arr= new ArrayList();
		try {
			FileInputStream file = new FileInputStream(new File(filePath));
			Workbook workbook = WorkbookFactory.create(file);
			// Assuming data is in the first sheet, change index if needed
			Sheet sheet = workbook.getSheetAt(0);
			// Find the header row
			int columnIndex = -1;
			//List< String>
			//THis is somting i added now
			Map<String,Integer> m1= new HashMap();
			for (Row row : sheet) {
				for (Cell cell : row) {
					// Check if the Header value matches the search string
					if (cell != null && cell.getCellType() == CellType.STRING) {
						switch (cell.getStringCellValue()) {
						case headerToSearch:
							m1.put(headerToSearch, cell.getColumnIndex());
							break;
						}						
					}
				}
				Cell subcell= row.getCell(m1.get(headerToSearch));
				Object cellData = getCellValue(subcell);
				if (cellData.equals(searchedData)) {
					arr.add(searchedData);
					int ind = subcell.getColumnIndex();
					ind=ind+1;
					 Cell datacell = row.getCell(ind);
					 
					Object countdata = getCellValue(datacell);
					arr.add(countdata);
					ind=ind+1;
					 Cell datacell2 = row.getCell(ind);
					 Object amountdata = getCellValue(datacell2);
					 arr.add(amountdata);
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exceptions
			e.printStackTrace();
		}
		System.out.println(arr);
	}
	
	public static Object  getCellValue(Cell cell)
	{
		if (cell != null) {
            // Print the value of the cell under the specified header
            switch (cell.getCellType()) {
                case STRING:
                   return cell.getStringCellValue();
                case NUMERIC:
                    return cell.getNumericCellValue();
                 
                case BOOLEAN:
                   return cell.getBooleanCellValue();
                case BLANK:
                    return "";
            }
        }
		return "";

	}
}

