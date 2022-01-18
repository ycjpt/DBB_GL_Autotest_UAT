package com.hsbc.cmb.hk.dbb.pages.CBSOnline;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class logon_page extends PageObject {

    @FindBy(xpath = "//label[@for='custNo']/following-sibling::div//input")
    public WebElementFacade userid;

    @FindBy(xpath = "//label[@for='loginId']/following-sibling::div//input")
    public WebElementFacade loginid;

    @FindBy(xpath = "//label[@for='passwd']/following-sibling::div//input")
    public WebElementFacade password;

    @FindBy(xpath = "//div[@class='el-row']/following-sibling::div/div")
    public WebElementFacade confirmBtn;

    @FindBy(xpath = "//div[@class='demo-tips']//div[@class='ui-button-inner']")
    public WebElementFacade clickNextBtn;

    @FindBy(xpath = "//div[@class='codebox']/span[1]")
    public WebElementFacade codebox;
}
