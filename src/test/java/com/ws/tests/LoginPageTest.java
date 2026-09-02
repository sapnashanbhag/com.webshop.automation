package com.ws.tests;

import com.ws.driver.DriverScript;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        String emailID = loginPage.getUserloggedinText();

        Assert.assertTrue(emailID.contains(".com"));
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

}
