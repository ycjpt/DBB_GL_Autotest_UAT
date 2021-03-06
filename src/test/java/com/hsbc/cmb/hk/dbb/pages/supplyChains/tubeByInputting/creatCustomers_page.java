package com.hsbc.cmb.hk.dbb.pages.supplyChains.tubeByInputting;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;

public class creatCustomers_page extends PageObject {

    @FindBy(xpath = "//span[text()='Customers']")
    public WebElementFacade clickCustomersMenu;

    @FindBy(xpath = "//div[@class='name']")
    public WebElementFacade scfTitle;

    @FindBy(xpath = "//span[text()='Onboarding List']")
    public WebElementFacade clickOnboardingListMenu;

    @FindBy(xpath = "//div[@class='btn-container flex-end']/div/button")
    public WebElementFacade clickCreateCustomerBtn;

    @FindBy(xpath = "//div[@class='dialog_create_container']/div[@class='dialog_create_item'][1]//span[@class='lls-input__suffix-inner']")
    public WebElementFacade selectCustomerType;

    @FindBy(xpath = "//body[@class='el-popup-parent--hidden']/div[4]//span[text()='Buyer']")
    public WebElementFacade customerTypeBuyer;

    @FindBy(xpath = "//span[text()='Supplier']")
    public WebElementFacade customerTypeSupplier;

    @FindBy(xpath = "//label[@for='custEnglishName']/following-sibling::div//input")
    public WebElementFacade companyName;

    @FindBy(xpath = "//label[@for='companyId']/following-sibling::div//input")
    public WebElementFacade companyID;

    @FindBy(xpath = "//label[@for='registryCountry']/following-sibling::div//input/following-sibling::span")
    public WebElementFacade selectCountryOfRegistration;

    @FindBy(xpath = "//body[@class='el-popup-parent--hidden']/div[5]//ul//span[text()='China']")
    public WebElementFacade countryOfRegistrationValue;

    @FindBy(xpath = "//label[@for='custName']/following-sibling::div//input")
    public WebElementFacade companyNameLeft;

    @FindBy(xpath = "//div[@class='form_btn_bottom']//span[contains(text(), 'Next')]")
    public WebElementFacade nextBtn;

    @FindBy(xpath = "//div[@class='form_btn_bottom']//span[contains(text(), 'Previous ')]")
    public WebElementFacade previousBtn;

    @FindBy(xpath = "//span[text()='Administrator 1 ']")
    public WebElementFacade checkNextPage;

    @FindBy(xpath = "//label[@for='authorOne.firstName']/following-sibling::div//input")
    public WebElementFacade firstNameInput;

    @FindBy(xpath = "//label[@for='authorOne.email']/following-sibling::div//input")
    public WebElementFacade emailInput;

    @FindBy(xpath = "//label[@for='authorOne.lastName']/following-sibling::div//input")
    public WebElementFacade lastNameInput;

    @FindBy(xpath = "//label[@for='authorOne.mobile']/following-sibling::div//input")
    public WebElementFacade mobileInput;

    @FindBy(xpath = "//label[@for='authorTwo.firstName']/following-sibling::div//input")
    public WebElementFacade firstNameSecondInput;

    @FindBy(xpath = "//label[@for='authorTwo.email']/following-sibling::div//input")
    public WebElementFacade emailSecondInput;

    @FindBy(xpath = "//label[@for='authorTwo.lastName']/following-sibling::div//input")
    public WebElementFacade lastNameSecondInput;

    @FindBy(xpath = "//label[@for='authorTwo.mobile']/following-sibling::div//input")
    public WebElementFacade mobileSecondInput;

    @FindBy(xpath = "//span[text()='Submit ']")
    public WebElementFacade submitBtn;

    @FindBy(xpath = "//span[text()='Customer Profiles']")
    public WebElementFacade checkSuccessPageTitle;

    @FindBy(xpath = "//label[@for='autoCustBuild']/following-sibling::div//span[@class='lls-input__suffix-inner']")
    public WebElementFacade clickInputBySelectBox;

    @FindBy(xpath = "//span[text()='Customer']")
    public WebElementFacade inputByTypeCustomer;

    @FindBy(xpath = "//span[text()='Operator']")
    public WebElementFacade inputByTypeOperator;

    @FindBy(xpath = "//form[@class='form-inline']//input")
    public WebElementFacade sendEmail;

    @FindBy(xpath = "//form[@class='form-inline']//button")
    public WebElementFacade createEmailButton;

    @FindBy(xpath = "//td[@data-key='f38u3atf']")
    public List<WebElementFacade> authPerson;

    @FindBy(xpath = "//div[@class='lowcode-table default-theme']//table[@class='fixed-right-table']/tbody/tr[1]//i[@class='lls-tooltip lls-icon-send-mail']")
    public WebElementFacade emailIcon;

    @FindBy(xpath = "//div[@class='lls-message-box__wrapper']//span[contains(text(), 'Confirm')]")
    public WebElementFacade confirmBtn;

    @FindBy(xpath = "//span[text()='Green Link Digital Bank - Invitation']")
    public WebElementFacade firstEmail;

    @FindBy(xpath = "//span[text()='Green Link Digital Bank - Verify Identity']")
    public WebElementFacade secondEmail;
}
