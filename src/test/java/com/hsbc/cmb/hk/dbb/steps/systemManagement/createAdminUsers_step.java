package com.hsbc.cmb.hk.dbb.steps.systemManagement;

import com.hsbc.cmb.hk.dbb.pages.systemManagement.createAdminUser_page;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class createAdminUsers_step extends ScenarioSteps {
    private createAdminUser_page createAdminUser_page;


    @Step
    public void create_Admin_User(){
        createAdminUser_page.clickMore.click();
        createAdminUser_page.clickSetting.click();
        createAdminUser_page.clickAdminusers.click();
        createAdminUser_page.clickcreateAdminuser.click();
    }
    @Step
    public void getUsername(String value){
        createAdminUser_page.userName.sendKeys(value);
    }

    @Step
    public void getEmail(String value){
        createAdminUser_page.eMail.sendKeys(value);
    }
    @Step
    public void getUserNo(String value){
        createAdminUser_page.userNo.sendKeys(value);
    }
    @Step
    public void clickConfirm(){
        createAdminUser_page.clickConfirm.click();
    }
}
