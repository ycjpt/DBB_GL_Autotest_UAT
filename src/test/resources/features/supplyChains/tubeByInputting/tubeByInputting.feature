@tubeByInputting
Feature: test login_test

  Scenario:Create buyer's customer file selection: operator input, operator input buyer's basic information, no need to review, create buyer's customer successfully
    Given logon "environments_1" on tube by inputting system
    When I click Customers and select Onboarding List
    And I click Create Customer and fill in the information in the pop-up window
    Then Check to see if you jump to the Authorized Person page
    When Fill in "61755832@qq.com" 1 and "yk13008553349@163.com" 2 information on the Authorized Person page