package org.example;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        try{
//            File file = new File("src/input.txt");
//            Scanner myReader = new Scanner(file);
//            myReader.nextLine();
//            Object[][] object = new Object[4][2];
//            int numTestData=0;
//            while (myReader.hasNextLine()) {
//                String data = myReader.nextLine();
//                object[numTestData][0] = data.split(", ")[0];
//                object[numTestData][1] = data.split(", ")[1];
//                numTestData++;
//            }
//            for (int i=0;i<object.length;i++){{
//                for (int j=0;j<object[i].length;j++)
//                    System.out.print(object[i][j]+"---");
//                System.out.println();
//            }}
//            myReader.close();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        XSSFWorkbook xssfWorkbook2 = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook2.createSheet("Test result");
        Row row = xssfSheet.createRow(0);
        xssfSheet.setColumnWidth(0,100);
        row.createCell(0).setCellValue("Test case");
        row.createCell(1).setCellValue("Result");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/testResult.xlsx");
            xssfWorkbook2.write(fileOutputStream);
            fileOutputStream.close();
            System.out.println("Success!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}