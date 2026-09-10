package com.ws.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BuildYourOwnCheapComputerTest extends BaseTest {

    @Test(priority = 1)
    public void verifyBuildYourOwnCheapComputerPage() {
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButtonForProduct("Build your own cheap computer");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); wait.until(ExpectedConditions.titleContains("Build your own cheap computer"));
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));
        Assert.assertEquals(buildYourOwnCheapComputerPage.getProductPrice(), "800.00");

        buildYourOwnCheapComputerPage.selectProcessorByIndex(1);
        buildYourOwnCheapComputerPage.selectRAMByIndex(1);
        buildYourOwnCheapComputerPage.selectHDDByIndex(1);
        buildYourOwnCheapComputerPage.selectSoftwareByIndex(0);
        buildYourOwnCheapComputerPage.setQuantity("1");
        buildYourOwnCheapComputerPage.clickAddToCart();

    }

    @Test(priority = 2)
    public void verifyBuildYourOwnCheapComputerPage2() {
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButtonForProduct("Build your own cheap computer");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Build your own cheap computer"));
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));
        Assert.assertEquals(buildYourOwnCheapComputerPage.getProductPrice(), "800.00");

        buildYourOwnCheapComputerPage.selectProcessorByValue("52");
        buildYourOwnCheapComputerPage.selectRAMByValue("54");
        buildYourOwnCheapComputerPage.selectHDDByValue("57");
        buildYourOwnCheapComputerPage.selectSoftwareByValue("94");
        buildYourOwnCheapComputerPage.setQuantity("100");
        buildYourOwnCheapComputerPage.clickAddToCart();
    }

    @Test(priority=3)
    public void verifyradiobuttonsCount() {
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
        desktopsPage.clickAddToCartButtonForProduct("Build your own cheap computer");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Build your own cheap computer"));
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));

        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Build your own cheap computer"));
        Assert.assertEquals(buildYourOwnCheapComputerPage.getProductPrice(), "800.00");

        int processorCount = buildYourOwnCheapComputerPage.getProcessorradiobuttonsCount();
        int ramCount = buildYourOwnCheapComputerPage.getRamradiobuttonsCount();
        int hddCount = buildYourOwnCheapComputerPage.getHddradiobuttonsCount();
        int softwareCount = buildYourOwnCheapComputerPage.getSoftwarecheckboxesCount();

        System.out.println("Processor radio buttons count: " + processorCount);
        System.out.println("RAM radio buttons count: " + ramCount);
        System.out.println("HDD radio buttons count: " + hddCount);
        System.out.println("Software checkboxes count: " + softwareCount);
        Assert.assertEquals(processorCount, 3, "Processor radio buttons count mismatch");
        Assert.assertEquals(ramCount, 3, "RAM radio buttons count mismatch");
        Assert.assertEquals(hddCount, 2, "HDD radio buttons count mismatch");
        Assert.assertEquals(softwareCount, 3, "Software checkboxes count mismatch");

    }
}
