package com.hsbc.cmb.hk.dbb.glue.supplyChains;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
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
        customers_step.getClickCustomersMenu();
        customers_step.getClickOnboardingListMenu();
        customers_step.getClickCreateCustomerBtn();
    }
}
