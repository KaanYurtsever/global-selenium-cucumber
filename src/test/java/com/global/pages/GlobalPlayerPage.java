package com.global.pages;

import com.global.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class GlobalPlayerPage extends HomePage {

    static WebDriver driver = Driver.get();

    @FindBy(xpath = "//img[contains(@class, 'banner__arrow')]")
    public WebElement bannerArrow;

    @FindBy(xpath = "//div[contains(@class,'grid grid--stations')]")
    public List<WebElement> radios;

    public static WebElement radio(int radioNumber) {
        return driver.findElement(By.xpath("(//div[@class='grid__item'])[" + radioNumber + "]"));
    }

    public static WebElement listenLiveBtn(int radioNumber) {
        return driver.findElement(By.xpath("(//div[@class='grid__item'])[" + radioNumber + "]//span"));
    }

    @FindBy(xpath = "//div[contains(@class , 'containerImage')]//span[@title='Close Menu']")
    public WebElement closeWindowBtn;

    @FindBy(xpath = "//div[contains(@class , 'playerControls')]//button[@title='Play']")
    public WebElement playBtn;

    public void goDown() throws AWTException {
        bannerArrow.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    }

    public void goToRadio(int radioNumber){
        hover(radio(radioNumber));
        listenLiveBtn(radioNumber).click();
    }

    public void setSwitchPage(int tabNo) {
        switchTab(tabNo);
    }

    public void closeWindow() {
        closeWindowBtn.click();
    }

    public void checkGlobalRadioIsOpen() {
        Assert.assertTrue(playBtn.isDisplayed());
    }


}
