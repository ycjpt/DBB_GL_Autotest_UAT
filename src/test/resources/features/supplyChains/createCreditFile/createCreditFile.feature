@createBuyerCreditFile
Feature: createBuyerCreditFile

  Scenario:createBuyerCreditFile
    Given logon "environments_1" on tube by inputting system
    When login successfully and click the SCF link to createBuyerCreditFile
    And edit Buyer Credit Profile
    Then submit Buyer Credit Profile