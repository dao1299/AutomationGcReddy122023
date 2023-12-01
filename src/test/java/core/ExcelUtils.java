package core;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {
    private static XSSFSheet ExcelSheet;
    private static XSSFWorkbook xssfWorkbook;

    public static Object[][] getTableArray(String FilePath, String SheetName, int startCol, int totalCols) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            xssfWorkbook = new XSSFWorkbook(ExcelFile);
            ExcelSheet = xssfWorkbook.getSheet(SheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = ExcelSheet.getLastRowNum();
            tabArray = new String[totalRows][totalCols];
            ci = 0;
            for (int i = startRow; i <= totalRows; i++, ci++) {
                cj = 0;
                for (int j = startCol; j < totalCols + startCol; j++, cj++) {
                    tabArray[ci][cj] = getCellData(i, j);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return (tabArray);
    }

    private static String getCellData(int rowIndex, int colIndex) {
        DataFormatter formatter = new DataFormatter();
        XSSFCell cell;
        try {
            cell = ExcelSheet.getRow(rowIndex).getCell(colIndex);
            if (cell == null) {
                return "";
            } else {
                return formatter.formatCellValue(cell);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    public static void writeHeadingExcelFile() throws IOException {
        XSSFWorkbook xssfWorkbook2 = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook2.createSheet("Test result");
        Row row = xssfSheet.createRow(0);
        xssfSheet.setColumnWidth(0, 16900);
        xssfSheet.setColumnWidth(1, 16900);
        xssfSheet.setColumnWidth(2, 16900);
        XSSFCellStyle styleSubHeader = (XSSFCellStyle) xssfWorkbook2.createCellStyle();
        styleSubHeader.setAlignment(HorizontalAlignment.CENTER);
        // Write heading excel file
        row.createCell(0).setCellValue("Name test");
        row.createCell(1).setCellValue("Test case");
        row.createCell(2).setCellValue("Result");
        row.getCell(0).setCellStyle(styleSubHeader);
        row.getCell(1).setCellStyle(styleSubHeader);
        row.getCell(2).setCellStyle(styleSubHeader);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/testResult.xlsx");
            xssfWorkbook2.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeAppendExcelFile(String nameTest, String testcase, String result) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/testResult.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet xssfSheet = xssfWorkbook.getSheet("Test result");
        int lastRow = xssfSheet.getLastRowNum();
        Row row = xssfSheet.createRow(lastRow + 1);
        // write content including testcase name and result
        row.createCell(0).setCellValue(nameTest);
        row.createCell(1).setCellValue(testcase);
        row.createCell(2).setCellValue(result);
        XSSFCellStyle styleSubHeader = (XSSFCellStyle) xssfWorkbook.createCellStyle();
        styleSubHeader.setAlignment(HorizontalAlignment.CENTER);
        row.getCell(2).setCellStyle(styleSubHeader);

        // write to file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/testResult.xlsx");
            xssfWorkbook.write(fileOutputStream);
            fileOutputStream.close();
//            System.out.println("Success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
