package org.example.utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public  static String  getExcelData(int rowNo,int colNo) throws IOException, InvalidFormatException {
        File file = new File(System.getProperty("user.dir")+"\\SeleniumTestData.xlsx");

        if (!(file.exists())) {
            throw new RuntimeException("Excel file not found");
        }


        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file);
        XSSFSheet sheet=    xssfWorkbook.getSheetAt(0);

       System.out.println( sheet.getLastRowNum());
        System.out.println(sheet.getRow(0).getLastCellNum());


        return sheet.getRow(rowNo).getCell(colNo).toString();

//        for(int i=0;i<=sheet.getLastRowNum();i++){
//           Row row= sheet.getRow(i);
//           for(int j=0;j<row.getLastCellNum();j++){
//              // System.out.println("value of row and column is "+i+j);
//               System.out.println(row.getCell(j));
//           }
//
//
//
//        }

//
// XSSFRow rowZero= sheet.getRow(0);
//
//System.out.println(rowZero.getCell(0));
//        System.out.println(rowZero.getCell(1));
//
//        XSSFRow rowOne= sheet.getRow(1);
//        System.out.println(rowOne.getCell(0));
//
//        System.out.println(rowOne.getCell(1));

    }

    public static void writeDataToExcel(String[][] celldata) throws IOException, InvalidFormatException {
String path=System.getProperty("user.dir")+"\\SeleniumTestData.xlsx";
        File file = new File(path);

        if (!(file.exists())) {
            throw new RuntimeException("Excel file not found");
        }


        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet sheet=xssfWorkbook.createSheet("seleniumsample");
        for (int i=0;i<celldata.length;i++){
            Row row=sheet.createRow(i);
            for(int j=0;j<celldata[i].length;j++){
                //System.out.println(celldata[i][j]);
                row.createCell(j).setCellValue(celldata[i][j]);
            }


        }







//       row.createCell(0).setCellValue("hello");
//       row.createCell(1).setCellValue("world");
//
//        Row rowOne= sheet.createRow(1);
//        rowOne.createCell(0).setCellValue("hello in row one");
//        rowOne.createCell(1).setCellValue("world in row one");
FileOutputStream fileOutputStream=new FileOutputStream(path);
       xssfWorkbook.write( fileOutputStream);
       fileOutputStream.close();
xssfWorkbook.close();
System.out.println("File written successfully");


    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        String[][] celldata=new String[][]{{"1","2","3","4"},{"5","6","7","8"}};
        writeDataToExcel(celldata);
       // System.out.println(celldata.length);
//        for (int i=0;i<celldata.length;i++){
//        //    System.out.println(celldata[i].length);
//           for(int j=0;j<celldata[i].length;j++){
//               System.out.println(celldata[i][j]);
//           }
//
//
//        }


    }

}


