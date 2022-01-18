# Automation WebUI Framework BDD
This is a demo project which is used for Test Automation of Gurukula Application.
 It is done using an open source framework which is Serenity BDD. The complete Technical stack also includes Cucumber, Selenium, Junit. Maven is used for managing the build.

Serenity BDD is a library that makes it easier to write high quality automated acceptance tests, with powerful reporting and living documentation features. It has strong support for both web testing with Selenium, and API testing using RestAssured.

### The project directory structure
The project has build scripts for both Maven and Gradle, and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + test
    + java                          Test runners and supporting code
    + resources
      + features                    Feature files
          + Login                    Feature file subdirectories 
             ddb_idv_login.feature 
       + drivers                     Bundled webdriver binaries
         chromedriver.exe           OS-specific Webdriver binaries 
         geckodriver.exe
```

## The sample scenario
In this Demo project we have defined scenarios in Cucumber feature files as below. This is done for a sample Gurukula Application. In this scenario, User with a valid username and password is trying to login into the Gurukula Application:

```Gherkin
Feature: Logon DBB successfully
  As a DBB vailable user
  I want to login to the DBB system
  So that I can Logon DBB successfully

  Scenario: DBB IDV Logon

    Given Open the Logon page
    When I input username
    And Click the Next button
    And I input password and Token Code
    And I click the Logon button
    And I select a profile
    Then I see the DBB landing page with profile selected

```
The glue code for this scenario looks this:

```java
public class LogonStepDef extends GenericConstant {  
  
    @Given(pages)
    public void openTheLogonPage() {
        logon_steps.open_idv_logon_page();
    }


    @When("^I input username \"([^\"]*)\"$")
    public void iInputUsername(String userName) throws Throwable {
        logon_steps.enter_username_into_box(userName);
    }

    @Then(pages)
    public void iSeeTheDBBLandingPageWithProfileSelected(String profile) throws Throwable {
        logon_steps.validate_profile_selected(profile);
    }
}
```
The `LogonSteps` class is an example of a very simple action class.In our sample project, it is used to navihate DBB logon page to home page etc:
```java
public class LogonSteps extends ScenarioSteps {

    LogonPage UNI = new LogonPage();
    SecurityCodeGetPage SCG = new SecurityCodeGetPage();
    ProfileSelectPage PSP = new ProfileSelectPage();
    HomePage HP = new HomePage();

    @Step
    public void open_idv_logon_page(){
        UNI.openURL();
    }
}
```

It does this using a standard Serenity Page Object. I have also used it to interact with the web pages`. This gives the class full access to the  Serenity WebDriver API which handles and manages Selenium Webdriver for us. Elements can be found then by using Selenium Webdriver locators like`By` locator or an XPath or CSS expression: :
```java
@At(".*/portalserver/logon")
public class LogonPage extends PageObject {

    @FindBy(css="#userName")
    private WebElement UserNameInputbox;

    @FindBy(xpath="//span[text()='Log on']/parent::button")
    private WebElement LogonBtn;

    public void openURL(){
        open();
    }
}
```

## Executing the tests
To run the sample project, you can either just run the `WebRunner` test runner class, or run either `mvn clean verify` from the command line.

By default, the tests will run using Chrome. You can run them in Firefox by overriding the `driver` system property, e.g.
```text
$ mvn clean verify -Ddriver=chrome
```

The test results will be recorded in the `target/site/serenity` directory.

## Simplified WebDriver configuration and other Serenity extras
Use `serenity.conf` file in the `src/test/resources` directory to configure test execution options.  
### Webdriver configuration
The WebDriver configuration is managed entirely from this file, as illustrated below:
```hocon
webdriver {
    driver = chrome
}
headless.mode = true

chrome.switches="""--start-maximized;--test-type;--no-sandbox;--ignore-certificate-errors;
                   --disable-popup-blocking;--disable-default-apps;--disable-extensions-file-access-check;
                   --incognito;--disable-infobars,--disable-gpu"""

```

The project also bundles some of the WebDriver binaries that you need to run Selenium tests in the `src/test/resources/webdriver` directories. These binaries are configured in the `drivers` section of the `serenity.conf` config file:
```hocon
drivers {
  windows {
    webdriver.chrome.driver = "src/test/resources/drivers/windows/chromedriver.exe"
    webdriver.gecko.driver = "src/test/resources/drivers/windows/geckodriver.exe"
  }
  mac {
    webdriver.chrome.driver = "src/test/resources/webdriver/mac/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/mac/geckodriver"
  }
  linux {
    webdriver.chrome.driver = "src/test/resources/webdriver/linux/chromedriver"
    webdriver.gecko.driver = "src/test/resources/webdriver/linux/geckodriver"
  }
}
```

### Environment-specific configurations
We can also configure environment-specific properties and options, so that the tests can be run in different environments.
```hocon
environments {
   default {
     webdriver.base.url = "http://192.168.178.143:8080/"
   }
   dev {
     webdriver.base.url = "http://192.168.178.143:8080/dev"
   }
   staging {
     webdriver.base.url = "http://192.168.178.143:8080/staging"
   }
   prod {
     webdriver.base.url = "http://192.168.178.143:8080/prod"
   }
}
```
  
You use the `environment` system property to determine which environment to run against. For example to run the tests in the staging environment, you could run:
```text
$ mvn clean verify -Denvironment=staging
```
