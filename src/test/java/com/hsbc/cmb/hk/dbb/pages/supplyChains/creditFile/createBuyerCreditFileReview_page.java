package com.hsbc.cmb.hk.dbb.pages.supplyChains.creditFile;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class createBuyerCreditFileReview_page extends PageObject{

    @FindBy(xpath = "//div[@class=\"lls-submenu__content\"]//div[@class=\"lls-menu-item\"]//span[text()=\"Buyer Credit Profile Review\"]")
    public WebElementFacade clickBuyerCreditProfileReview;

    @FindBy(xpath = "//td[text()=\"1\"]/following-sibling::td//div/span")
    public WebElementFacade clickAssignToMe;

    @FindBy(id="tab-1")
    public WebElementFacade clickAssignToMePage;

    @FindBy(xpath = "//td[text()=\"1\"]/following-sibling::td//div/span")
    public WebElementFacade clickProceedToL2;

    @FindBy(xpath = "//label[text()=\"Result\"]/following-sibling::div//input")
    public WebElementFacade getL1Result;

    @FindBy(xpath = "//span[text()=\"Approve\"]")
    public WebElementFacade getL1Approve;

    @FindBy(xpath = "//textarea")
    public WebElementFacade getL1Comments;

    @FindBy(xpath = "//button[@class=\"lls-button btn-item lls-button--primary\"]")
    public WebElementFacade clickSubmitToL2;

    @FindBy(xpath = "//div[@class=\"lls-dropdown\"]")
    public WebElementFacade clickUserToLogOut;

    @FindBy(xpath = "//button[@class=\"lls-button lls-button--text\"]")
    public WebElementFacade clickLogOutToChangeUser;

    @FindBy(xpath = "//td[@class=\"menu-col-icon icon-logout\"]/following-sibling::td[@class=\"menu-col-text ng-binding\"]")
    public WebElementFacade clickCancel;

    @FindBy(xpath = "//button[@class=\"btn btn-danger ng-binding\"]")
    public WebElementFacade clickGoOn;
}
