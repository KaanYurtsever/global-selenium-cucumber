package com.global.pages;

import com.global.utilities.BrowserUtils;
import com.global.utilities.ConfigurationReader;
import com.global.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BrowserUtils {
    static WebDriver driver= Driver.get();
    public HomePage() {PageFactory.initElements(Driver.get(), this);}

    //Accept cookies button
    @FindBy(xpath = "//button[@title = 'ACCEPT']")
    public WebElement acceptCookiesBtn;

    //Home page tabs
    public static WebElement wantedTab(String pageName) {
        return driver.findElement(By.xpath("//*[@id= 'menu-main']//a[contains(text(), '" + pageName + "' )]"));
    }

    public void goToUrl(){
        //Goes to the given url
        driver.get(ConfigurationReader.get("url"));
    }

    public void checkTheUrlIsCorrect() {
        //Confirmation of the expected url equals current url
        Assert.assertEquals(ConfigurationReader.get("url"),driver.getCurrentUrl());
    }
    public void acceptCookies(){
        //Accepts cookies
        driver.switchTo().frame(1);
        acceptCookiesBtn.click();
        driver.switchTo().defaultContent();
    }

    public void goToTab(String page){
        wantedTab(page).click();
    }

}
