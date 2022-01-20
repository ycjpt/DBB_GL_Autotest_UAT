package com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.systemManager.createAdminUser_page;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;

import static com.hsbc.cmb.hk.dbb.utils.RandomPhoneNumber.randomPhoneNum;

public class createAdminUsers_step extends ScenarioSteps {

    public static String code = randomPhoneNum();


    private createAdminUser_page createAdminUser_page;

    @Step
    public void create_Admin_User(){
        createAdminUser_page.clickMore.click();
        createAdminUser_page.clickSetting.click();
        createAdminUser_page.clickAdminusers.click();
        createAdminUser_page.clickcreateAdminuser.click();
    }
    @Step
    public void getUsername(){
        createAdminUser_page.userName.sendKeys(code);
    }

    @Step
    public void getEmail(){
        createAdminUser_page.eMail.sendKeys(code+"@qq.com");
    }
    @Step
    public void getUserNo(){
        createAdminUser_page.userNo.sendKeys(code);
    }
    @Step
    public void clickConfirm_Create(){
        createAdminUser_page.clickConfirm_Create.click();
    }
    @Step
    public void clickAuthoritySetting(){
        createAdminUser_page.clickAuthoritySetting.click();
    }
    @Step
    public void clickPermissionMenu(){
        createAdminUser_page.clickPermissionMenu.click();
    }
    @Step
    public void clickImportMean(){
        createAdminUser_page.clickImportMenu.click();
    }
    @Step
    public void clickConfirm_Update(){
        createAdminUser_page.clickConfirm_Update.click();
    }
}
