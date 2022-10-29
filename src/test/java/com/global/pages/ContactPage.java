package com.global.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class ContactPage extends HomePage {

    //Contact page title
    @FindBy(css = ".title--banner.js-fade-in-up.visible")
    public WebElement contactTitle;

    @FindBy(xpath = "//img[contains(@class, 'banner__arrow')]")
    public WebElement bannerArrow;

    //First name field
    @FindBy(xpath = "//span[@class = 'name_first']//input")
    public WebElement fnameField;

    //Last name field
    @FindBy(xpath = "//span[@class = 'name_last']//input")
    public WebElement lnameField;

    //Organisation field
    @FindBy(xpath = "//label[contains(text(), 'Organisation')]//..//input")
    public WebElement organisationField;

    //City field
    @FindBy(xpath = "//label[contains(text(), 'City')]//..//input")
    public WebElement cityField;

    //Postcode field
    @FindBy(xpath = "//label[contains(text(), 'Postcode')]//..//input")
    public WebElement postcodeField;

    //Phone field
    @FindBy(xpath = "//label[contains(text(), 'Phone')]//..//input")
    public WebElement phoneField;

    //Email field
    @FindBy(xpath = "//label[contains(text(), 'Email')]//..//input")
    public WebElement emailField;

    //Enquiry field
    @FindBy(xpath = "//label[contains(text(), 'Enquiry')]//..//textarea")
    public WebElement enquiryField;

    //Consent checkbox
    @FindBy(xpath = "//label[contains(text(), 'Consent')]//..//input[@type='checkbox']")
    public WebElement consentCheckbox;

    //Failed message for consent is unchecked
    @FindBy(xpath = "//label[contains(text(), 'Consent')]//..//div[contains(@id, 'validation_message')]")
    public WebElement failedMessageForConsent;

    //Send message button
    @FindBy(css = "input[type='submit']")
    public WebElement sendMessageBtn;

    public static final String expectedContactPageTitle = "contact";

    public static final String expectedFailedMessageForConsent = "This field is required.";


    public void checkContactPageIsOpen() {
        //Confirmation of the expected page is open
        Assert.assertEquals("Contact page didn't open.", expectedContactPageTitle, contactTitle.getText());
    }

    public void goDown() throws AWTException {
        bannerArrow.click();
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    }

    public Runnable fillFieldsToRequestACallBack(String key, String value) {

        Map<String, Runnable> hashMap = new HashMap<>();
        hashMap.put("First Name", () -> fillFirstNameField(value));
        hashMap.put("Last Name", () -> fillLastNameField(value));
        hashMap.put("Organisation", () -> fillOrganisationField(value));
        hashMap.put("City", () -> fillCityField(value));
        hashMap.put("Postcode", () -> fillPostcodeField(value));
        hashMap.put("Phone", () -> fillPhoneField(value));
        hashMap.put("Email", () -> fillEmailField(value));
        hashMap.put("Enquiry", () -> fillEnquiryField(value));
        return hashMap.get(key);
    }

    private ContactPage fillFirstNameField(String firstName){
        fnameField.sendKeys(firstName);
        return this;
    }

    private ContactPage fillLastNameField(String lastName){
        lnameField.sendKeys(lastName);
        return this;
    }

    private ContactPage fillOrganisationField(String organisationName){
        organisationField.sendKeys(organisationName);
        return this;
    }

    private ContactPage fillCityField(String cityName){
        cityField.sendKeys(cityName);
        return this;
    }

    private ContactPage fillPostcodeField(String postcode){
        postcodeField.sendKeys(postcode);
        return this;
    }

    private ContactPage fillPhoneField(String phone){
        phoneField.sendKeys(phone);
        return this;
    }

    private ContactPage fillEmailField(String email){
        emailField.sendKeys(email);
        return this;
    }

    private ContactPage fillEnquiryField(String enquiry){
        enquiryField.sendKeys(enquiry);
        return this;
    }

    public void checkMessageForRequest(String condition) {
        if (condition.equals("should")) {
            consentCheckbox.click();
        } else {
            waitForVisibility(failedMessageForConsent, 5);
            Assert.assertEquals("User checked consent checkbox.", expectedFailedMessageForConsent, failedMessageForConsent.getText());
        }
    }

    public void clickSendMessage() {
        hover(sendMessageBtn);
        sendMessageBtn.click();
    }

}
