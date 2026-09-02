package com.ws.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.ws.driver.DriverScript;
import com.ws.page.BooksPage;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;
import com.ws.utils.ExcelUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

public class BaseTest extends DriverScript {
    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    public static ExtentReports report;
    public static ExtentTest logger;

    @BeforeSuite
    public void SetupReport(){
        ExtentHtmlReporter extent = new ExtentHtmlReporter("" + "F:/SeleniumTraining/seleniumworkspace/com.automation.webshop/src/test/resources/testreports/autoreport.html");
        report = new ExtentReports();
        report.attachReporter(extent);
    }

    @BeforeMethod
    public void setUp(){
        InitApplication();
        homePage = new HomePage();
        loginPage = new LoginPage();
        booksPage = new BooksPage();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        report.flush();
        quitDriver();
    }
    @DataProvider(name = "exceltestdata")
    public Object[][] testdata(){
        ExcelUtil excelutil = new ExcelUtil("./src/test/resources/testdata/testdata.xlsx");
        int maxrows = excelutil.getRowCount(0);
        System.out.println("maxrows"+maxrows);
        Object[][] data = new Object[maxrows][2]; //Object array of [maxrows][maxcolumns]
        for(int i = 0; i < maxrows; i++){
            data[i][0] = excelutil.getCellData(0,i,0);
            data[i][1] = excelutil.getCellData(0,i,1);
        }
        return data;
    }
}
