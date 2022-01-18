package com.hsbc.cmb.hk.dbb.utils;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;


/**
 * Created on 2019/10/24
 * @author:  45073953
 */

public class BDDUtil extends PageObject {

    @FindBy(id = "userName")
    private WebElementFacade userNameInputBox;

    @FindBy(xpath = "//*[text() = 'Next']")
    private WebElementFacade nextButton;

    @FindBy(id = "password")
    private WebElementFacade passwordInputBox;

    @FindBy(id = "security-code")
    private WebElementFacade securityCodeInputBox;

    @FindBy(xpath = "//*[text() = 'Log on']")
    private WebElementFacade logOnButton;

    @FindBy(xpath = "//div[@data-analytics-event-content='profile selector']")
    private WebElementFacade okProfileButton;

    @FindBy(xpath = "//span[@class='current-profile']")
    private WebElementFacade errorProfileButton;

//    @FindBy(xpath = "//div[@class='tooltip-inner']")
    @FindBy(xpath = "//div[@class='dropdown-menu scrollable-y']")
    private WebElementFacade profileListElem;

    @FindBy(xpath = "//div[@class='tooltip-profile']")
    private WebElementFacade currentProfile;

    //Push Auth
    @FindBy(xpath = "//*[@id='tab_hsbc_app']")
    private WebElementFacade tab_HSBC_App;
    @FindBy(id = "push-password")
    private WebElementFacade pushAuthPasswordInputBox;
    @FindBy(xpath="//span[text()='Continue']")
    private WebElementFacade continueBtn;
    @FindBy(xpath="//span[text()='Send notification']")
    private WebElementFacade sendNotification;

    @FindBy(xpath = "//input[@id='sercurity-code']")
    private WebElementFacade otpCodeInputBox;

    @FindBy(xpath = "//*[text()='Please update business information.']")
    public List<WebElementFacade> topTips;

    @FindBy(xpath = "//div[@class='notification-content']")
    private WebElementFacade logonAlertError;
    //eCare

    @FindBy(id = "j_username")
    private WebElementFacade userNameForEcare;
    @FindBy(id = "j_password")
    private WebElementFacade passwordForEcare;
    @FindBy(xpath = "//button[text()='Log in']")
    private WebElementFacade logInForEcare;

    @FindBy(xpath = "//button[contains(text(), 'Acknowledge')]")
    private WebElementFacade ackOverLayBtn;

    private static final Logger LOGGER = LoggerFactory.getLogger(BDDUtil.class);
    private static String url;
    private String username;
    private String password = "b2g3ifd";
    private static String securityCodeUrl;
    private static String profile;
    private static String suprofile;
    private static String env;
    private int logonRetryCount = 2;
    private boolean isLogonSuccess = false;
    public static EnvironmentVariables envVariable;


    public void setEnv(String env) {
        this.env = env;
    }

    public String getEnv() {
        return env;
    }

    public String getUrl() {
        return this.url;
    }

    public void getConfig(String env){
        if (envVariable.getProperty("environment") != null) {
            env = envVariable.getProperty("environment");
        }
        setEnv(env);

        url = getEnvVariable("environments." + env + ".webdriver.base.url");
        username = getEnvVariable("environments." + env + ".username");
        if (getEnvVariable("environments." + env + ".password") != null)
            password = getEnvVariable("environments." + env + ".password");
        securityCodeUrl = getEnvVariable("environments." + env + ".security.token.url");
        profile = getEnvVariable("environments." + env + ".profile");
        suprofile = getEnvVariable("environments." + env + ".suprofile");

    }

    private void getConfigForOtherEnv(String env,String type){
        if (envVariable.getProperty("environment") != null) {
            env = envVariable.getProperty("environment");
        }
        setEnv(env);
        url = getEnvVariable(type +"." + env + ".webdriver.base.url");
        username = getEnvVariable(type+"." + env + ".username");
        password = getEnvVariable(type+"." + env + ".password");
    }

    public String getEnvVariable(String key){
        return envVariable.getProperty(key);
    }

    @Step
    public void logonDBBWithPushAuth(String env){
        getConfig(env);
        openUrl(url);
        enter(username).into(userNameInputBox);
        nextButton.click();
        tab_HSBC_App.click();
        enter(password).into(pushAuthPasswordInputBox);
        scrollWindowToElement(continueBtn);
        continueBtn.click();
    }

    @Step
    public void logonEcare(String env){
        getConfigForOtherEnv(env,"eCare");
        openUrl(url);
        enter(username).into(userNameForEcare);
        enter(password).into(passwordForEcare);
        logInForEcare.click();
    }
    @Step
    public void logonRPQ(String env){
        getConfigForOtherEnv(env,"RPQ");
        openUrl(url);
        enter(username).into(userNameForEcare);
        enter(password).into(passwordForEcare);
        logInForEcare.click();
    }

    public boolean isContainsText(String text,int time){
        boolean flage = false;
       for (int i =0 ;i<=time ;i++){
           boolean b = containsText(text);
           if(b){
               flage = b;
               break;
           }else{
               sleep(1);
           }
       }
       return flage;
    }

    @Step
    public void logonDBB(String env){
        getConfig(env);
        openUrl(url);
        enter(username).into(userNameInputBox);
        scrollWindowToElement(nextButton).click();

        // if the user is suspended during logon, try to unlock it first.
        //  1. if unlock successfully, will go ahead to logon.
        //  2. otherwise, sleep 3 mins, then logon again.
        if(containsText("has been suspended")) {
            LOGGER.info("'" + username + "' is suspended, will try to unlock it.");
            String response = accessURL("http://hkg3vl5591o.hk.hsbc:28080/api/env/acc/unlock/" + username);
            LOGGER.info("Sleeping 5 seconds to wait user unlock take effect...");
            sleep(5);
            if (response.contains("unlock success!")) {
                LOGGER.info("Unlock success!");
            } else {
                LOGGER.info("Unlock failed, will sleep 3 mins!");
                sleep(180);
            }
            enter(username).into(userNameInputBox);
            scrollWindowToElement(nextButton).click();
        }

        enter(password).into(passwordInputBox);

        String securityCode = getLogonToken(securityCodeUrl);
        enter(securityCode).into(securityCodeInputBox);

        scrollWindowToElement(logOnButton).click();

        if(getTitle().equals("Log on to HSBC Online Business Banking")) {
            LOGGER.warn("After click logon button, page title is still 'Log on to HSBC Online Business Banking', " +
                    "will sleep 3 seconds, then verify again.");
            sleep(3);
        }

        if(getTitle().equals("Error")){
            selectProfile(profile);
            skipLogonQuickTour();
            isLogonSuccess = true;
        } else if(getTitle().equals("Business Internet Banking")){
            skipLogonQuickTour();
            selectProfile(profile);
            isLogonSuccess = true;
        } else if(getTitle().equals("Log on to HSBC Online Business Banking")){
            // retry logon for another 2 times, to avoid some unexpected failure, such as:
            // 1. security code becomes invalid when we click logon button.
            // 2. user session becomes expired.
            if (logonAlertError.isCurrentlyVisible()) {
                LOGGER.warn("Logon Error Message : " + logonAlertError.getText());
            }
            while (logonRetryCount > 0){
                if(isLogonSuccess){
                    LOGGER.info("Logon DBB OK after retry.");
                    break;
                }
                LOGGER.info("Retry Logon DBB ...");
                logonRetryCount-- ;
                logonDBB(env);
            }
            if (logonRetryCount == 0 && !isLogonSuccess){
                throw new RuntimeException("Fail to logon DBB after 3 times, with page title '" + getTitle() + "'");
            }
        }else if(getTitle().equals("Submit Remittance Statement")){
            LOGGER.info("Logon with a MPF-only customers");
        } else {
            throw new RuntimeException("Fail to logon DBB with page title '" + getTitle() + "'");
        }
    }

    public void skipLogonQuickTour(){
        if(env.equals("UAT4S") || env.equals("SIT1")|| env.equals("SITO38") || env.equals("O63_SIT1_1")) {
//            waitForTextToAppear("FINAL REMINDER");
            sleep(5);
            if (containsText("FINAL REMINDER")) {
//                scrollWindowToElement(find(By.xpath("//span[text()='Please update business information.']")));
                scrollWindowToElement(find(By.xpath("//div[@class='ng-binding']/following-sibling::div/child::div[2]/child::span")));
                ackOverLayBtn.click();
            }
            if(containsText("IMPORTANT NOTICE")){
                for(int i = 0;i<topTips.size();i++){
                    scrollWindowToElement(topTips.get(i));
                }
                ackOverLayBtn.click();
            }
        }

        waitForTextToAppear("Would you like a 1 minute quick tour", 45000);
        findAll("//*[text() = 'No, please skip.']").get(1).click();

        waitForTextToAppear("Show quick tour again next time I log on", 3000);
        findAll("//button[@data-analytics-event-content='quick tour - step 6 - complete']").get(1).click();
    }

    public void skipTour(){
        waitForTextToAppear("Quick Tour (1 of");
        if(isElementVisible(By.xpath("//span[@translate='page overlay show again']"))){
            find(By.xpath("//span[@translate='page overlay show again']")).click();
        }
        findAll(By.xpath("//span[@translate='page overlay close']")).get(0).click();
    }

    /** @deprecated
     * Use skipTour() method instead
     * */
    @Deprecated
    public void skipQuickTour(){
        sleep(3);
        if(containsText("Would you like a 1 minute quick tour")){
            findAll(By.xpath("//*[text() = 'No, please skip.']")).get(1).click();
            sleep(1);
        }

        if(containsText("Show quick tour again next time I log on")) {
            findAll(By.xpath("//button[@data-analytics-event-content='quick tour - step 6 - complete']")).get(1).click();
            sleep(1);
        }

        if(containsText("Quick Tour (1 of")){
            findAll(By.xpath("//span[@translate='page overlay close']")).get(0).click();
            sleep(1);
        }
    }

    public void selectProfile(String profileName){
        if (isMockEnv() && currentProfile.getText().split("\n")[0].equals(profileName)){
            //if the current selected profile is your target profile, then need to skip because the profile is not clickable.
            return;
        }

        if(getTitle().equals("Error")){
            errorProfileButton.click();
        } else {
            okProfileButton.click();
        }

        find(By.partialLinkText(profileName)).click();

        if(getTitle().equals("Business Internet Banking")){
            LOGGER.info("Logon DBB success.");
        } else if(getTitle().equals("Error")){
            throw new RuntimeException("Logon DBB with profile '" + profileName + "' failed.");
        }
    }

    @Step
    public void verifyOtpAndConfirm() {
        String code = getLogonToken(securityCodeUrl);
        enter(code).into(otpCodeInputBox);
        find(By.xpath("//div[@translate='confirm']")).click();
    }

    public void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isMockEnv(){
        if (!securityCodeUrl.startsWith("http")) {
            // LL, Mock
            return true;
        }
        return false;
    }

    /** @deprecated
     * timeout issue was fixed in chrome driver version 83.
     * */
    @Deprecated
    public void openURL(String url) {
        /*
        add silentOutput=ture to avoid frequently useless timeout output like the following:
        00:02:28.064 [1587610345.658][SEVERE]: Timed out receiving message from renderer: 0.100
        */
        System.setProperty("webdriver.chrome.silentOutput", "true");
        openUrl(url);
    }

    public String getPaymentToken(String verifyCode) {
        if (isMockEnv()) {
            return securityCodeUrl;
        }

        LOGGER.info("Verify Code : '" + verifyCode + "'");
        System.out.println(securityCodeUrl);
        String urlString = securityCodeUrl.replace("type=1", "type=3") + "&account=" + verifyCode;

        disableSSLCertificateChecking();
        String dataString = accessURL(urlString);
        String token = "";
        for (String str : dataString.split(",")) {
            if (str.contains("token")) {
                token = str.split(":")[1].replace("\"","");
                break;
            }
        }
        if (token == ""){
            throw new RuntimeException("Fail to get payment Token!");
        }else {
            LOGGER.info("Get payment token OK : '" + token + "'");
            return token;
        }
    }

    public String getLogonToken(String urlString) {
        if (isMockEnv()) {
            // LL, Mock, return "111111"
            return urlString;
        }

        disableSSLCertificateChecking();
        String dataString = accessURL(urlString);
        String token = "";
        for (String str : dataString.split(",")) {
            if (str.contains("token")) {
                token = str.split(":")[1].replace("\"","");
                break;
            }
        }

        if (token == ""){
            LOGGER.info("Token string : " + dataString);
            throw new RuntimeException("Fail to get Token.");
        }else {
            return token;
        }
    }

    private void disableSSLCertificateChecking() {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // Not implemented
            }

            @Override
            public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                // Not implemented
            }
        } };

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public String accessURL(String urlString) {
        URL url = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();

        try {
            url = new URL(urlString);
            try {
                InputStream inputStream;
                try {
                    inputStream = url.openStream();
                } catch (UnknownHostException e) {
                    System.setProperty("https.proxyHost", "intpxy1.hk.hsbc");
                    System.setProperty("https.proxyPort", "8080");
                    inputStream = url.openStream();
                }
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String str = null;
                while((str=bufferedReader.readLine())!=null){
                    stringBuffer.append(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return stringBuffer.toString();
    }

    public String getCurrentTimestamp(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmmss");
        return ft.format(dNow);
    }

    public String getDeltaDate(int delta){
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, delta);
        Date date = calendar.getTime();
        return ft.format(date);
    }

    public void scrollWindow(int width, int height){
        String x = Integer.toString(width);
        String y = Integer.toString(height);
        evaluateJavascript("scroll("+x+","+y+")");
    }

    public WebElement scrollWindowToElement(WebElement element){
        //we have a fixed header + a fixed footer. So simply scrolling 100px up as a "padding".
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();window.scrollBy(0,-100);", element);
        evaluateJavascript("arguments[0].scrollIntoView();window.scrollBy(0,-100);", element);
        return element;
    }

    public void setDate(WebElementFacade element,String date){
        evaluateJavascript("arguments[0].removeAttribute('readonly');",element);
        enter(date + Keys.ENTER).into(element);
    }

    public void clickByJS(WebElementFacade element) {
        evaluateJavascript("arguments[0].click()", element);
    }

    public void selectSufile() {
        selectProfile(suprofile);
        skipQuickTour();
    }

    public void selectPufile() {
        selectProfile(profile);
        skipQuickTour();
    }


    public void clickHome(){
        getDriver().findElement(By.cssSelector(".icon-home")).click();
        sleep(1);
    }

    public void clickWithRetry(WebElementFacade element){
        int i=2;
        sleep(2);
        while(i>0) {
            if (element.isEnabled() && element.isVisible()) {
//                evaluateJavascript("arguments[0].click()", element);
                element.waitUntilClickable().click();
                break;
            }
            sleep(2);
            i--;
        }
    }

    public void enterWithRetry(String value,WebElementFacade element ){
        int i=10;
        sleep(3);
        while(i>0) {
            if ( element.isCurrentlyVisible()&&element.isEnabled()) {
                enter(value).into(element);
                break;
            }
            sleep(2);
            i--;
        }
    }

    public String  ourGetText(WebElementFacade element ){
        int i=10;
        while(i>0) {
            if (element.isEnabled() && element.isVisible()) {
                return element.waitUntilVisible().getText();
            }
            sleep(2);
            i--;
        }
        return "";
    }

    public void scrolltoButtom() {
        evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void selectFile(String profile) {
        if (profile.contains("suprofile")) {
            sleep(5);
            selectSufile();
        } else if (profile.contains("puprofile")) {
            sleep(5);
            selectPufile();
        } else {
            throw new RuntimeException("Failed to select profile");
        }
    }

    public void switchToNewWindow(){
        String handle = getDriver().getWindowHandle();
        for (String temhandle : getDriver().getWindowHandles()) {
            if (!temhandle.equals(handle))
                getDriver().switchTo().window(temhandle);
        }

    }

}
