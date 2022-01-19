package com.hsbc.cmb.hk.dbb.steps.systemManagement;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.creatCustomers_page;
import com.hsbc.cmb.hk.dbb.pages.systemManagement.scf_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import com.hsbc.cmb.hk.dbb.utils.CommonUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import com.hsbc.cmb.hk.dbb.pages.CBSOnline.logon_page;

public class createAdminUsers_step extends ScenarioSteps {
    private logon_page loginPage;
    private BDDUtil bddUtil;
    private scf_page scfpage;


    @Step
    public void create_Admin_User(){
        scfpage.more.click();
        bddUtil.sleep(20000);

    }
}
