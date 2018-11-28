Feature: Registration

  As an end user
  I want to register
  So that I can apply for a role in Newcross Healthcare

  Background:
    Given User is on the home page

#happy path scenario
  @register @smoke
  Scenario:Verify the user registration
    When I enter email, short password as "Paswrd" and confirmPassword as "Paswrd"
    And I select register
    Then I should see the error messages for password and unselected checkboxes
    When I enter correct password as "123" and confirmPassword as "123"
    When I select all checkboxes
    And I reselect register
    Then I should navigate to personal details page
    When I enter personal details as "Mr","John","","07655655666"
    And I enter postcode as "IG1 1XG"
    And I select Lookup address as "19a Green Lane"
    And I select next button
    Then I should see the error message as "This field is required"
    When I enter personal details again as "","","Smith",""
    And clicks next button
    Then I should navigate to Qualification & Training page
    When I select Add Qualification
    And I fill the Qualification form as "2018-02T00:00:00.000","Qualification" and "NVQ/SVQ Level 1"
    And I select add button
    And I click next button
    Then I should navigate to history page

