package com.hsbc.cmb.hk.dbb.glue.supplyChains.tubeByInputting;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class creatCustomers_glue {
    @ManagedPages
    public Pages pages;

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

    @And("^I click Create Customer and fill in the information in the pop-up window$")
    public void iClickCreateCustomerAndFillInTheInformationInThePopUpWindow() {
        customers_step.getClickCreateCustomerBtn();
        customers_step.getSelectCustomerType();
        customers_step.getCustomerTypeValue();
        customers_step.getCompanyName("test case for automation");
        customers_step.getCompanyID("test case for automation");
        customers_step.getSelectCountryOfRegistration();
        customers_step.getCountryOfRegistrationValue();
        customers_step.getCompanyNameLeft("test case for automation");
        customers_step.getCLickNextBtn();
    }
}
