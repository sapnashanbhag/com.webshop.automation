package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuildYourOwnCheapComputerPage extends DriverScript {
    @FindBy(xpath="//h1[contains(text(),'Build your own cheap computer')]") private WebElement buildYourOwnCheapComputerText;
    @FindBy(name="product_attribute_72_5_18") private List<WebElement> processorradiobuttons;
    @FindBy(name="product_attribute_72_6_19") private List<WebElement> ramradiobuttons;
    @FindBy(name="product_attribute_72_3_20") private List <WebElement> hddradiobuttons;
    @FindBy(name="product_attribute_72_8_30") private List<WebElement> softwarecheckboxes;
    @FindBy(xpath="//span[@class='price-value-72']") private WebElement productPrice;
    @FindBy(id="addtocart_72_EnteredQuantity") private WebElement quantitytextbox;
    @FindBy(xpath="//input[@class='button-1 add-to-cart-button']") private WebElement addToCartButton;

    public BuildYourOwnCheapComputerPage(){
        // Initialize WebElements
        PageFactory.initElements(driver, this);
    }

    public void verifyBuildYourOwnCheapComputerText(){
        buildYourOwnCheapComputerText.isDisplayed();
    }
    public int getProcessorradiobuttonsCount(){
        return processorradiobuttons.size();
    }
    public int getRamradiobuttonsCount(){
        return ramradiobuttons.size();
    }
    public int getHddradiobuttonsCount(){
        return hddradiobuttons.size();
    }
    public int getSoftwarecheckboxesCount(){
        return softwarecheckboxes.size();
    }
    public void selectProcessorByIndex(int index){
        processorradiobuttons.get(index).click();
    }
    public void selectRAMByIndex(int index) {
        ramradiobuttons.get(index).click();
    }
    public void selectHDDByIndex(int index) {
        hddradiobuttons.get(index).click();
    }
    public void selectSoftwareByIndex(int index) {
        softwarecheckboxes.get(index).click();
    }
    public String getProductPrice(){
        return productPrice.getText();
    }
    public void setQuantity(String quantity) {
        quantitytextbox.clear();
        quantitytextbox.sendKeys(quantity);
    }
    public void selectProcessorByValue(String value) {
        for (WebElement radioButton : processorradiobuttons) {
            System.out.println("Processor text: " + radioButton.getText() + ", value: " + radioButton.getAttribute("value"));
            if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
                radioButton.click();
                return;
            }
        }
        throw new IllegalArgumentException("Processor with value " + value + " not found.");
    }
    public void selectRAMByValue(String value) {
        for (WebElement radioButton : ramradiobuttons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
                radioButton.click();
                return;
            }
        }
        throw new IllegalArgumentException("RAM with value " + value + " not found.");
    }
    public void selectHDDByValue(String value) {
        for (WebElement radioButton : hddradiobuttons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(value)) {
                radioButton.click();
                return;
            }
        }
        throw new IllegalArgumentException("HDD with value " + value + " not found.");
    }
    public void selectSoftwareByValue(String value) {
        for (WebElement checkbox : softwarecheckboxes) {
            if (checkbox.getAttribute("value").equalsIgnoreCase(value)) {
                checkbox.click();
                return;
            }
        }
    }
    public void clickAddToCart() {
        addToCartButton.click();
    }
}
