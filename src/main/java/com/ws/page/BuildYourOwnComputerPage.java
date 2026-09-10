package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BuildYourOwnComputerPage extends DriverScript {

    @FindBy(id = "product_attribute_16_5_4")
    private WebElement processorDropdown;

    @FindBy(id = "product_attribute_16_6_5")
    private WebElement ramDropdown;

    @FindBy(name = "product_attribute_16_3_6")
    private List<WebElement> hddOptions;

    @FindBy(name = "product_attribute_16_4_7")
    private List<WebElement> osOptions;

    @FindBy(name = "product_attribute_16_8_8")
    private List<WebElement> softwareOptions;

    @FindBy(id = "addtocart_16_EnteredQuantity")
    private WebElement quantityInput;

    @FindBy(id = "add-to-cart-button-16")
    private WebElement addToCartButton;

    @FindBy(css = "span.price-value-16")
    private WebElement productPrice;

    public BuildYourOwnComputerPage() {
        PageFactory.initElements(driver, this);
    }

    public void selectProcessor(String processor) {
        new Select(processorDropdown).selectByVisibleText(processor);
    }

    public void selectProcessorByIndex(int index) {
        new Select(processorDropdown).selectByIndex(index);
    }

    public void selectRAM(String ram) {
        new Select(ramDropdown).selectByVisibleText(ram);
    }

    public void selectRAMByIndex(int index) {
        new Select(ramDropdown).selectByIndex(index);
    }

    public void selectHDD(String hddOption) {
        clickOptionByText(hddOptions, hddOption);
    }

    public void selectHDDByIndex(int index) {
        clickOptionByIndex(hddOptions, index);
    }

    public void selectOS(String osOption) {
        clickOptionByText(osOptions, osOption);
    }

    public void selectOSByIndex(int index) {
        clickOptionByIndex(osOptions, index);
    }

    public void selectSoftware(String softwareOption) {
        clickOptionByText(softwareOptions, softwareOption);
    }

    public void selectSoftwareByIndex(int index) {
        clickOptionByIndex(softwareOptions, index);
    }

    public void setQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
    }

    public void clickAddToCart() {
        addToCartButton.click();
    }

    public String getProductPrice() {
        return productPrice.getText().trim();
    }

    public void addToCartWithCustomConfiguration(String processor, String ram, String hdd, String os,
                                                String software, String quantity) {
        selectProcessor(processor);
        selectRAM(ram);
        selectHDD(hdd);
        selectOS(os);
        selectSoftware(software);
        setQuantity(quantity);
        clickAddToCart();
    }

    private void clickOptionByText(List<WebElement> optionList, String optionText) {
        for (WebElement option : optionList) {
            String labelText = option.findElement(By.xpath("following-sibling::label")).getText().trim();
            if (labelText.equalsIgnoreCase(optionText.trim())) {
                option.click();
                return;
            }
        }
        throw new NoSuchElementException("Option not found: " + optionText);
    }

    private void clickOptionByIndex(List<WebElement> optionList, int index) {
        if (index < 0 || index >= optionList.size()) {
            throw new IndexOutOfBoundsException("Option index is out of range: " + index);
        }
        optionList.get(index).click();
    }
}
