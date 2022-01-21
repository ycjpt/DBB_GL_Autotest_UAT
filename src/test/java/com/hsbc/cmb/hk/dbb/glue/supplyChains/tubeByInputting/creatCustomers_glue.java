package com.hsbc.cmb.hk.dbb.glue.supplyChains.tubeByInputting;

import com.hsbc.cmb.hk.dbb.steps.supplyChains.systemManager.logon_step;
import com.hsbc.cmb.hk.dbb.steps.supplyChains.tubeByInputting.creatCustomers_step;
import com.hsbc.cmb.hk.dbb.utils.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;

public class creatCustomers_glue {
    @ManagedPages
    public Pages pages;
    IdCardGenerator g = new IdCardGenerator();
    public static String code;

    @Steps
    private creatCustomers_step customers_step;
    public static String envTag;
    private BDDUtil bddUtil;
    private logon_step logon_step;
    public String mailName = JRandomNameTool.getStringRandom(8);
    public String mailName1 = JRandomNameTool.getStringRandom(8);

    @When("^login successfully and click the SCF link$")
    public void loginSuccessfullyAndClickTheSCFLink() {
        customers_step.disPlayedSCFTitle();

    }

    @When("^I click Customers and select Onboarding List$")
    public void iClickCustomersAndSelectOnboardingList() {
        customers_step.getClickCustomersMenu();
        customers_step.getClickOnboardingListMenu();
    }

    @And("^I click Create Customer and fill in the buyer information in the pop-up window$")
    public void iClickCreateCustomerAndFillInTheBuyerInformationInThePopUpWindow() {
        customers_step.getClickCreateCustomerBtn();
        customers_step.getSelectCustomerType();
        customers_step.getCustomerTypeValue();
        customers_step.getCompanyName(JRandomNameTool.getStringRandom(12));
        customers_step.getCompanyID(g.generate());
        customers_step.getSelectCountryOfRegistration();
        customers_step.getCountryOfRegistrationValue();
        customers_step.getCompanyNameLeft(JRandomNameTool.getStringRandom(15));
        customers_step.getCLickNextBtn();
    }

    @And("^I click Create Customer and fill in the supplier information in the pop-up window$")
    public void iClickCreateCustomerAndFillInTheSupplierInformationInThePopUpWindow() {
        customers_step.getClickCreateCustomerBtn();
        customers_step.getSelectCustomerType();
        customers_step.getCustomerTypeSupplier();
        customers_step.getCompanyName(JRandomNameTool.getRandomJianHan(9));
        customers_step.getCompanyID(g.generate());
        customers_step.getSelectCountryOfRegistration();
        customers_step.getCountryOfRegistrationValue();
        customers_step.getCompanyNameLeft(JRandomNameTool.getStringRandom(15));
        customers_step.getCLickNextBtn();
    }

    @Then("^I Check to see if you jump to the Authorized Person page$")
    public void checkToSeeIfYouJumpToTheAuthorizedPersonPage() {
        customers_step.getCheckNextPage();
    }

    @When("^Fill in email 1 and email 2 supplier information on the Authorized Person page$")
    public void fillInAdministratorAndAdministratorSupplierInformationOnTheAuthorizedPersonPage() {
        customers_step.getFirstNameInput(JRandomNameTool.getStringRandom(8));
        bddUtil.switchToNewWindow();
        customers_step.emailOperation(mailName);
        bddUtil.switchToWindows();
        customers_step.getEmailInput(mailName + "@MailTemp.top");
        System.out.println("---------------第一个邮箱地址："+ mailName + "@MailTemp.top"+"----------------------");
        customers_step.getLastName(JRandomNameTool.getRandomJianHan(4));
        customers_step.getMobileInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.getFirstNameSecondInput(JRandomNameTool.getStringRandom(8));
        customers_step.getEmailSecondInput(mailName1  + "@MailTemp.top");
        System.out.println("---------------第二个邮箱地址："+ mailName1 + "@MailTemp.top"+"----------------------");
        customers_step.getLastNameSecondInput(JRandomNameTool.getStringRandom(4));
        customers_step.getMobileSecondInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.clickInputBySelectBox();
        customers_step.clickSubmitBtn();
        bddUtil.sleep(3);
    }

    @When("^Fill in email 1 and email 2 buyer information on the Authorized Person page$")
    public void fillInAdministratorAndAdministratorBuyerInformationOnTheAuthorizedPersonPage() {
        customers_step.getFirstNameInput(JRandomNameTool.getStringRandom(8));
        bddUtil.switchToNewWindow();
        customers_step.emailOperation(mailName);
        bddUtil.switchToWindows();
        customers_step.getEmailInput(mailName + "@@MailTemp.top");
        System.out.println("---------------第一个邮箱地址："+ mailName + "@MailTemp.top"+"----------------------");
        customers_step.getLastName(JRandomNameTool.getRandomJianHan(4));
        customers_step.getMobileInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.getFirstNameSecondInput(JRandomNameTool.getStringRandom(8));
        customers_step.getEmailSecondInput(mailName1  + "@MailTemp.top");
        System.out.println("---------------第二个邮箱地址："+ mailName1 + "@MailTemp.top"+"----------------------");
        customers_step.getLastNameSecondInput(JRandomNameTool.getStringRandom(8));
        customers_step.getMobileSecondInput(RandomPhoneNumber.randomPhoneNum());
        customers_step.clickSubmitBtn();
    }

    @Then("^Successfully create buyer customer information$")
    public void successfullyCreateBuyerCustomerInformation() {
        customers_step.checkSuccessPageTitle();
    }

    @And("^I switch to the SCF page$")
    public void iSwitchToTheSCFPage() {
        bddUtil.switchToSecondWindows();
    }

    @When("^open the email browser page$")
    public void openThreePage() {
       customers_step.openEmailUrl();
    }

    @And("^I received an email from Green Union Bank on the email page$")
    public void iReceivedAnEmailFromGreenUnionBankOnTheEmailPage() {
        customers_step.viewEmail();
    }

    @And("^I click the email icon to send the email$")
    public void clickTheEmailIconToSendTheEmail() {
        customers_step.clickSendEmailBtn();
    }

    @Then("^I check that the email has been sent successfully$")
    public void iCheckThatTheEmailHasBeenSentSuccessfully() {
        customers_step.checkSendEmailSuccess();
    }

//    @After
//    public void testCase(){
//        System.out.println("--------------------testcase--------------------");
//    }
}
