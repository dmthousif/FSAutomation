Feature: Validate login

  Scenario Outline: verify login feature with all the possible test cases
    Given user is on the login page
    When user enters <userName> and <passWord>
    Then user should be able to login successfully

    Examples:
      | userName | passWord |
      | Admin    | admin123 |