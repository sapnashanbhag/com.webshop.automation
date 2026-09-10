package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends DriverScript {
    //All Classes will have 3 sections
    //*****Page Elements*****//
    //**********PAge Initilisation*******//
    //***********Page Actions**********/


    //*****Page Elements*****//
    @FindBy(name="products-orderby") private WebElement sortBydropdown;
    @FindBy(xpath="//h2[@class='product-title']/a") private List<WebElement> booknamestext;
    @FindBy(xpath="//span[@class='price actual-price']") private List<WebElement> bookspricetext;
    @FindBy(name="products-pagesize") private WebElement displayperpagedropdown;
    @FindBy(xpath="//div[@class='item-box']") private List<WebElement> booknamesperpagetext;
    @FindBy(xpath="//div[contains(@class,'product-grid')]") private WebElement productgrid;
    @FindBy(xpath="//div[contains(@class,'product-list')]") private WebElement productlist;
    @FindBy(name="products-viewmode") private WebElement viewasdropdown;
    @FindBy(xpath="//a[contains(text(),'Under')] ") private WebElement under25link;
    @FindBy(xpath="//a[@class='remove-price-range-filter']") private WebElement removefilterlink;
    //**********PAge Initilisation*******//
    //PageFactory is a class which is used to initialise page elements also called as lazy initialisation
    //lazy initialisation means only when page is loaded the page elements will get active else elements will be sleepy
    public BooksPage(){
        PageFactory.initElements(driver,this);
    }
    //***********Page Actions**********/
    public String getBooksPageTitle(){
        return driver.getTitle();
    }
    public List<WebElement> sortByList(){
        Select sortByObj =new Select(sortBydropdown);
        List<WebElement> allOptions = sortByObj.getOptions();
        return allOptions;
    }

    public void selectoptionNamesAtoZ(){
        Select sortByOption = new Select(sortBydropdown);
        sortByOption.selectByVisibleText("Name: A to Z");
    }

    public List<String> getBookNames(){
        List<String> booknames = new ArrayList<>();
        for (int i = 0; i < booknamestext.size(); i++) {
            booknames.add(booknamestext.get(i).getText());
        }
        return booknames;
    }

    public void selectoptionNamesZtoA(){
        Select select = new Select(sortBydropdown);
        select.selectByVisibleText("Name: Z to A");
    }

    public void selectoptionpriceLowtoHigh(){
        Select select = new Select(sortBydropdown);
        select.selectByVisibleText("Price: Low to High");
    }

    public void selectoptionpriceHightoLow(){
        Select select = new Select(sortBydropdown);
        select.selectByVisibleText("Price: High to Low");
    }

    public List<Double> getBookPrices(){
        List<Double> bookprices = new ArrayList<>();
        for (int i = 0; i < bookspricetext.size(); i++) {
            String price = bookspricetext.get(i).getText();
            bookprices.add(Double.parseDouble(price));
        }
        return bookprices;
    }
    public void selectDisplaySize(String size) {

        Select select = new Select(displayperpagedropdown);
        select.selectByVisibleText(size);
    }
    public int getDisplayedBookCount() {
        return booknamesperpagetext.size();
    }
    public void selectGridView() {

        Select select =
                new Select(viewasdropdown);

        select.selectByVisibleText("Grid");
    }

    public void selectListView() {

        Select select =
                new Select(viewasdropdown);

        select.selectByVisibleText("List");
    }

    public boolean isGridViewDisplayed() {

        return productgrid.isDisplayed();
    }

    public boolean isListViewDisplayed() {

        return productlist.isDisplayed();
    }
    public void under25linkClick(){
        under25link.click();
    }
    public boolean removefilterlinkisDisplayed(){
        return removefilterlink.isDisplayed();
    }
    public void removefilterClick(){
        removefilterlink.click();
    }



}
