package com.ws.tests;

import com.ws.page.ComputersPage;
import com.ws.page.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputersPageTest extends BaseTest {

    @Test(priority=1)
    public void verifygriditemscount(){
        homePage.clickComputersMenu();
        int gridsize = computersPage.getitemscount();
        Assert.assertEquals(gridsize,3,"no. of grid items do not match");
    }

    @Test(priority=2)
    public void clickDesktop(){
        homePage.clickComputersMenu();
        computersPage.clickdesktoplink();
    }

}
