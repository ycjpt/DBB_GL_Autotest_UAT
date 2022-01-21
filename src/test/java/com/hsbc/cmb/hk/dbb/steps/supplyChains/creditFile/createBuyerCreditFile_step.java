package com.hsbc.cmb.hk.dbb.steps.supplyChains.creditFile;

import com.hsbc.cmb.hk.dbb.pages.supplyChains.creditFile.createBuyerCreditFile_page;
import com.hsbc.cmb.hk.dbb.utils.BDDUtil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class createBuyerCreditFile_step extends ScenarioSteps {

    private createBuyerCreditFile_page createBuyerCreditFile_page;
    private BDDUtil bddUtil;

    @Step
    public void clickBuyerCreditProfileList(){
        createBuyerCreditFile_page.clickBuyerCreditProfileList.click();
    }
    @Step
    public void clickCreateNewUnderwriting(){
        createBuyerCreditFile_page.clickCreateNewUnderwriting.click();
    }
    @Step
    public void createNewUnderwriting(){
        createBuyerCreditFile_page.clickToGetCustomerName.click();
        bddUtil.scrollWindowToElement(createBuyerCreditFile_page.getBuyerName);
        createBuyerCreditFile_page.getBuyerName.click();
        createBuyerCreditFile_page.clickToGetUnderwritingMode.click();
        bddUtil.scrollWindowToElement(createBuyerCreditFile_page.getUnderwritingMode);
        createBuyerCreditFile_page.getUnderwritingMode.click();
        createBuyerCreditFile_page.clickPublicCompany.click();
        createBuyerCreditFile_page.clickConfirmToCreateNewUnderwriting.click();
    }
    @Step
    public void editBuyerCreditProfile(){
        createBuyerCreditFile_page.clickEditBuyerCreditProfile.click();
    }

    @Step
    public void displayedCreateBuyerCreditProfilePage(){
        if (createBuyerCreditFile_page.checkCreateBuyerCreditProfilePage.isDisabled()){
            System.out.println("买方档案创建完成，开始编辑买方信息");
        }
    }
    @Step
    public void toEditBuyerCreditProfile(){
        createBuyerCreditFile_page.getLastFiscalYear.click();
        createBuyerCreditFile_page.pickAYear.click();
        createBuyerCreditFile_page.getDRSKRating.clear();
        createBuyerCreditFile_page.getDRSKRating.sendKeys("1");
//        createBuyerCreditFile_page.upScreenshotOfDRSKRating.sendKeys("C:\\Users\\陈楠\\Desktop\\test.jpg");  //上传DRSK评级截图
        createBuyerCreditFile_page.getToReportingCurrency.click();
        bddUtil.scrollWindowToElement(createBuyerCreditFile_page.getReportingCurrency);
        createBuyerCreditFile_page.getReportingCurrency.click();
        createBuyerCreditFile_page.getTotalLiabilities.clear();
        createBuyerCreditFile_page.getTotalLiabilities.sendKeys("1");
        createBuyerCreditFile_page.getCurrentLiabilities.clear();
        createBuyerCreditFile_page.getCurrentLiabilities.sendKeys("1");
        createBuyerCreditFile_page.getTotalAsset.clear();
        createBuyerCreditFile_page.getTotalAsset.sendKeys("1000000");
        createBuyerCreditFile_page.getTotalRevenue.clear();
        createBuyerCreditFile_page.getTotalRevenue.sendKeys("100000");
        createBuyerCreditFile_page.getNetProfit.clear();
        createBuyerCreditFile_page.getNetProfit.sendKeys("100000");
        createBuyerCreditFile_page.getCashAndCashEquivalents.clear();
        createBuyerCreditFile_page.getCashAndCashEquivalents.sendKeys("10000");
        createBuyerCreditFile_page.getBookValueOfEquity.clear();
        createBuyerCreditFile_page.getBookValueOfEquity.sendKeys("10000");
//        createBuyerCreditFile_page.upFinancialInformationInLastYear.sendKeys("C:\\Users\\陈楠\\Desktop\\test.jpg"); //上传去年的财务信息
//        createBuyerCreditFile_page.upOtherFiles.sendKeys("C:\\Users\\陈楠\\Desktop\\test.jpg");  //上传其它文件
        createBuyerCreditFile_page.clickSaveBuyerCreditProfile.click();
    }

    @Step
    public void submitBuyerProfileList(){
        createBuyerCreditFile_page.clickSubmit.click();
    }

}
