package com.hsbc.cmb.hk.dbb.pages.supplyChains.systemManager;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Set;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.junit.Assert.assertTrue;

public class logon_page extends PageObject {


    @FindBy(xpath = "//div[@class='form-top']/img[@alt='image']")
    public WebElementFacade tips;

    @FindBy(id = "form-username")
    public WebElementFacade userNameInputbox;

    @FindBy(id = "form-password")
    public WebElementFacade passwordInputbox;

    @FindBy(xpath = "//tr[@align='center']//button[@type='submit' ]")
    public WebElementFacade clickLogonBtn;

    @FindBy(xpath = "//p[text()='SCF']")
    public WebElementFacade clickSCFlink;

    public void enterUserName(String userName){
        withTimeoutOf(10,SECONDS)
                .waitFor(userNameInputbox)
                .waitUntilVisible()
                .sendKeys(userName);
    }


    public void enterPassWord(String userName){
        withTimeoutOf(10,SECONDS)
                .waitFor(passwordInputbox)
                .waitUntilVisible()
                .sendKeys(userName);
    }

}
