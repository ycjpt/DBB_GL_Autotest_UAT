package com.hsbc.cmb.hk.dbb.glue.supplyChains.tubeByInputting;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.utils.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

import java.util.UUID;

public class creatCustomers_glue {
    @ManagedPages
    public Pages pages;
    IdCardGenerator g = new IdCardGenerator();

    @Steps
    private creatCustomers_step customers_step;
    public static String envTag;
    private BDDUtil bddUtil;

    @When("^login successfully and click the SCF link$")
    public void loginSuccessfullyAndClickTheSCFLink() {
        customers_step.disPlayedSCFTitle();

    }

    @When("^I click Customers and select Onboarding List$")
    public void iClickCustomersAndSelectOnboardingList() {
        customers_step.getClickCustomersMenu();
        customers_step.getClickOnboardingListMenu();
    }

    @And("^I click Create Customer and fill in the buyer information in the pop-up window$")
    public void iClickCreateCustomerAndFillInTheBuyerInformationInThePopUpWindow() {
        customers_step.getClickCreateCustomerBtn();
        customers_step.getSelectCustomerType();
        customers_step.getCustomerTypeValue();
        customers_step.getCompanyName(JRandomNameTool.getStringRandom(12));
        customers_step.getCompanyID(g.generate());
        customers_step.getSelectCountryOfRegistration();
        customers_step.getCountryOfRegistrationValue();
        customers_step.getCompanyNameLeft(JRandomNameTool.getStringRandom(15));
        customers_step.getCLickNextBtn();
    }

    @And("^I click Create Customer and fill in the supplier information in the pop-up window$")
    public void iClickCreateCustomerAndFillInTheSupplierInformationInThePopUpWindow() {
        customers_step.getClickCreateCustomerBtn();
        customers_step.getSelectCustomerType();
        customers_step.getCustomerTypeSupplier();
        customers_step.getCompanyName(JRandomNameTool.getRandomJianHan(9));
        customers_step.getCompanyID(g.generate());
        customers_step.getSelectCountryOfRegistration();
        customers_step.getCountryOfRegistrationValue();
        customers_step.getCompanyNameLeft(JRandomNameTool.getStringRandom(15));
        customers_step.getCLickNextBtn();
    }

    @Then("^Check to see if you jump to the Authorized Person page$")
    public void checkToSeeIfYouJumpToTheAuthorizedPersonPage() {
        customers_step.getCheckNextPage();
    }

    @When("^Fill in email 1 and email 2 supplier information on the Authorized Person page$")
    public void fillInAdministratorAndAdministratorSupplierInformationOnTheAuthorizedPersonPage() {
        String mailName = UUID.randomUUID().toString();
        String mailName1 = UUID.randomUUID().toString();
        customers_step.getFirstNameInput(JRandomNameTool.getStringRandom(8));
        customers_step.getEmailInput(mailName + "@MailTemp.top");
        customers_step.getLastName(JRandomNameTool.getRandomJianHan(4));
        customers_step.getMobileInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.getFirstNameSecondInput(JRandomNameTool.getStringRandom(8));
        customers_step.getEmailSecondInput(mailName1 + "@MailTemp.top");
        customers_step.getLastNameSecondInput(JRandomNameTool.getStringRandom(4));
        customers_step.getMobileSecondInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.clickInputBySelectBox();
        customers_step.clickSubmitBtn();
    }

    @When("^Fill in email 1 and email 2 buyer information on the Authorized Person page$")
    public void fillInAdministratorAndAdministratorBuyerInformationOnTheAuthorizedPersonPage() {
        String mailName = UUID.randomUUID().toString();
        String mailName1 = UUID.randomUUID().toString();
        customers_step.getFirstNameInput(JRandomNameTool.getStringRandom(8));
        customers_step.getEmailInput(mailName + "@MailTemp.top");
        customers_step.getLastName(JRandomNameTool.getRandomJianHan(3));
        customers_step.getMobileInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.getFirstNameSecondInput(JRandomNameTool.getStringRandom(7));
        customers_step.getEmailSecondInput(mailName1 + "@MailTemp.top");
        customers_step.getLastNameSecondInput(JRandomNameTool.getStringRandom(8));
        customers_step.getMobileSecondInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.clickSubmitBtn();
    }

    @Then("^Successfully create buyer customer information$")
    public void successfullyCreateBuyerCustomerInformation() {
        customers_step.checkSuccessPageTitle();
    }

//    @After
//    public void testCase(){
//        System.out.println("--------------------testcase--------------------");
//    }
}
