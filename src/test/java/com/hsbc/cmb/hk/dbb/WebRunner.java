package com.hsbc.cmb.hk.dbb;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Tom on 10/07/2019.
 */

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        plugin = {"pretty","html:target/cucumber","json:target/json/cucumber.json"},
        tags = "@tubeByInputting")
public class WebRunner {

}
