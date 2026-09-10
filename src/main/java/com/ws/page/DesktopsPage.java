package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;


public class DesktopsPage extends DriverScript {

    @FindBy(name="products-orderby") private WebElement sortbyoptionsdropdown;
    @FindBy(xpath="//div[@class='product-grid']/div") private List<WebElement> desktopsgrid;
    @FindBy(xpath="//h2[@class='product-title']/a") private List<WebElement> desktopsnameslinks;
    @FindBy(xpath="//span[@class='price actual-price']") private List<WebElement> desktoppricestext;
    @FindBy(name="products-pagesize") private WebElement displayperpagedropdown;
    @FindBy(xpath="//div[@class='product-list']/div") private List<WebElement> desktopslist;
    @FindBy(xpath="//div[@class='product-grid']") private WebElement desktopsgridview;
    @FindBy(xpath="//div[@class='product-list']") private List<WebElement> desktopslistview;
    @FindBy(name="products-viewmode") private WebElement desktopsviewmodeGrid;
    @FindBy(xpath="//input[@class='button-2 product-box-add-to-cart-button']") private List<WebElement> addtocartbuttons;

    public DesktopsPage(){
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getAddToCartButtons(){
        return addtocartbuttons;
    }

    public int getAddToCartButtonCount(){
        return addtocartbuttons.size();
    }

    public void clickAddToCartButton(int productIndex){
        if (productIndex < 0 || productIndex >= addtocartbuttons.size()) {
            throw new IndexOutOfBoundsException("Product index is out of range: " + productIndex);
        }
        addtocartbuttons.get(productIndex).click();
    }

    public void clickAddToCartButtonForProduct(String productName){
        for (int i = 0; i < desktopsnameslinks.size(); i++) {
            if (desktopsnameslinks.get(i).getText().equalsIgnoreCase(productName.trim())) {
                if (i < addtocartbuttons.size()) {
                    addtocartbuttons.get(i).click();
                    return;
                }
            }
        }
        throw new NoSuchElementException("Product not found: " + productName);
    }

    public void addAllProductsToCart(){
        for (WebElement addToCartButton : addtocartbuttons) {
            addToCartButton.click();
        }
    }
    public void selectViewasGrid(){
        Select select = new Select(desktopsviewmodeGrid);
        select.selectByVisibleText("Grid");
    }
    public void selectViewasList(){
        Select select = new Select(desktopsviewmodeGrid);
        select.selectByVisibleText("List");
    }
    public boolean desktopsgridviewIsDisplayed(){
        return desktopsgridview.isDisplayed();
    }
    public int displaygridperpageCount(){
       return desktopsgrid.size();
    }
    public int displaylistperpageCount(){
        return desktopslist.size();
    }
    public void selectDisplayperpage(String count){
        Select select = new Select(displayperpagedropdown);
        select.selectByVisibleText(count);
    }
    public String getDesktopPageTitle(){
        return driver.getTitle();
    }
    public List<WebElement> countSortByOptions(){
        Select select = new Select(sortbyoptionsdropdown);
        return select.getOptions();
    }
    public void selectoptionNameAtoZ(){
        Select select = new Select(sortbyoptionsdropdown);
        select.selectByVisibleText("Name: A to Z");
    }
    public void selectoptionPriceLowtoHigh(){
        Select select = new Select(sortbyoptionsdropdown);
        select.selectByVisibleText("Price: Low to High");
    }
    public List<String> getdesktopNames(){
        List<String> desktopnameslist = new ArrayList<>();
        for (int i = 0; i < desktopsnameslinks.size(); i++) {
            desktopnameslist.add(desktopsnameslinks.get(i).getText());
        }
        return desktopnameslist;
    }

    public List<Double> getdesktopPrices(){
        List<Double> desktoppriceslist = new ArrayList<>();
        for (int i = 0; i < desktoppricestext.size(); i++) {
            desktoppriceslist.add(Double.parseDouble(desktoppricestext.get(i).getText()));
        }
        return desktoppriceslist;
    }
}
