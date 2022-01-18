package com.hsbc.cmb.hk.dbb.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.Map;

/**
 * ----------------------------------------------------------------
 * -*- coding: UTF-8 -*-
 * # @FileName:InsightObject.java
 * # @Date....:八月-27,2019 18:38
 * # #Author..:43864264
 * ----------------------------------------------------------------
 */

public class InsightObject {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    // 获取serenity.conf {key, value} 并实例化为Map对象properties
    Map properties = variables.getProperties();
    // 获取sit1环境的profile id
    public String PROFILE_ID = (String) properties.get("environments.SIT1.profile");
}
