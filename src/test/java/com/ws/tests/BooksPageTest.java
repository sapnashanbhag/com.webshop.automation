package com.ws.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    @Test(priority=2)
    public void countSortByElements(){
        homePage.clickBooksMenu();
        List<WebElement> sortByElements = booksPage.sortByList();
        Assert.assertEquals(6,sortByElements.size(),"Size does not match");
        List<String> expectedOptions= Arrays.asList(
                "Position","Name: A to Z","Name: Z to A","Price: Low to High",
                "Price: High to Low","Created on");
        List<String> actualOptions = new ArrayList<>();
        for (int i = 0; i < sortByElements.size(); i++) {
            actualOptions.add(sortByElements.get(i).getText());
        }
        Assert.assertEquals(actualOptions,expectedOptions,"Options do not match");
    }
    @Test(priority=3)
    public void verifyBooksSortedNameAtoZ(){
        homePage.clickBooksMenu();
        booksPage.selectoptionNamesAtoZ();
        List<String> actualBookNames = booksPage.getBookNames();
        List<String> expectedBookNames = new ArrayList<>(actualBookNames);
        Collections.sort(expectedBookNames);
        Assert.assertEquals(actualBookNames,expectedBookNames,
                "Books are not sorted from A to Z");
    }
    @Test(priority=4)
    public void verifyBooksSortedNameZtoA(){
        homePage.clickBooksMenu();
        booksPage.selectoptionNamesZtoA();
        List<String> actualBookNames = booksPage.getBookNames();
        List<String> expectedBookNames = new ArrayList<>(actualBookNames);
        expectedBookNames.sort(Collections.reverseOrder());
        Assert.assertEquals(actualBookNames,expectedBookNames,"Sort order does not match Z to A");
    }
    @Test(priority=5)
    public void verifyBooksSortedPriceLowtoHigh(){
        homePage.clickBooksMenu();
        booksPage.selectoptionpriceLowtoHigh();
        List<Double> actualprices = booksPage.getBookPrices();
        List<Double> expectedprices = new ArrayList<>(actualprices);
        Collections.sort(expectedprices);
        Assert.assertEquals(actualprices,expectedprices,"Prices are not sorted low to high");
    }

    @Test(priority=6)
    public void verifyBooksSortedPriceHightoLow(){
        homePage.clickBooksMenu();
        booksPage.selectoptionpriceHightoLow();
        List<Double> actualprices = booksPage.getBookPrices();
        List<Double> expectedprices = new ArrayList<>(actualprices);
        expectedprices.sort(Collections.reverseOrder());
        Assert.assertEquals(actualprices,expectedprices,"Prices are not sorted high to low");
    }

    @Test(priority=7)
    public void verifyDisplay4BooksPerPage() {
        homePage.clickBooksMenu();
        booksPage.selectDisplaySize("4");
        int actualbookscount = booksPage.getDisplayedBookCount();
        Assert.assertEquals(actualbookscount,4,"books count does not match to 4");
    }

    @Test(priority=8)
    public void verifyDisplay8BooksPerPage() {
        homePage.clickBooksMenu();
        booksPage.selectDisplaySize("8");
        int actualbookscount = booksPage.getDisplayedBookCount();
        Assert.assertEquals(actualbookscount,6,"books count does not match to 6");
    }

    @Test(priority=9)
    public void verifyGridView() {
        homePage.clickBooksMenu();
        booksPage.selectGridView();
        Assert.assertTrue(
                booksPage.isGridViewDisplayed(),
                "Books are not displayed in Grid view"
        );
    }
    @Test(priority=10)
    public void verifyListView(){
        homePage.clickBooksMenu();
        booksPage.selectListView();
        Assert.assertTrue(booksPage.isListViewDisplayed(),"Books are not displayed in List view");
    }

    @Test(priority=11)
    public void priceunder25(){
        homePage.clickBooksMenu();
        booksPage.under25linkClick();
        boolean flag = booksPage.removefilterlinkisDisplayed();
        Assert.assertTrue(flag,"Remove filter is not displayed");
        int actualbookscount = booksPage.getDisplayedBookCount();
        Assert.assertEquals(actualbookscount,5, "No. of books under 25 do not match");
    }
    @Test(priority=12)
    public void removefilterlinkClick(){
        homePage.clickBooksMenu();
        booksPage.under25linkClick();
        boolean flag = booksPage.removefilterlinkisDisplayed();
        Assert.assertTrue(flag,"Remove filter is not displayed");
        booksPage.removefilterClick();
        int actualbookscount = booksPage.getDisplayedBookCount();
        Assert.assertEquals(actualbookscount,6, "No. of books after remove filter do not match");
    }




    }
