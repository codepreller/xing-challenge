Feature: login
  the user can login with correct login credentials. if the password or the user name are wrong he/she will get a error message

  Scenario: login successful
    When i try to login with correct credentials
    Then i expect to see the start page

  Scenario: incorrect user name
    When i try to login with an incorrect user name
    Then i expect to get an error message

  Scenario: incorrect password
    When i try to login with an incorrect password
    Then i expect to get an error message