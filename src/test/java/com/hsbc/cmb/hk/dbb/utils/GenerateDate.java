package com.hsbc.cmb.hk.dbb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 43864264
 * \* Date: 05/04/2020
 * \* Time: 11:49 AM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class GenerateDate {

    long millsec_day = 24*3600*1000;

    Calendar cal_currently = Calendar.getInstance(); // get currently calendar
    Date date = cal_currently.getTime();
    DateFormat df = new SimpleDateFormat("dd MMM yyyy"); // set date format

    /**
     * 获取今天
     * @return
     */
    public String today() {
        return df.format(date);
    }

    /**
     * 相比今天往前多少天
     * @param days
     * @return
     */
    public String before(int days) {
        return df.format(date.getTime() - days * millsec_day);
    }

    /**
     * 相比今天往后多少天
     * @param days
     * @return
     */
    public String after(int days) {
        return df.format(date.getTime() + days * millsec_day);
    }
}