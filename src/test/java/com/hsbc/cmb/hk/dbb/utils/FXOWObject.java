package com.hsbc.cmb.hk.dbb.utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 43864264
 * \* Date: 03/24/2020
 * \* Time: 10:35 AM
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class FXOWObject {
    EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    // 获取serenity.conf {key, value} 并实例化为Map对象properties
    Map properties = variables.getProperties();
    // 获取sit4环境的profile id
    public String PROFILE_ID = (String) properties.get("environments.TFX_LL2-E.profile");
}