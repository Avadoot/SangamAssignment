Feature: Sangam Matrimonial App- Login Scenarios

  Scenario:
    Given Clean install and launch demo app
    And I click on Let's begin
    Then I verify the error messages for DOB and community

  Scenario:
    Given Clean install and launch demo app
    And I enter valid data for profile creator, DOB, mother tongue and community
    And I click on Let's begin
    Then I verify on the next page an Email view is present.
