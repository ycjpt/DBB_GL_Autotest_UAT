package com.hsbc.cmb.hk.dbb.utils;

import net.serenitybdd.core.environment.ConfiguredEnvironment;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.util.EnvironmentVariables;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Tom1 p li
 * @version 1.0
 * @since 2019-08-09
 */
public class CommonUtil {
    /**
     * Function: wait specific millisecond when running
     * @param millisecond  1000 millisecond = 1 second
     */
    public static void waiting(long millisecond){
        try{
            Thread.sleep(millisecond);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    /**
     * Function: Get current time with format specified
     */
    public static String getCurrentTimeStamp(){
        Long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(timeStamp);
    }

    /**
     * Function : Get random number in the specific range
     * @param start the range from
     * @param end  the range to
     * @return a random number in range of start and end
     */
    public static int getRandomNum(int start, int end) {
        return (int)(Math.random()*(end-start+1)+start);
    }

    /**
     * Function: Get a random working day form current month
     * @return  A random day in the month
     */
    public static String getDateInCurMonth() {
        Calendar cal = Calendar.getInstance();
        Date curDate = new Date();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        List<Date> dates = getWorkDaysForMonth(year,month);
        List<String> dateformat = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        for(Date date : dates) {
            if(date.compareTo(curDate) >= 0) {
                dateformat.add(sdf.format(date));
            }
        }
        return dateformat.get(getRandomNum(0,dateformat.size()-1));
    }

    /**
     * Function : Get the default customize environment variables with short name
     * @param cfgName
     *        eg "accounts.token.url"
     * @return customize environment variables
     */
    public static String getEnvironmentSpecificConfiguration(String cfgName) {
        EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(cfgName);
    }

    /**
     * Function: Get a environment variables you specific.
     * @param cfgName
     *        eg "drivers.windows.webdriver.chrome.driver"
     * @return Any Configed Environment Variables you want to obtain
     */
    public static String getConfigedEnvironmentVariables(String cfgName) {
        EnvironmentVariables environmentVariables = ConfiguredEnvironment.getEnvironmentVariables();
        return environmentVariables.getProperties().getProperty(cfgName);
    }

    public static void killDriver() {
        String driver = getConfigedEnvironmentVariables("webdriver.driver");
        if(driver.equals("chrome")) {
            exeCommand("taskkill /F /im " + "chrome.exe");
        }
        else if(driver.equals("firefox")) {
            exeCommand("taskkill /F /im " + "firefox.exe");
        }
    }

    private static List<Date> getWorkDaysForMonth(int year,int month){
        List<Date> dates = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH,  month - 1);
        cal.set(Calendar.DATE, 1);

        while(cal.get(Calendar.YEAR) == year && cal.get(Calendar.MONTH) < month){
            int day = cal.get(Calendar.DAY_OF_WEEK);

            if(!(day == Calendar.SUNDAY || day == Calendar.SATURDAY)){
                dates.add((Date)cal.getTime().clone());
            }
            cal.add(Calendar.DATE, 1);
        }
        return dates;
    }

    /**
     * Function:Execute dos command
     * @param command  execute command on windows OS
     */
    private static void exeCommand(String command) {
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Function:Judge whether element exists
     *
     */
    public static boolean isElementExists(WebElementFacade element)
    {
        try{
            element.isDisplayed();
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    /**
     * 把string转化为date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date strToDate(String str) throws ParseException {
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        String[] date = str.split(" ");

        int day = Integer.parseInt(date[0]);
        int month = 0;
        for (int i = 0; i < months.length; i++) {
            if (months[i].equals(date[1])) {
                month = i;
            }
        }

        int year = Integer.parseInt(date[2]);

        return new Date(year, month, day);
    }

    public static boolean confirmDecimalPlace(String currencyFrom, String currencyTo, String rate) {

        String[] type = {"AUD", "CAD", "CHF", "CNY", "EUR", "GBP", "HKD", "JPY", "NZD", "SGD", "THB", "USD"};

        int expectedDecimalPlace = 0;
        // decimalPlace equals 5
        String fiveDecimalPlace = "AUDCAD,AUDCHF,AUDCNY,AUDEUR,AUDGBP,AUDHKD,AUDNZD,AUDSGD,AUDUSD,CADCHF,CADCNY,CADEUR,CADGBP,CADHKD,CADNZD,CADSGD,CADUSD,,CHFAUD,CHFCAD,CHFEUR,CHFGBP,CHFHKD,CHFNZD,CHFSGD,CHFUSD,,CNYHKD,CNYTHB,EURAUD,EURCAD,EURCHF,EURCNY,EURGBP,EURHKD,EURNZD,EURSGD,EURUSD,GBPAUD,GBPCAD,GBPCHF,GBPCNY,GBPEUR,GBPHKD,GBPNZD,GBPSGD,GBPUSD,HKDJPY,HKDTHB,JPYAUD,JPYCAD,JPYGBP,NZDAUD,NZDCAD,NZDCHF,NZDEUR,NZDGBP,NZDHKD,NZDSGD,NZDUSD,,SGDCHF,SGDCNY,SGDHKD,THBJPY,,USDAUD,USDCAD,USDCHF,USDCNY,USDEUR,USDGBP,USDHKD,USDNZD,USDSGD";
        // decimalPlace equals 7
        String sevenDecimalPlace = "CADAUD,CNYAUD,CNYCAD,CNYEUR,CNYGBP,CNYSGD,CNYUSD,HKDAUD,HKDCAD,HKDCHF,HKDCNY,HKDEUR,HKDGBP,HKDNZD,HKDSGD,HKDUSD,JPYCHF,JPYCNY,JPYEUR,JPYHKD,JPYNZD,JPYSGD,JPYUSD,SGDEUR,SGDGBP,THBAUD,THBCNY,THBEUR,THBHKD";
        // decimalPlace equals 6
        String sixDecimalPlace = "CNYCHF,CNYNZD,JPYTHB,SGDAUD,SGDCAD,SGDNZD,SGDUSD,THBGBP,THBUSD";
        // decimalPlace equals 4
        String fourDecimalPlace = "CHFCNY,CNYJPY,NZDCNY,NZDTHB,SGDTHB";
        // decimalPlace equals 8
        String eightDecimalPlace = "THBCHF,THBNZD,THBSGD";

        if ("THBCAD".equals(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 9;
        }
        else if ("GBPTHB".equals(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 2;
        }
        else if (eightDecimalPlace.contains(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 8;
        }
        else if (fourDecimalPlace.contains(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 4;
        }
        else if (sixDecimalPlace.contains(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 6;
        }
        else if (sevenDecimalPlace.contains(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 7;
        }
        else if (fiveDecimalPlace.contains(currencyFrom+currencyTo)) {
            expectedDecimalPlace = 5;
        }

        int decimalPlace = rate.split("\\.")[1].length();

        if (expectedDecimalPlace != decimalPlace) {
            throw new AssertionError(currencyFrom + " > " + currencyTo + " " + rate
                    + " expected decimal place is: "+expectedDecimalPlace +
                    ", actually is " + decimalPlace + "\n");
        }
        else {
            return true;
        }
    }

}
