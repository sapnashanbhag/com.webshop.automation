package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopsPageTest extends BaseTest {
    @Test(priority=1)
    public void verifySortByNameAtoZ(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.selectoptionNameAtoZ();
        List<String> actualdesktopslist = desktopsPage.getdesktopNames();
        List<String> expectedDesktopsList = new ArrayList<>(actualdesktopslist);
        Collections.sort(expectedDesktopsList);
        Assert.assertEquals(actualdesktopslist,expectedDesktopsList,
                "Desktop names are not sorted from A to Z");
    }
    @Test(priority=2)
    public void verifySortByPriceLowtoHigh(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.selectoptionPriceLowtoHigh();
        List<Double> actualpricelist = desktopsPage.getdesktopPrices();
        List<Double> expectedpricelist = new ArrayList<>(actualpricelist);
        Collections.sort(expectedpricelist);
        Assert.assertEquals(actualpricelist,expectedpricelist,"Prices are not sorted from low to high" );
    }

    @Test(priority=3)
    public void verifydisplay4perpage(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.selectDisplayperpage("4");
        int expected = desktopsPage.displaygridperpageCount();
        Assert.assertEquals(4,expected,"Actual and expected count of desktops do not match");
    }

    @Test(priority=4)
    public void verifyGridDisplay(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.selectViewasGrid();
        boolean display = desktopsPage.desktopsgridviewIsDisplayed();
        Assert.assertTrue(display,"Grid view is not displayed");
    }

    @Test(priority=5)
    public void verifyListDisplay(){

    }

    @Test(priority=6)
    public void verifyAddToCartButtonCount(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        int actualButtonCount = desktopsPage.getAddToCartButtonCount();
        Assert.assertEquals(actualButtonCount, 4,
                "Desktop Add to Cart button count does not match");
    }

    @Test(priority=7)
    public void clickFirstDesktopAddToCartButton(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButton(0);
      //  Assert.assertTrue(desktopsPage.getAddToCartButtonCount() > 0,
        //        "Add to Cart button is not clickable");
    }

    @Test(priority=8)
    public void clickAllDesktopAddToCartButtons(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.addAllProductsToCart();
     //   Assert.assertTrue(desktopsPage.getAddToCartButtonCount() == 0,
       //         "Not all Add to Cart buttons were clicked");
    }

    @Test(priority=9)
    public void clickAddToCartButtonForProduct(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButtonForProduct("Build your own computer");
    //    Assert.assertTrue(desktopsPage.getAddToCartButtonCount() > 0,
      //          "Add to Cart button for the specified product is not clickable");
        
    }
}
