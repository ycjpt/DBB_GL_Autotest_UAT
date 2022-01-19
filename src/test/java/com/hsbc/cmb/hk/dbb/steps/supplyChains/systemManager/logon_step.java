package com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.systemManager.logon_page;
import com.hsbc.cmb.hk.dbb.utils.CommonUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class logon_step extends ScenarioSteps {
    private logon_page login__page;
    public String profileNum;




    @Step
    public void open_the_first_dbb_logon_page(String envName) {
        String logonUrl = CommonUtil.getEnvironmentSpecificConfiguration("environments." + envName + ".webdriver.base.url");
        login__page.openUrl(logonUrl);
    }

    @Step
    public void enter_username_into_box(String envName) {
        String userName = CommonUtil.getEnvironmentSpecificConfiguration("environments." + envName + ".username");
        login__page.enterUserName(userName);
    }

    @Step
    public void enter_password_into_box(String envName) {
        String userName = CommonUtil.getEnvironmentSpecificConfiguration("environments." + envName + ".password");
        login__page.enterPassWord(userName);
    }

    @Step
    public void click_login_btn(){
        login__page.clickLogonBtn.click();
    }

    @Step
    public void getClickSCFlink(){
        login__page.clickSCFlink.click();
    }

}
