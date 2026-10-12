package com.ws.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApparelnShoesPageTest extends BaseTest {

    @Test(priority = 1)
    public void validateApparelShoesPageTitle() {
        logger = report.createTest("Validate Apparel & Shoes page title");
        homePage.clickApparelShoesMenu();
        String pageTitle = apparelnShoesPage.getApparelnShoesPageTitle();
        Assert.assertTrue(pageTitle.contains("Apparel"), "Page title should contain Apparel");
        logger.pass("Apparel & Shoes page loaded successfully");
    }

    @Test(priority = 2)
    public void countSortByElements() {
        logger = report.createTest("Validate Sort by options");
        homePage.clickApparelShoesMenu();
        List<WebElement> sortByElements = apparelnShoesPage.sortByList();
        Assert.assertEquals(sortByElements.size(), 6, "Sort by options count is incorrect");

        List<String> expectedOptions = Arrays.asList(
                "Position",
                "Name: A to Z",
                "Name: Z to A",
                "Price: Low to High",
                "Price: High to Low",
                "Created on"
        );

        List<String> actualOptions = new ArrayList<>();
        for (WebElement option : sortByElements) {
            actualOptions.add(option.getText());
        }

        Assert.assertEquals(actualOptions, expectedOptions, "Sort by options do not match");
        logger.pass("Sort by options validated");
    }

    @Test(priority = 3)
    public void verifyPaginationNavigation() {
        logger = report.createTest("Validate pagination navigation");
        homePage.clickApparelShoesMenu();

        Assert.assertTrue(apparelnShoesPage.isPaginationDisplayed(), "Pagination is not displayed");
        int currentPage = apparelnShoesPage.getCurrentPageNumber();
        Assert.assertTrue(currentPage >= 1, "Current page should be at least 1");

        apparelnShoesPage.clickNextPage();
        int nextPage = apparelnShoesPage.getCurrentPageNumber();
        Assert.assertTrue(nextPage > currentPage, "Next page navigation did not happen");
        logger.pass("Pagination navigation validated");
    }

    @Test(priority = 4)
    public void verifyGridView() {
        logger = report.createTest("Validate Grid view");
        homePage.clickApparelShoesMenu();
        apparelnShoesPage.selectGridView();
        Assert.assertTrue(apparelnShoesPage.isGridViewDisplayed(), "Grid view is not displayed");
        logger.pass("Grid view validated");
    }

    @Test(priority = 5)
    public void verifyListView() {
        logger = report.createTest("Validate List view");
        homePage.clickApparelShoesMenu();
        apparelnShoesPage.selectListView();
        Assert.assertTrue(apparelnShoesPage.isListViewDisplayed(), "List view is not displayed");
        logger.pass("List view validated");
    }

    @Test(priority = 6)
    public void verifyProductDataLoaded() {
        logger = report.createTest("Validate product data");
        homePage.clickApparelShoesMenu();
        List<String> productNames = apparelnShoesPage.getProductNames();
        List<Double> productPrices = apparelnShoesPage.getProductPrices();

        Assert.assertFalse(productNames.isEmpty(), "Product names should be displayed");
        Assert.assertFalse(productPrices.isEmpty(), "Product prices should be displayed");
        Assert.assertEquals(productNames.size(), productPrices.size(), "Product names and prices counts should match");
        logger.pass("Product data validation passed");
    }

    @Test(priority = 7)
    public void verifyDisplay4ProductsPerPage() {
        logger = report.createTest("Validate display size selection");
        homePage.clickApparelShoesMenu();
        apparelnShoesPage.selectDisplaySize("4");
        int actualProductCount = apparelnShoesPage.getDisplayedProductCount();
        Assert.assertEquals(actualProductCount, 4, "Displayed product count should be 4 after selecting 4 per page");
        logger.pass("Display size selection validated");
    }

    @Test(priority = 8)
    public void verifyDisplay8ProductsPerPage() {
        logger = report.createTest("Validate page size 8");
        homePage.clickApparelShoesMenu();
        apparelnShoesPage.selectDisplaySize("8");
        int actualProductCount = apparelnShoesPage.getDisplayedProductCount();
        Assert.assertEquals(actualProductCount, 8, "Displayed product count should be 8 after selecting 8 per page");
        logger.pass("Page size 8 validated");
    }

    @Test(priority = 9)
    public void verifyDisplay12ProductsPerPage() {
        logger = report.createTest("Validate page size 12");
        homePage.clickApparelShoesMenu();
        apparelnShoesPage.selectDisplaySize("12");
        int actualProductCount = apparelnShoesPage.getDisplayedProductCount();
        Assert.assertEquals(actualProductCount, 12, "Displayed product count should be 12 after selecting 12 per page");
        logger.pass("Page size 12 validated");
    }
}
