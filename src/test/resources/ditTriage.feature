Feature: Test New feature scenarios for dit.

  @ditfunctional
  Scenario: Verify user Signin Function
    Given user is able to login with registered details
      | username            | password       |
      | agg.tarun@gmail.com | harrowharrow12 |
    When user checks the login is successful and authenticated
      | Profile | Sign out |
    Then user verifies the profile page
      | agg.tarun@gmail.com. |
    When user is on export Journey Page
    Then the user should be able to create the journey
      | HS10 Cereals | UserTest Company Ltd |
    And the user checks the answers
      | Cereals | Yes | UserTest Company Ltd |
    Then export Journey is created
   
