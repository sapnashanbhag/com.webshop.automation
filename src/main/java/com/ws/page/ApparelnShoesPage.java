package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class ApparelnShoesPage extends DriverScript {

    @FindBy(name = "products-orderby") private WebElement sortByDropdown;
    @FindBy(xpath = "//h2[@class='product-title']/a") private List<WebElement> productTitleLinks;
    @FindBy(xpath = "//span[@class='price actual-price']") private List<WebElement> productPricesText;
    @FindBy(name = "products-pagesize") private WebElement displayPerPageDropdown;
    @FindBy(xpath = "//div[@class='item-box']") private List<WebElement> productsOnPage;
    @FindBy(xpath = "//div[contains(@class,'product-grid')]") private WebElement productGrid;
    @FindBy(xpath = "//div[contains(@class,'product-list')]") private WebElement productList;
    @FindBy(name = "products-viewmode") private WebElement viewModeDropdown;
    @FindBy(xpath = "//a[contains(text(),'Under')] ") private WebElement underPriceLink;
    @FindBy(xpath = "//a[@class='remove-price-range-filter']") private WebElement removeFilterLink;
    @FindBy(xpath = "//div[@class='pager']//li[contains(@class,'current-page')]") private WebElement currentPage;
    @FindBy(xpath = "//div[@class='pager']//a") private List<WebElement> pagerLinks;

    public ApparelnShoesPage() {
        PageFactory.initElements(driver, this);
    }

    public String getApparelnShoesPageTitle() {
        return driver.getTitle();
    }

    public String getApparelShoesPageTitle() {
        return getApparelnShoesPageTitle();
    }

    public List<WebElement> sortByList() {
        return new Select(sortByDropdown).getOptions();
    }

    public List<WebElement> countSortByOptions() {
        return sortByList();
    }

    public void selectOptionNameAtoZ() {
        new Select(sortByDropdown).selectByVisibleText("Name: A to Z");
    }

    public void selectoptionNamesAtoZ() {
        selectOptionNameAtoZ();
    }

    public void selectOptionNameZtoA() {
        new Select(sortByDropdown).selectByVisibleText("Name: Z to A");
    }

    public void selectoptionNamesZtoA() {
        selectOptionNameZtoA();
    }

    public void selectOptionPriceLowToHigh() {
        new Select(sortByDropdown).selectByVisibleText("Price: Low to High");
    }

    public void selectoptionpriceLowtoHigh() {
        selectOptionPriceLowToHigh();
    }

    public void selectOptionPriceHighToLow() {
        new Select(sortByDropdown).selectByVisibleText("Price: High to Low");
    }

    public void selectoptionpriceHightoLow() {
        selectOptionPriceHighToLow();
    }

    public void selectOptionCreatedOn() {
        new Select(sortByDropdown).selectByVisibleText("Created on");
    }

    public List<String> getProductNames() {
        List<String> names = new ArrayList<>();
        for (WebElement productTitle : productTitleLinks) {
            names.add(productTitle.getText());
        }
        return names;
    }

    public List<Double> getProductPrices() {
        List<Double> prices = new ArrayList<>();
        for (WebElement productPrice : productPricesText) {
            prices.add(Double.parseDouble(productPrice.getText().replace("$", "")));
        }
        return prices;
    }

    public void selectDisplaySize(String size) {
        new Select(displayPerPageDropdown).selectByVisibleText(size);
    }

    public int getDisplayedProductCount() {
        return productsOnPage.size();
    }

    public void selectGridView() {
        new Select(viewModeDropdown).selectByVisibleText("Grid");
    }

    public void selectListView() {
        new Select(viewModeDropdown).selectByVisibleText("List");
    }

    public boolean isGridViewDisplayed() {
        return productGrid.isDisplayed();
    }

    public boolean isListViewDisplayed() {
        return productList.isDisplayed();
    }

    public void underPriceLinkClick() {
        underPriceLink.click();
    }

    public void under25linkClick() {
        underPriceLinkClick();
    }

    public boolean removeFilterLinkIsDisplayed() {
        return removeFilterLink.isDisplayed();
    }

    public boolean removefilterlinkisDisplayed() {
        return removeFilterLinkIsDisplayed();
    }

    public void removeFilterClick() {
        removeFilterLink.click();
    }

    public void removefilterClick() {
        removeFilterClick();
    }

    public boolean isPaginationDisplayed() {
        return !driver.findElements(By.xpath("//div[@class='pager']//a")).isEmpty();
    }

    public int getCurrentPageNumber() {
        String pageText = currentPage.getText().trim();
        return Integer.parseInt(pageText);
    }

    public List<WebElement> getPagerLinks() {
        return pagerLinks;
    }

    public void clickPageNumber(int pageNumber) {
        String xpath = "//div[@class='pager']//a[contains(@href,'pagenumber=" + pageNumber + "')]";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void clickNextPage() {
        driver.findElement(By.xpath("//div[@class='pager']//li[contains(@class,'next-page')]//a")).click();
    }

    public void clickPreviousPage() {
        driver.findElement(By.xpath("//div[@class='pager']//li[contains(@class,'previous-page')]//a")).click();
    }
}
