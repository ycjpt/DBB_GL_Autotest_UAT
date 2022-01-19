package com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.creatCustomers_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class creatCustomers_step extends ScenarioSteps {
    private creatCustomers_page customers_page;
    private BDDUtil bddUtil;

    @Step
    public void getClickCustomersMenu(){
        customers_page.clickCustomersMenu.click();
    }

    public void getClickOnboardingListMenu(){
        customers_page.clickOnboardingListMenu.click();
    }

    public void getClickCreateCustomerBtn(){
        customers_page.clickCreateCustomerBtn.click();
    }

    @Step
    public void disPlayedSCFTitle(){
        if (customers_page.scfTitle.isDisplayed()){
            System.out.println("成功进入CSF页面");
        }
    }

    @Step
    public void getSelectCustomerType(){
        customers_page.selectCustomerType.click();
    }
    
    @Step
    public void getCustomerTypeValue(){
        customers_page.customerTypeValue.click();
    }

    @Step
    public void getCompanyName(String value){
        customers_page.companyName.sendKeys(value);
    }

    @Step
    public void getCompanyID(String value){
        customers_page.companyID.sendKeys(value);
    }

    @Step
    public void getSelectCountryOfRegistration(){
        customers_page.selectCountryOfRegistration.click();
    }

    @Step
    public void getCountryOfRegistrationValue(){
        bddUtil.scrollWindowToElement(customers_page.countryOfRegistrationValue);
        customers_page.countryOfRegistrationValue.click();
    }

    @Step
    public void getCompanyNameLeft(String value){
        customers_page.companyNameLeft.sendKeys(value);
    }

    @Step
    public void getCLickNextBtn(){
        customers_page.nextBtn.click();
    }

    @Step
    public void getFirstNameInput(String value){
        customers_page.firstNameInput.sendKeys(value);
    }

    @Step
    public void getEmailInput(String value){
        customers_page.emailInput.sendKeys(value);
    }

    @Step
    public void getLastName(String value){
        customers_page.lastNameInput.sendKeys(value);
    }

    @Step
    public void getMobileInput(String value){
        customers_page.mobileInput.sendKeys(value);
    }

    @Step
    public void getFirstNameSecondInput(String value){
        customers_page.firstNameSecondInput.sendKeys(value);
    }

    @Step
    public void getEmailSecondInput(String value){
        customers_page.mobileSecondInput.sendKeys(value);
    }

    @Step
    public void getLastNameSecondInput(String value){
        customers_page.lastNameSecondInput.sendKeys(value);
    }

    @Step
    public void getMobileSecondInput(String value){
        customers_page.mobileSecondInput.sendKeys(value);
    }

}
