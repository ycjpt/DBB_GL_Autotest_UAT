package com.hsbc.cmb.hk.dbb.glue.supplyChains.creditFile;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.creditFile.createBuyerCreditFileReview_step;
import com.hsbc.cmb.hk.dbb.steps.supplyChains.creditFile.createBuyerCreditFile_step;
import com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager.logon_step;
import com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class createBuyerCreditFileReview_glue {

    @Steps
    private creatCustomers_step customers_step;
    @Steps
    private logon_step login_uso_step;
    @Steps
    private BDDUtil bddUtil;
    @Steps
    private createBuyerCreditFile_step createBuyerCreditFile_step;
    @Steps
    private createBuyerCreditFileReview_step createBuyerCreditFileReview_step;
    public static String envTag;

    @And("^to Buyer Credit Profile Review page$")
    public void toBuyerCreditProfileReviewPage(){
        customers_step.getClickCustomersMenu();
        createBuyerCreditFileReview_step.clickBuyerCreditFileReview();
    }

    @Then("^buyer Credit Profile L1 Review$")
    public void buyerCreditProfileL1Review(){
        createBuyerCreditFileReview_step.buyerCreditFileL1Review();
    }

    @And("^change user To L2 Review$")
    public void changeUserToL2Review(){
        createBuyerCreditFileReview_step.changeUserToL2Review();
    }

    @Then("^login \"([^\"]*)\" on tube by inputting system$")
    public void loginL2User(String envName){
        envTag = envName;
        if (!envName.isEmpty()) {
            login_uso_step.enter_username_into_box(envName);
            login_uso_step.enter_password_into_box(envName);
            login_uso_step.click_login_btn();
            login_uso_step.getClickSCFlink();
            bddUtil.switchToNewWindow();
        }
    }

    @And("^use UserL2 to Review$")
    public void useUserL2ToReview(){
        customers_step.getClickCustomersMenu();
        createBuyerCreditFileReview_step.clickBuyerCreditFileReview();
        createBuyerCreditFileReview_step.buyerCreditFileL1Review();
        customers_step.getClickCustomersMenu();
        createBuyerCreditFile_step.clickBuyerCreditProfileList();
        bddUtil.sleep(10);
    }

}
