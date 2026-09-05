package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GiftCardsPage extends DriverScript {
    //Page Elements
    @FindBy(xpath="//h1[text()='Gift Cards']") private WebElement giftcardstext;
    @FindBy(xpath="//div[@class='product-grid']/div") private List<WebElement> productsCount;
    //Page Initialisation
    public GiftCardsPage(){
        PageFactory.initElements(driver,this);
    }
    //Page methods/actions
    public String getGiftCardsText(){
        return giftcardstext.getText();
    }
    public int getProductsCount(){
        return productsCount.size();
    }
}
