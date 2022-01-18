package com.hsbc.cmb.hk.dbb.glue.CBSOnline;

import com.hsbc.cmb.hk.dbb.steps.CBSOnline.logon_step;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class logon_glue {
    @ManagedPages
    public Pages pages;

    @Steps
    private logon_step logon_steps;
    public static String envTag;

    @Given("^logon \"([^\"]*)\" onboarding custom portal$")
    public void logon_onboarding_custom_portal(String envName) {
        envTag = envName;
        if (!envName.isEmpty()) {
            logon_steps.open_the_first_dbb_logon_page(envName);
            logon_steps.enter_Organisation_ID("123456");
        }

    }







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


}
