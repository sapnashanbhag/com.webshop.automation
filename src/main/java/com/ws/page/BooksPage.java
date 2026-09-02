package com.ws.page;

import com.ws.driver.DriverScript;
import org.openqa.selenium.support.PageFactory;

import java.sql.Driver;

import static com.ws.driver.DriverScript.driver;

public class BooksPage extends DriverScript {
    //All Classes will have 3 sections
    //*****Page Elements*****//
    //**********PAge Initilisation*******//
    //***********Page Actions**********/


    //*****Page Elements*****//
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

}
