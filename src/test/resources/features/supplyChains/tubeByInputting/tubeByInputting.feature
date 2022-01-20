@tubeByInputting
Feature: tube By Inputtingt


  Scenario:Create buyer's customer file selection: operator input, operator input buyer's basic information, no need to review, create buyer's customer successfully
    Given logon "environments_1" on tube by inputting system
    When I click Customers and select Onboarding List
    And I click Create Customer and fill in the buyer information in the pop-up window
    Then Check to see if you jump to the Authorized Person page
    When Fill in email 1 and email 2 buyer information on the Authorized Person page
    Then Successfully create buyer customer information

  @ext
  Scenario:Create your own profile and send invitations
    Given logon "environments_1" on tube by inputting system
    When I click Customers and select Onboarding List
    And I click Create Customer and fill in the supplier information in the pop-up window
    Then Check to see if you jump to the Authorized Person page
    When Fill in email 1 and email 2 supplier information on the Authorized Person page
    Then Successfully create buyer customer information