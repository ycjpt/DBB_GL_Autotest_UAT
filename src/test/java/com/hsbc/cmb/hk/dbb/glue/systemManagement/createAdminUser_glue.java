package com.hsbc.cmb.hk.dbb.glue.systemManagement;

import com.hsbc.cmb.hk.dbb.steps.CBSOnline.logon_step;
import com.hsbc.cmb.hk.dbb.steps.supplyChains.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.steps.systemManagement.createAdminUsers_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class createAdminUser_glue {
    @ManagedPages
    public Pages pages;

    @Steps
    private logon_step logon_steps;
    private creatCustomers_step customers_step;
    private createAdminUsers_step createAdminUsers_step;
    private BDDUtil bddUtil;
    public static String envTag;


    @When("^login successfully and click the SCF link to createAdminUser$")
    public void loginSuccessfullyAndClickTheSCFLinkToCreteAdminUser() {

        createAdminUsers_step.create_Admin_User();
        bddUtil.sleep(2000);
    }



/*
    @Given("^logon \"([^\"]*)\" GLbank page$")
    public void logon_custom_portal(String envName) {
        envTag = envName;
        if(!envName.isEmpty()) {
            logon_steps.open_the_first_dbb_logon_page(envName);
//            logon_steps.click_login_to_my_profile_button();
//            logon_steps.enter_username_into_box(envName);
//            logon_steps.input_password_and_security_code(envName);
//            logon_steps.click_logon_button();
        }
    }
 */


}
