package com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting;

import com.hsbc.cmb.hk.dbb.glue.supplyChains.tubeByInputting.creatCustomers_glue;
import com.hsbc.cmb.hk.dbb.pages.supplyChains.tubeByInputting.creatCustomers_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import com.hsbc.cmb.hk.dbb.utils.CommonUtil;
import com.hsbc.cmb.hk.dbb.utils.JRandomNameTool;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

import static com.hsbc.cmb.hk.dbb.utils.AssertLocal.assertTrue;
import static org.junit.Assert.assertEquals;

public class creatCustomers_step extends ScenarioSteps {
    private creatCustomers_page customers_page;
    private BDDUtil bddUtil;
    public static String envTag;

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
        customers_page.customerTypeBuyer.click();
    }

    @Step
    public void getCustomerTypeSupplier(){
        customers_page.customerTypeSupplier.click();
    }

    @Step
    public void checkSuccessPageTitle(){
        assertEquals("Customer Profiles",customers_page.checkSuccessPageTitle.getText());
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
    public void getCheckNextPage(){
        assertEquals("Administrator 1",customers_page.checkNextPage.getText());
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
        customers_page.emailSecondInput.sendKeys(value);
    }

    @Step
    public void getLastNameSecondInput(String value){
        customers_page.lastNameSecondInput.sendKeys(value);
    }

    @Step
    public void getMobileSecondInput(String value){
        customers_page.mobileSecondInput.sendKeys(value);
    }

    @Step
    public void clickSubmitBtn(){
        customers_page.submitBtn.click();
    }

    @Step
    public void emailOperation(String value){
        customers_page.sendEmail.clear();
        customers_page.sendEmail.sendKeys(value);
        customers_page.createEmailButton.click();
    }

    @Step
    public void openEmailUrl(){
        JavascriptExecutor webdriver = (JavascriptExecutor)getDriver();
        webdriver.executeScript("window.open(\"https://mailtemp.top/\");");
    }

    @Step
    public void clickInputBySelectBox(){
        customers_page.clickInputBySelectBox.click();
        customers_page.inputByTypeCustomer.click();
    }

    @Step
    public void clickSendEmailBtn(){
        bddUtil.sleep(5);
        customers_page.emailIcon.click();
        customers_page.confirmBtn.click();
    }

    @Step
    public void checkSendEmailSuccess(){
        assertEquals("Green Link Digital Bank - Invitation",customers_page.firstEmail.getText());
    }

    @Step
    public void viewEmail(){
        bddUtil.switchToNewWindow();
        customers_page.firstEmail.click();
    }
}
