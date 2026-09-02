package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BooksPageTest extends BaseTest {

    @Test(priority=1)
    public void validateBooksPageTitle(){
        homePage.clickLoginLink();
        loginPage.enterEmail("adamp@test.com");
        loginPage.enterPassword("Pass@123");
        loginPage.clickLoginButton();
        System.out.println(loginPage.islogoutlinkdisplayed());
        Assert.assertTrue(loginPage.islogoutlinkdisplayed());
        homePage.clickBooksMenu();
        String booksPageTitle = booksPage.getBooksPageTitle();
        Assert.assertTrue(booksPageTitle.contains("Books"));
        loginPage.clicklogoutlink();
    }

}
