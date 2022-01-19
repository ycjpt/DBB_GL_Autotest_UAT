package com.hsbc.cmb.hk.dbb.glue.systemManagement;

import com.hsbc.cmb.hk.dbb.steps.systemManagement.createAdminUsers_step;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;


public class createAdminUser_glue {
    public static String getRandom(){
        int code = (int)((Math.random() * 10000) + 1);
        return ""+code;
    }

    @ManagedPages
    public Pages pages;
    @Steps
    private createAdminUsers_step createAdminUsers_step;
    private BDDUtil bddUtil;
    @When("^login successfully and click the SCF link to createAdminUser$")
    public void loginSuccessfullyAndClickTheSCFLinkToCreteAdminUser() {
        String code = getRandom();
        createAdminUsers_step.create_Admin_User();
        createAdminUsers_step.getUsername(code);
        createAdminUsers_step.getEmail(code+"@qq.com");
        createAdminUsers_step.getUserNo(code);
        createAdminUsers_step.clickConfirm();
        bddUtil.sleep(2000);
    }


}
