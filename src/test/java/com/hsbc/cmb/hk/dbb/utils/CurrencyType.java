package com.hsbc.cmb.hk.dbb.utils;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 43864264
 * \* Date: 05/04/2020
 * \* Time: 3:46 PM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class CurrencyType {
    private static final String[] type_lists = {
            "All", "AUD", "CAD", "CHF", "CNY",
            "EUR", "GBP", "HKD", "JPY", "NZD", "SGD", "THB", "USD"};

    public static String[] getInstance() {
        return type_lists;
    }


}