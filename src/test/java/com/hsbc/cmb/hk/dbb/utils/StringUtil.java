package com.hsbc.cmb.hk.dbb.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

public class StringUtil {

    /**
     * Function:Get random string with uppercase ,downcase nad number
     * @param length String length
     * @return random string with specific length
     */
    public static String getRandomString(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if( "char".equalsIgnoreCase(charOrNum) ) {
                int temp = random.nextInt(2)%2 == 0 ? 65 : 97;
                val.append((char) (random.nextInt(26) + temp));
            } else {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }
    /**
     * Function:Get random string with number only.
     * @param length String length
     * @return random string with specific length
     */

    public static String getRandomNum(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            val.append(random.nextInt(10));
        }
        return val.toString();
    }

    /**
     * Function:Get random string with downcase and number.
     * @param length String length
     * @return random string with specific length
     */
    public static String getRandomDownStrAndNum(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if( "char".equalsIgnoreCase(charOrNum) ) {
                val.append((char) (random.nextInt(26) + 97));
            } else {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }

    /**
     * Function:Get random string with uppercase and number,
     * @param length String length
     * @return random string with specific length
     */

    public static String getRandomUpperStrAndNum(int length) {
        StringBuilder val = new StringBuilder();
        Random random = new Random();

        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if( "char".equalsIgnoreCase(charOrNum) ) {
                val.append((char) (random.nextInt(26) + 65));
            } else {
                val.append(random.nextInt(10));
            }
        }
        return val.toString();
    }

    /**
     * Function Convert String to float
     * @param value
     *        eg 100,100.00
     * @return  A float number without comma
     */
    public static float stringConvertFloat(String value) {
        float floatArr = 0;
        if(!isNull(value)){
            String[] valueArr = value.split(",");
            StringBuilder str = new StringBuilder();
            for (String s : valueArr) {
                str.append(s);
            }
            floatArr = Float.parseFloat(String.valueOf(str));
        }
        return floatArr;
    }

    /**
     * Function : get a String with float type
     * @param decimalPlaces : defines the number of decimal places
     * @param lower : specify the lower limit respectively.
     * @param upper : specify the upper limit respectively.
     * @return : random string of float
     */

    public static String getRandomfloat(int decimalPlaces,int lower,int upper) {
        int pow = (int) Math.pow(10, decimalPlaces);
        double rand = Math.floor((Math.random() * (upper - lower) + lower) * pow) / pow;
        return String.valueOf(rand);
    }

    /**
     * Function : verfy a String variable is null
     * @param param : specify the String variable
     * @return : boolean value True or False.
     */
    public static boolean isNull(String param){
        return param == null || param.isEmpty() || param.trim().equals("");
    }

    public static String updateDbbUrl(String curUrl, String newUrl){
        StringBuilder url = new StringBuilder().append(curUrl);
        url.delete(curUrl.indexOf("/portalserver"),curUrl.length());
        url.append(newUrl);
        return url.toString();
    }

    public static String hostUrl(String curUrl) {
        StringBuilder url = new StringBuilder().append(curUrl);
        url.delete(curUrl.indexOf("/portalserver"),curUrl.length());
        return url.toString();
    }

    public static StringBuilder replaceAll(StringBuilder stb, String oldStr, String newStr) {
        if (stb == null || oldStr == null || newStr == null || stb.length() == 0 || oldStr.length() == 0)
            return stb;
        int index = stb.indexOf(oldStr);
        if (index > -1 && !oldStr.equals(newStr)) {
            int lastIndex = 0;
            while (index > -1) {
                stb.replace(index, index + oldStr.length(), newStr);
                lastIndex = index + newStr.length();
                index = stb.indexOf(oldStr, lastIndex);
            }
        }
        return stb;
    }

    /**
     * Function Convert String to double number with comma
     * @param data eg 100100.00 convert to 100,100.00
     * @return  A double number with comma
     */
    public static String formatString(String data) {
        double dataf= Double.parseDouble(data);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return df.format(dataf);
    }

    public static String lastZerosRemove(String stringFloat) {
        return new BigDecimal(stringFloat).stripTrailingZeros().toPlainString();
    }

}
