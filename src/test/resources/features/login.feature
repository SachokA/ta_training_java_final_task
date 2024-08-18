Feature: Login Form Validation

  Scenario Outline: UC-1 Test Login Form with Empty Credentials
    Given I am on the login page
    When I enter the user name '<Username>' field
    And I enter the password '<Password>'
    And I clear the Name input
    And I clear the Password input
    And I hit the 'Login' button
    Then I should see an error message '<ErrorMessage>'

    Examples:
      | Username         | Password     | ErrorMessage         |
      | standard_user1   | secret_sauce | Username is required |
      | locked_out_user1 | secret_sauce | Username is required |

  Scenario Outline: UC-2 Test Login Form with credentials by passing Username
    Given I am on the login page
    When I enter the user name '<Username>' field
    And I enter the password '<Password>'
    And I clear the Password input
    And I hit the 'Login' button
    Then I should see an error message '<ErrorMessage>'

    Examples:
      | Username    | Password     | ErrorMessage         |
      | error_user  | secret_sauce | Password is required |
      | visual_user | s            | Password is required |

  Scenario Outline: UC-3: Test Login Form with Credentials by Passing Username & Password
    Given I am on the login page
    When I enter the user name '<Username>' field
    And I enter the password '<Password>'
    And I hit the 'Login' button
    Then I should see the title '<ExpectedTitle>' on the dashboard

    Examples:
      | Username                | Password     | ExpectedTitle |
      | standard_user           | secret_sauce | Swag Labs     |
      | performance_glitch_user | secret_sauce | Swag Labs     |
      | error_user              | secret_sauce | Swag Labs     |
      | visual_user             | secret_sauce | Swag Labs     |


