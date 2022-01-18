package com.hsbc.cmb.hk.dbb.glue.VkeyApp;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class testMobile {

    public static void main(String[] args) throws MalformedURLException, InterruptedException{

        // TODO Auto-generated method stub
        //1.添加配置，创建DesiredCapabilities对象
        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("app", (new File("C:/Program Files/app/GreenLink_1.0.0.apk")).getAbsolutePath());
//        cap.setCapability("automationName", "UiAutomator2");
//        cap.setCapability("deviceName", "emulator-5554");
//        cap.setCapability("platformVersion", "7.1.2");
//        cap.setCapability("platformName", "ANDROID");
//        cap.setCapability("noReset", "true");
//        cap.setCapability("dontStopAppOnReset", "true");
//        cap.setCapability("autoLaunch", "false");
        //指定测试设备的名称
        cap.setCapability("deviceName", "127.0.0.1:5554");
        //添加操作系统配置
        cap.setCapability("platformName", "Android");
        //添加操作系统版本设置
        cap.setCapability("platformVersion", "7.1.2");
        //指定想要测试应用的包名
        cap.setCapability("appPackage", "com.glbank.mobileapp");
        //指定想要测试应用的入口activity
        cap.setCapability("appActivity", "com.glbank.module_main.page.vkey.VKeyDownloadTipsActivity");
        //不需要清理数据，避免重新安装的问题
        cap.setCapability("noRest","True");
        //2.创建驱动...URL是appium的固定地址；指定appium通讯的地址，将相对应的配置传入到驱动里边
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        //加线程等待
        //Thread.sleep(5000);
        //打开地图后点击同意继续
        driver.findElementById("btn_submit").click();
        Thread.sleep(1000);
        driver.findElementById("com.glbank.mobileapp:id/et_acct_id").sendKeys("200007");
        driver.findElementById("et_email").sendKeys("0003@qq.com");
        driver.findElementById("et_password").sendKeys("Zx123456.");
        driver.findElementById("btn_login").click();
        Thread.sleep(20000);
        driver.findElementById("btn_submit").click();
        test(driver);
        Thread.sleep(100000);
        //退出
        driver.quit();
    }


    //截图
    private static void test(WebDriver driver){
        File screen = ((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
        File screenFile = new File("Y:/Downloads/screenshots/screen.png");
        try {
            FileUtils.copyFile(screen,screenFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}