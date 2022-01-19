package com.hsbc.cmb.hk.dbb.glue.supplyChains.systemManager;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager.logon_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class logon_glue {
    @ManagedPages
    public Pages pages;

    @Steps
    private logon_step login_uso_step;
    public static String envTag;
    private BDDUtil bddUtil;

    @Given("^logon \"([^\"]*)\" on tube by inputting system$")
    public void logon_onboarding_custom_portal(String envName) {
        envTag = envName;
        if (!envName.isEmpty()) {
            login_uso_step.open_the_first_dbb_logon_page(envName);
            login_uso_step.enter_username_into_box(envName);
            login_uso_step.enter_password_into_box(envName);
            login_uso_step.click_login_btn();
            login_uso_step.getClickSCFlink();
            bddUtil.switchToNewWindow();
        }
    }


}
