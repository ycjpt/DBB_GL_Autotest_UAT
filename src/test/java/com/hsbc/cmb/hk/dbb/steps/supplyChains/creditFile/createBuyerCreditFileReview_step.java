package com.hsbc.cmb.hk.dbb.steps.supplyChains.creditFile;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.creditFile.createBuyerCreditFileReview_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class createBuyerCreditFileReview_step extends ScenarioSteps {

    private createBuyerCreditFileReview_page createBuyerCreditFileReview_page;
    private BDDUtil bddUtil;

    @Step
    public void clickBuyerCreditFileReview(){
        createBuyerCreditFileReview_page.clickBuyerCreditProfileReview.click();
    }
    @Step
    public void buyerCreditFileL1Review(){
        bddUtil.sleep(2);
        createBuyerCreditFileReview_page.clickAssignToMe.click();
        createBuyerCreditFileReview_page.clickAssignToMePage.click();
        bddUtil.sleep(2);
        createBuyerCreditFileReview_page.clickProceedToL2.click();
        bddUtil.sleep(2);
        createBuyerCreditFileReview_page.getL1Result.click();
        bddUtil.sleep(2);
        bddUtil.scrollWindowToElement(createBuyerCreditFileReview_page.getL1Approve);
        createBuyerCreditFileReview_page.getL1Approve.click();
        createBuyerCreditFileReview_page.getL1Comments.sendKeys("PASS");
        createBuyerCreditFileReview_page.clickSubmitToL2.click();
        bddUtil.sleep(3);
    }
    @Step
    public void changeUserToL2Review(){
        createBuyerCreditFileReview_page.clickUserToLogOut.click();
        createBuyerCreditFileReview_page.clickLogOutToChangeUser.click();
        createBuyerCreditFileReview_page.clickCancel.click();
        createBuyerCreditFileReview_page.clickGoOn.click();
    }
}
