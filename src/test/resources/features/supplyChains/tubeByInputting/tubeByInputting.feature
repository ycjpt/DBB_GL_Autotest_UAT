@tubeByInputting
Feature: tube By Inputtingt


  Scenario:Create buyer's customer file selection: operator input, operator input buyer's basic information, no need to review, create buyer's customer successfully
    Given logon "environments_1" on tube by inputting system
    When I click Customers and select Onboarding List
    And I click Create Customer and fill in the buyer information in the pop-up window
    Then I Check to see if you jump to the Authorized Person page
    When Fill in email 1 and email 2 buyer information on the Authorized Person page
    Then Successfully create buyer customer information


  Scenario:Create your own profile and send invitations
    Given logon "environments_1" on tube by inputting system
    When I click Customers and select Onboarding List
    And I click Create Customer and fill in the supplier information in the pop-up window
    Then I Check to see if you jump to the Authorized Person page
    When Fill in email 1 and email 2 supplier information on the Authorized Person page
    And I click the email icon to send the email
    And I received an email from Green Union Bank on the email page
    Then I check that the email has been sent successfully

    @ext
  Scenario:Create supplier customer profile select: the customer input, the customer input related information, the supplier customer created successfully
      Given logon "environments_1" on tube by inputting system
      When open the email browser page
      And I switch to the SCF page
      When I click Customers and select Onboarding List
      And I click Create Customer and fill in the supplier information in the pop-up window
      Then I Check to see if you jump to the Authorized Person page
      When Fill in email 1 and email 2 supplier information on the Authorized Person page
      And I click the email icon to send the email
      And I received an email from Green Union Bank on the email page
      Then I check that the email has been sent successfully
      