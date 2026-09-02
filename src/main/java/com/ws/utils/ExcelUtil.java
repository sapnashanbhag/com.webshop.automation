package com.ws.utils;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtil {
    XSSFWorkbook wb;
    //Pass the path as a parameter to generalise for any file
    //Constructor that gets loaded when this class is called
    public ExcelUtil(String excelPath)
    {
        try {
            File file = new File(excelPath);
            FileInputStream fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public int getRowCount(String sheetname){
        System.out.println(sheetname);
        return wb.getSheet(sheetname).getLastRowNum()+1;
    }
    public int getRowCount(int sheetindex){
        return wb.getSheetAt(sheetindex).getLastRowNum()+1;
    }
    public String getCellData(int sheetnum,int rownum,int cellnum){
        return wb.getSheetAt(sheetnum).getRow(rownum).getCell(cellnum).toString();
    }
    public String getCellData(String sheetname, int rownum, int cellnum){
        return wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).toString();
    }
}
