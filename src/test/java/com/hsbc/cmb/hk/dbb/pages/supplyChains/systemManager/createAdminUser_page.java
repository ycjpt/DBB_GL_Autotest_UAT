package com.hsbc.cmb.hk.dbb.pages.supplyChains.systemManager;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager.createAdminUsers_step;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class createAdminUser_page extends PageObject {

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
    public WebElementFacade clickConfirm_Create;

    @FindBy(xpath = "//td[@title=\"1\"]/following-sibling::td[@data-key=\"f2io398b\"]//i[@class=\"lls-tooltip lls-icon-share\"]")
    public WebElementFacade clickAuthoritySetting;

    @FindBy(xpath = "//div[@class=\"tf-item\"]//div[@class=\"lls-cb-outdot\"]")
    public WebElementFacade clickPermissionMenu;

    @FindBy(xpath = "//div[@class=\"lls-tf-btn lls-tf-right lls-tf-rightact\"]")
    public WebElementFacade clickImportMenu;

    @FindBy(xpath = "//span[text()='Confirm']")
    public WebElementFacade clickConfirm_Update;
}
