package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends DriverScript {
    //*****Page Elements*****//
    @FindBy(linkText = "Log in") WebElement loginLink; //@FindBy is coming from selenium
    @FindBy(xpath="(//a[contains(text(),'Books')])[1]") WebElement BooksMenu;
    @FindBy(xpath="(//a[contains(text(),'Gift')])[1]") WebElement GiftCardsMenu;
    //**********PAge Initilisation*******//
    public HomePage()
    {
        PageFactory.initElements(driver,this);
    }
    //***********Page Actions**********/
    public void clickBooksMenu(){
        BooksMenu.click();
    }
    public void clickLoginLink(){
        loginLink.click();
    }
    public void clickGiftCardsMenu(){ GiftCardsMenu.click();}
}
