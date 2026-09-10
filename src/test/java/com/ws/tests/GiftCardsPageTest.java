package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftCardsPageTest extends BaseTest {

    @Test(priority=1)
    public void testGiftCardPage(){
        logger = report.createTest("Validate Gift Cards Page");
        homePage.clickLoginLink();
        logger.pass("clicked login link");
        loginPage.enterEmail("adamp@test.com");
        logger.pass("entered email");
        loginPage.enterPassword("Pass@123");
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        homePage.clickGiftCardsMenu();
        logger.pass("clicked gift cards menu");
        String expected = giftCardsPage.getGiftCardsText();

        String actual = "Gift Cards";
        Assert.assertTrue(expected.contains(actual));
        logger.pass("validated the text");
        loginPage.clicklogoutlink();
        logger.pass("successfully logged out from application");
    }
    @Test(priority = 2)
    public void testGiftCardsDisplayed(){
        logger = report.createTest("Validate total count matching with expected count");
        homePage.clickLoginLink();
        logger.pass("clicked login link");
        loginPage.enterEmail("adamp@test.com");
        logger.pass("entered email");
        loginPage.enterPassword("Pass@123");
        logger.pass("entered password");
        loginPage.clickLoginButton();
        logger.pass("clicked login button");
        String emailID1 = loginPage.getUserloggedinText();
        Assert.assertTrue(emailID1.contains(".com"));
        logger.pass("validated user successfully logged in");
        homePage.clickGiftCardsMenu();
        logger.pass("clicked gift cards menu");
        String expected = giftCardsPage.getGiftCardsText();
        String actual = "Gift Cards";
        Assert.assertTrue(expected.contains(actual));
        logger.pass("validated the text");
        int giftcardsCount = giftCardsPage.getProductsCount();
        Assert.assertEquals(3,giftcardsCount,"Giftcards count do not match");
        logger.pass("validated gift cards count");
        loginPage.clicklogoutlink();
        logger.pass("successfully logged out from application");
    }
}
