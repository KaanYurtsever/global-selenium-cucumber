package com.global.step_definitions;

import com.global.pages.GlobalPlayerPage;
import com.global.pages.HomePage;
import com.global.pages.ContactPage;
import io.cucumber.java.en.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class GlobalStepDef {

    HomePage homePage = new HomePage();
    ContactPage contactPage =new ContactPage();
    GlobalPlayerPage globalPlayerPage = new GlobalPlayerPage();


    @Given("User opens the browser and goes to the home page")
    public void userOpensTheBrowserAndGoesToTheHomePage() {
        homePage.goToUrl();
        homePage.checkTheUrlIsCorrect();
        homePage.acceptCookies();
        
    }

    @When("User goes to the {string} page")
    public void userGoesToThePage(String page) {
        homePage.goToTab(page);
    }

    @Then("User fills expected fields to request a call back")
    public void userFillsExpectedFieldsToRequestACallBack(List<Map<String, String>> elementList) throws AWTException {
        contactPage.checkContactPageIsOpen();
        contactPage.goDown();
        Map<String, String> parameters = elementList.get(0);
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            contactPage.fillFieldsToRequestACallBack(entry.getKey(), entry.getValue()).run();
        }
    }

    @And("User {string} see successfull message")
    public void userSeeSuccessfullMessage(String condition) {
        contactPage.clickSendMessage();
        contactPage.checkMessageForRequest(condition);

    }

    @And("User opens {int} global radio")
    public void userOpensAGlobalRadio(int radio) throws AWTException {
        globalPlayerPage.goDown();
        globalPlayerPage.goToRadio(radio);
    }

    @When("User is tab {int}")
    public void userIsTab(int tabNo) {
        globalPlayerPage.setSwitchPage(tabNo);
    }

    @Then("User should see global radio is open")
    public void userShouldSeeGlobalRadioIsOpen() {
        globalPlayerPage.closeWindow();
        globalPlayerPage.checkGlobalRadioIsOpen();
    }
}
