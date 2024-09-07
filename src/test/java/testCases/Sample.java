package testCases;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Sample {

	private static String file1 = "C:\\Users\\Ronald\\Desktop\\Paycraft\\Actual Data\\sampledownloadedfilesandsqlqueries\\PMRP_Shift_270524.xls";
    
    private static String file2 = "C:\\Users\\Ronald\\Desktop\\Paycraft\\Actual Data\\sampledownloadedfilesandsqlqueries\\PMRP_Revenue_Summ_270524 (3).xls";
    
    private static String keyForfile1 = "CARD REPLACEMENT";
    private static String keyForfile2 = "Sub Total(Date)";


    public static void main(String[] args) throws IOException {

        String excelFilePath = file1;
        int headerRawCount = 9; // specify count from where the header row starts
        Map<String, Object> excelMap = new HashMap<>();
        try (FileInputStream excelFile = new FileInputStream(new File(excelFilePath));
             Workbook workbook = new XSSFWorkbook(excelFile)) {
            Sheet sheet = workbook.getSheetAt(0);
            CellLocation location = findKey(sheet, keyForfile1, headerRawCount);
            if (location != null) {
                System.out.println("Key found at row: " + location.getRow() + ", column: " + location.getColumn());
            } else {
                System.out.println("Key not found.");
            }
            getRowValues(sheet, location.getRow(), excelMap);
            System.out.println("exce:"+excelMap);
        }
    }

    private static void getRowValues(Sheet sheet, int rowNumber, Map<String, Object> excelMap) {

        Row row = sheet.getRow(rowNumber);
        if (row != null) {
            Object divisionHeader = "";
            for (Cell cell : row) {
                Object value = getCellValue(cell);
                List<Object> columnData = getColumnData(sheet, cell.getColumnIndex());
                if(CollectionUtils.isNotEmpty(columnData)) {
                    Object firstHeader = columnData.stream().filter(col -> Objects.nonNull(col) && !col.equals("")).findFirst().orElse(null);
                    int startIndex = columnData.indexOf(firstHeader);
                    Object header = "";
                    Object columnValue = columnData.get(startIndex+1);
                    if(columnValue.toString().isEmpty()) {
                        header = firstHeader;
                        divisionHeader = firstHeader;
                    } else if(columnValue.equals(0.0)) {
                        header =  divisionHeader + "-" + firstHeader;
                    } else {
                        header = firstHeader + "-" + columnValue;
                        divisionHeader = firstHeader;
                    }
                    excelMap.put(header.toString(), value);
                }
            }
        }
    }

    private static List<Object> getColumnData(Sheet sheet, int targetColumn) {
        List<Object> data = new ArrayList<>();
        for (Row row : sheet) {
            Cell cell = row.getCell(targetColumn);
            if (cell != null) {
                data.add(getCellValue(cell));
            } else {
                data.add("");
            }
        }
        return data;
    }

    private static CellLocation findKey(Sheet sheet, String key, int headerRowCount) {
        int firstRowNum = sheet.getFirstRowNum();
        int lastRowNum = sheet.getLastRowNum();

        for (int rowIndex = firstRowNum + headerRowCount; rowIndex <= lastRowNum; rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                for (Cell cell : row) {
                    if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equals(key)) {
                        return new CellLocation(row.getRowNum(), cell.getColumnIndex());
                    }
                }
            }
        }
        return null;
    }

    static class CellLocation {
        private final int row;
        private final int column;

        public CellLocation(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

    private static Object getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> DateUtil.isCellDateFormatted(cell) ? cell.getDateCellValue() : cell.getNumericCellValue();
            case BOOLEAN -> cell.getBooleanCellValue();
            case FORMULA -> cell.getCellFormula();
            case BLANK -> "";
            default -> null;
        };
    }

}
