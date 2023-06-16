package com.pcgus.ci;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    private static final Logger log = LogManager.getLogger(ExcelReader.class);

    public static String readExcel(String sheetName, String cellValue, String filePath) {
        String content = "";
        try {
            File file = new File(System.getProperty(filePath));
            FileInputStream fs = new FileInputStream(file);
            XSSFWorkbook wk = new XSSFWorkbook(fs);
            XSSFSheet s1 = wk.getSheet(sheetName);

            for (int i = 0; i >= 0; i++) {
                XSSFRow r1 = s1.getRow(i);
                XSSFCell c0 = r1.getCell(0);
                if (cellValue.equals(c0.getStringCellValue())) {
                    XSSFCell c1 = r1.getCell(1);
                    content = c1.getStringCellValue();
                    break;
                }
                if (c0.getStringCellValue().isEmpty()) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File not Found: " + e.getMessage() );
            Assert.fail("Exception Occured");
        } catch (IOException e) {
            log.error("Input & Output operations exception occurred." + e.getMessage());
            Assert.fail("Exception Occured");
        }

        return content;
    }

    public static String readExcel(String sheetName, String cellValue, File file) {
        String content = "";
        try {
            FileInputStream fs = new FileInputStream(file);
            XSSFWorkbook wk = new XSSFWorkbook(fs);
            XSSFSheet s1 = wk.getSheet(sheetName);
            for (int i = 0; i >= 0; i++) {
                XSSFRow r1 = s1.getRow(i);
                XSSFCell c0 = r1.getCell(0);
                if (cellValue.equals(c0.getStringCellValue())) {
                    XSSFCell c1 = r1.getCell(1);
                    content = c1.getStringCellValue();
                    break;
                }
                if (c0.getStringCellValue().isEmpty()) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            log.error("File not Found: " + e.getMessage() );
            Assert.fail("Exception Occurred");
        } catch (IOException e) {
            log.error("Input & Output operations exception occurred." + e.getMessage());
            Assert.fail("Exception Occurred");
        }
        return content;
    }

    public static XSSFSheet returnDataSheet(String sheetName, String path) {
        FileInputStream fileInputStream;
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet = null;
        try {
            File file = new File(System.getProperty(path));
            fileInputStream = new FileInputStream(file);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            return xssfWorkbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            log.error("File not Found: " + e.getMessage() );
            Assert.fail("Exception Occurred");
        } catch (IOException e) {
            log.error("Input & Output operations exception occurred." + e.getMessage());
            Assert.fail("Exception Occurred");
        }
        return xssfSheet;
    }


    public static XSSFSheet returnDataSheet(String sheetName, File file) {
        FileInputStream fileInputStream;
        XSSFWorkbook xssfWorkbook;
        XSSFSheet xssfSheet = null;
        try {
            fileInputStream = new FileInputStream(file);
            xssfWorkbook = new XSSFWorkbook(fileInputStream);
            return xssfWorkbook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            log.error("File not Found: " + e.getMessage() );
            Assert.fail("Exception Occurred");
        } catch (IOException e) {
            log.error("Input & Output operations exception occurred." + e.getMessage());
            Assert.fail("Exception Occurred");
        }
        return xssfSheet;
    }



}
