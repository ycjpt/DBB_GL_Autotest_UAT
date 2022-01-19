@systemManagement
Feature: createAdminUsers

  Scenario:createAdminUsers
    Given logon "environments_1" on tube by inputting system
    When login successfully and click the SCF link to createAdminUser
