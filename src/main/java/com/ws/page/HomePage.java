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
    @FindBy(xpath="(//a[contains(text(),'Computers')])[1]") private WebElement ComputersMenu;
    @FindBy(xpath = "(//a[contains(text(),'Desktops')])[1]") private WebElement desktopsMenu;
    @FindBy(xpath = "(//a[contains(text(),'Apparel & Shoes')])[1]") private WebElement apparelShoesMenu;
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
    public void clickComputersMenu() {
        ComputersMenu.click();
    }
    public void clickdesktopsMenu(){
        desktopsMenu.click();
    }
    public void clickApparelShoesMenu(){
        apparelShoesMenu.click();
    }
    public void clickApparelnShoesMenu(){
        clickApparelShoesMenu();
    }
}
