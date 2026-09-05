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
}
