package com.ws.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuildYourOwnComputerTest extends BaseTest {

    @Test(priority = 1)
    public void verifyBuildYourOwnComputerPage() {
       //driver.get("https://demowebshop.tricentis.com/build-your-own-computer");
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButtonForProduct("Build your own computer");
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); wait.until(ExpectedConditions.titleContains("Build your own computer"));
        Assert.assertTrue(driver.getTitle().contains("Build your own computer"));
        Assert.assertEquals(buildYourOwnComputerPage.getProductPrice(), "1200.00");

        buildYourOwnComputerPage.selectProcessorByIndex(1);
        buildYourOwnComputerPage.selectRAMByIndex(1);
        buildYourOwnComputerPage.selectHDDByIndex(1);
        buildYourOwnComputerPage.selectOSByIndex(1);
        buildYourOwnComputerPage.selectSoftwareByIndex(0);
        buildYourOwnComputerPage.setQuantity("1");
        buildYourOwnComputerPage.clickAddToCart();
    }
}