package com.hsbc.cmb.hk.dbb.pages.systemManagement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static com.hsbc.cmb.hk.dbb.glue.systemManagement.createAdminUser_glue.getRandom;

public class createAdminUser_page extends PageObject {
    String code = getRandom();

    @FindBy(xpath = "//span[text()='More']")
    public WebElementFacade clickMore;

    @FindBy(xpath = "//div[text()='Setting']")
    public WebElementFacade clickSetting;

    @FindBy(xpath = "//span[text()=\"Admin Users\"]")
    public WebElementFacade clickAdminusers;

    @FindBy(xpath = "//button[@class=\"lls-button lls-button--primary lls-design-btn btn-font-weight\"]")
    public WebElementFacade clickcreateAdminuser;

    @FindBy(xpath = "//div[@data-key=\"f3o0k01u\"]//input")
    public WebElementFacade userName;

    @FindBy(xpath = "//div[@data-key=\"f3afck9p\"]//input")
    public WebElementFacade eMail;

    @FindBy(xpath = "//div[@data-key=\"f1k4a2ng\"]//input")
    public WebElementFacade userNo;

    @FindBy(xpath = "//div[@data-key='f2ncv1jl']//button")
    public WebElementFacade clickConfirm;

}
