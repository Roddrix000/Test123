package testCases;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelFormatFixer {
    public static void main(String[] args) {
        String filePath = "D:\\Paycraft\\PMRP_Revenue_Summ_270524.xls"; // Change to your file path
        String correctedFilePath = "D:\\Paycraft\\PMRP_Revenue_Summ_270524.xlsx"; // Change to your desired output file path

        try {
            Workbook workbook = null;
            try (FileInputStream fis = new FileInputStream(new File(filePath))) {
                // Try opening as .xlsx
                try {
                    workbook = new XSSFWorkbook(fis);
                } catch (Exception ex) {
                    // If it fails, try opening as .xls
                    workbook = new HSSFWorkbook(fis);
                }
            }

            if (workbook != null) {
                // Save the workbook with the correct extension
                try (FileOutputStream fos = new FileOutputStream(correctedFilePath)) {
                    workbook.write(fos);
                }
                System.out.println("File saved successfully with the correct format.");
            } else {
                System.out.println("Failed to determine the file format.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
