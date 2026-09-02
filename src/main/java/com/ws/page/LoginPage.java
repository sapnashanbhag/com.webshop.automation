package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverScript {
 //**************Page Elements************************//
        @FindBy(id="Email")  private WebElement emailtextbox; //private since it belongs to login page only
        @FindBy(name="Password") private WebElement passwordtextbox;
        @FindBy(xpath = "//input[@class = 'button-1 login-button']") private WebElement loginbutton;
        @FindBy(linkText = "Forgot password?") private WebElement forgotpasswordlink;
        @FindBy(linkText = "Log out") private WebElement logoutlink;
        @FindBy(xpath="(//a[@class='account'])[1]") private WebElement userloggedin;
        @FindBy(xpath = "//li[text()='No customer account found']") private WebElement noCustomerFoundtext;
        @FindBy(xpath="//li[text()='The credentials provided are incorrect']") private WebElement incorrectCredentialsText;
        @FindBy(xpath = "//a[text()='Log out']") private WebElement islogoutlinkdisplayed;
        //********PAge Initialisation******************//
        public LoginPage(){
            PageFactory.initElements(driver,this);
        }

        //************Page Methods/Actions****************//

        public String IncorrectCredentialsText(){
            return incorrectCredentialsText.getText();
        }
        public void enterEmail(String emailID){
            emailtextbox.sendKeys(emailID);
        }
        public void enterPassword(String password){
            passwordtextbox.sendKeys(password);
        }
        public void clickLoginButton(){
            loginbutton.click();
        }
        public boolean isForgotPaswdLinkDisplayed() {
            return forgotpasswordlink.isDisplayed();
        }
        public void clicklogoutlink(){
            logoutlink.click();
        }
        public String getUserloggedinText(){
            return userloggedin.getText();
        }
        public String noCustomerFoundText()
        {
            return noCustomerFoundtext.getText();
        }
        public boolean islogoutlinkdisplayed()
        {
            System.out.println("Logout link displayed"+islogoutlinkdisplayed.isDisplayed());
            return islogoutlinkdisplayed.isDisplayed();
        }

}
