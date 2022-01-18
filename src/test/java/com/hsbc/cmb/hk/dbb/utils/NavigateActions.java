package com.hsbc.cmb.hk.dbb.utils;

import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 43864264
 * \* Date: 01/17/2020
 * \* Time: 2:30 PM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class NavigateActions {
    public void redirectTo(String targetTitle) {
        ExpectedCondition<Boolean> result = ExpectedConditions.titleIs(targetTitle);
        Boolean res = result.apply(getDriver());

        Assert.assertTrue(result.toString(), res);  //compare the expected value with the current title
        new Sleep().doSleep(3000);
    }
}