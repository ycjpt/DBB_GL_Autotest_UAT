@createBuyerCreditFile
Feature: createBuyerCreditFile

  Scenario:createBuyerCreditFile
    Given logon "environments_1" on tube by inputting system
    When login successfully and click the SCF link to createBuyerCreditFile
    And edit Buyer Credit Profile
    Then submit Buyer Credit Profile
    And  to Buyer Credit Profile Review page
    Then buyer Credit Profile L1 Review
    And change user To L2 Review
    Then login "environments_2" on tube by inputting system
    And use UserL2 to Review
