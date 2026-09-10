package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComputersPage extends DriverScript {
    @FindBy(xpath="//div[@class='sub-category-grid']/div") private List<WebElement> computeritemsgrid;
    @FindBy(xpath="(//a[contains(text(),'Desktops')])[4]") private WebElement desktoplink;
    @FindBy(xpath="(//a[contains(text(),'Notebooks')])[4]") private WebElement notebookslink;
    @FindBy(xpath="(//a[contains(text(),'Accessories')])[4]") private WebElement accessorieslink;
    public ComputersPage(){
        PageFactory.initElements(driver,this);
    }

    public int getitemscount(){
        return computeritemsgrid.size();
    }
    public void clickdesktoplink(){
        desktoplink.click();
    }
    public void clicknotebookslink(){
        notebookslink.click();
    }
    public void clickaccessorieslink(){
        accessorieslink.click();
    }
}
