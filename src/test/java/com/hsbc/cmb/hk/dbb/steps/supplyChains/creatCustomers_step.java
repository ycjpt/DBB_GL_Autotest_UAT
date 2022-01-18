package com.hsbc.cmb.hk.dbb.steps.supplyChains;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.creatCustomers_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class creatCustomers_step extends ScenarioSteps {
    private creatCustomers_page customers_page;
    private BDDUtil bddUtil;

    @Step
    public void getClickCustomersMenu(){
        customers_page.clickCustomersMenu.click();
    }

    public void getClickOnboardingListMenu(){
        customers_page.clickOnboardingListMenu.click();
    }

    public void getClickCreateCustomerBtn(){
        customers_page.clickCreateCustomerBtn.click();
    }

    @Step
    public void disPlayedSCFTitle(){
        if (customers_page.scfTitle.isDisplayed()){
            System.out.println("成功进入CSF页面");
        }
    }

}
