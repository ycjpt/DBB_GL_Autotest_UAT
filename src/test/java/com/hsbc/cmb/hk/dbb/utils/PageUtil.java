package com.hsbc.cmb.hk.dbb.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Cookies;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.steps.StepEventBus;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static java.time.temporal.ChronoUnit.SECONDS;

public class PageUtil extends PageObject {

    /**
     * Function: Navigate to specific page directly via  URL
     *
     * @param envPageInALL: Custom environment variables in serenity.conf
     */
    public void naigateTo(String envPageInALL) {
        String curUrl = CommonUtil.getEnvironmentSpecificConfiguration(envPageInALL);
        String newurl = StringUtil.updateDbbUrl(getDriver().getCurrentUrl(), curUrl);
        this.openUrl(newurl);
    }

    public String getApiPostRes(String baseUrl,String postPath, String postBody) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = StringUtil.hostUrl(baseUrl);
        RestAssured.basePath = "/portalserver";
        RequestSpecification specification = new RequestSpecBuilder().setProxy("intpxy1.hk.hsbc", 8080).build();
        if (RestAssured.baseURI.contains("hsbc.com.hk")) {
            return given().spec(specification)
                    .cookies(new Cookies(getRestAssuredCookis()))
                    .header("X-BBXSRF", getXBBXSRF()).contentType("application/json")
                    .body(postBody)
                    .when().post(postPath).getBody().asString();
        } else {
            return given()
                    .cookies(new Cookies(getRestAssuredCookis()))
                    .header("X-BBXSRF",getXBBXSRF()).contentType("application/json")
                    .body(postBody)
                    .when()
                    .post(postPath).getBody().asString();
        }
    }

    public String postBodyFormat(String bodyStructure, Object... parameters) {
        return String.format(bodyStructure, parameters);
    }

    public String getSpecValueFromRes(String resBody,String specName) {
        return new JsonPath(resBody).get(specName);
    }


    public List<io.restassured.http.Cookie> getRestAssuredCookis() {
        // This is where the Cookies will live going forward
        List<io.restassured.http.Cookie> restAssuredCookies = new ArrayList<>();
        // Simply pull all the cookies into Rest-Assured
        for (org.openqa.selenium.Cookie cookie : getDriver().manage().getCookies()) {
            restAssuredCookies.add(new io.restassured.http.Cookie.Builder(cookie.getName(), cookie.getValue()).build());
        }
        return restAssuredCookies;
    }

    public String getXBBXSRF() {
        String bbxsrf = getDriver().manage().getCookieNamed("BBXSRF").toString();
        int i = bbxsrf.indexOf("path");
        System.out.println("BBXSRF=" + bbxsrf.substring(7, i - 2));
        return bbxsrf.substring(7, i - 2);
    }

    /**
     * Function : element existence judgement
     * @param by locator type
     * @return : True or False
     */
    public boolean isElementPresent(By by) {
        return !withTimeoutOf(5,SECONDS).findAll(by).isEmpty();
    }

    /**
     * Functon : Remove a attribute of element via javaScript.
     *
     * @param element   target element which attribute remove from
     * @param attribute target attribute to remove
     */
    public void jsRemoveAttribute(WebElementFacade element, String attribute) {
        evaluateJavascript("arguments[0].removeAttribute(arguments[1],arguments[2])", element, attribute);
    }

    /**
     * Function : Set a attribute of element via javaScript
     *
     * @param element   target element which attribute set on
     * @param attribute target attribute to set
     * @param value     attribute value
     */
    public void jsSetAttribute(WebElementFacade element, String attribute, String value) {
        evaluateJavascript("arguments[0].setAttribute(arguments[1],arguments[2])", element, attribute, value);
    }

    /**
     * Move the Scroll in the element to the top
     * @param element : target element
     */
    public void setScrollIntoElementTop(WebElement element) {
        evaluateJavascript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Move the scroll in the element to the bottom
     * @param elementFacade : target element
     */
    public void setScrollIntoElementBottom(WebElementFacade elementFacade) {
        evaluateJavascript("arguments[0].scrollIntoView(false);",elementFacade);
    }

    public void alertClose() {
        Alert alter = getDriver().switchTo().alert();
        alter.accept();
    }

    /**
     * Function click target element via javaScript
     *
     * @param element is target for click
     */
    public void jsClick(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("JavaScript's click is performed on the element");
                evaluateJavascript("arguments[0].click()", element);
            } else {
                System.out.println("element cannot click via JavaScript");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            ;
        } catch (NoSuchElementException e) {
            System.out.println("No such element in current page");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mouseMoveOnThenClick(WebElementFacade taget, int xOffset, int yOffset) {
        withAction().moveToElement(taget, xOffset, yOffset).click().perform();
    }

    public void jsSetScrollIntoTopView(WebElementFacade elementFacade) {
        evaluateJavascript("arguments[0].scrollIntoView();", elementFacade);
    }

    public void jsSetScrollTo(int ypos) {
        evaluateJavascript("window.scrollTo(0, arguments[0]);", ypos);
    }

    public void jsSetScrollIntoBottomView(WebElementFacade elementFacade) {
        evaluateJavascript("arguments[0].scrollIntoView(false);", elementFacade);
    }

    public void jsSetScrolltoButtom() {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
    }

    /**
     * Function: Get token Url with specific account number
     *
     * @param envName is for which environment name you selected from serenity.conf
     * @param actNo   is got from OTP overlay
     * @return token url with account number
     */
    public String tokenUrlWithAccount(String envName, String actNo) {
        String actTokenURL = CommonUtil.getConfigedEnvironmentVariables("environments." + envName + ".accounts.token.url");
        return actTokenURL.replaceAll("account=\\d+", "account=" + actNo);
    }

    /**
     * Function : wait for value appearing in a input-box
     *
     * @param element       : a input-box element.
     * @param expectedValue : the value will shown in the input-box
     */
    public void waitForValue(final WebElement element, final String expectedValue) {
        if (!driverIsDisabled()) {
            waitForCondition().until(valuePresentInElement(element, expectedValue));
        }
    }

    private boolean driverIsDisabled() {
        return StepEventBus.getEventBus().webdriverCallsAreSuspended();
    }

    private ExpectedCondition<Boolean> valuePresentInElement(final WebElement element, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return (containsValue(element, expectedText));
            }

            @Override
            public String toString() {
                return "Expecting value present in element: '" + expectedText + "'";
            }
        };
    }

    private boolean containsValue(final WebElement element, final String textValue) {
        return element.getAttribute("value").contains(textValue);
    }

}