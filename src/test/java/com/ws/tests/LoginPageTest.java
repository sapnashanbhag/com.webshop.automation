package com.ws.tests;

import com.ws.driver.DriverScript;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//This class is used to test the login page functionality of the application.
// It extends the BaseTest class which contains the setup and teardown methods for the tests.
// The class contains multiple test methods to validate different scenarios of the login page such as valid login, login with empty credentials, invalid login credentials, and checking if the forgot password link is displayed. It also includes a data-driven test method to validate multiple login attempts using data from an Excel file.
public class LoginPageTest extends BaseTest {

    @Test(priority=1)
    public void testValidLogin(){
        logger = report.createTest("Validate login");
      //first go to homepage and click login link
        homePage.clickLoginLink();
        logger.pass("clicked login link");
        //it takes to login page and actions in login page
        loginPage.enterEmail("adamp@test.com");
        logger.pass("entered email");
        loginPage.enterPassword("Pass@123");
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        String emailID2 = loginPage.getUserloggedinText();
        System.out.println(emailID2);
        Assert.assertTrue(emailID2.contains(".com"));
        logger.pass("validated user logged in");
        loginPage.clicklogoutlink();
        logger.pass("clicked logout link");
    }
    @Test(priority=2)
    public void testLoginWithEmptyCrenetials(){
        logger = report.createTest("Test login with empty credentials");
        String actual = "No customer account found";
        homePage.clickLoginLink();
        logger.pass("clicked on login link");
        loginPage.clickLoginButton();
        logger.pass("clicked on login button");
        String expected = loginPage.noCustomerFoundText();
        Assert.assertEquals(actual,expected,"actual does not match expected");
        logger.pass("validated empty credentials");
    }
    @Test(priority=3)
    public void testInvalidLoginCredentials()
    {
        homePage.clickLoginLink();
        loginPage.enterEmail("adamp@test.com");
        loginPage.clickLoginButton();
        String actual = "The credentials provided are incorrect";
        String expected = loginPage.IncorrectCredentialsText();
        Assert.assertEquals(actual,expected,"Actual and Expected Text does not match");
    }
    @Test(priority = 4)
    public void isForgotPasswordlinkDisplayed(){
        homePage.clickLoginLink();
        Assert.assertTrue(loginPage.isForgotPaswdLinkDisplayed());
    }

    @Test(priority=1, dataProvider = "exceltestdata")
    public void testMultipleLogin(String email, String password){
        logger = report.createTest("Validate login");
        //first go to homepage and click login link
        homePage.clickLoginLink();
        logger.pass("clicked login link");
        //it takes to login page and actions in login page
        loginPage.enterEmail(email);
        logger.pass("entered email");
        loginPage.enterPassword(password);
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        String emailID = loginPage.getUserloggedinText();

        Assert.assertTrue(emailID.contains(".com"));
        logger.pass("validated user logged in");
        loginPage.clicklogoutlink();
        logger.pass("clicked logout link");
    }

}
