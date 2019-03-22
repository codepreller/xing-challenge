Feature: user endpoint

  Scenario: get user list
    When i request the user list
    Then i expect to get a http 200 status code
    And i expect to get page 1 of the user list
    And i expect that the total number of pages is 4
    And i expect the list to contain 3 users

  Scenario: get page 2 of the user list
    When i request page 2 of the user list
    Then i expect to get page 2 of the user list
    And i expect that the total number of pages is 4
    And i expect the list to contain 3 users

  Scenario: get an non existing page of the user list
    When i request page 5 of the user list
    Then i expect to get a http 200 status code
    And i expect the list to contain 0 users

  Scenario: get user data by id
    When i request the user with id 2
    Then i expect the users first name is 'Janet'
    And i expect the users last name is 'Weaver'
    And i expect the users avatar url is 'https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg'

  Scenario: user not found
    When i request the user with id 13
    Then i expect to get a http 404 status code

  Scenario: create user
    When i create a new user with first name 'Jane' and last name 'Doe'
    Then i expect to get a http 201 status code

  Scenario: update user via put
    When i put a users first name to 'Jane'
    Then i expect to get a http 200 status code

  Scenario: update user via patch
    When i patch a users first name to 'Jane'
    Then i expect to get a http 200 status code

  Scenario: delete user
    When i delete the user with id 1
    Then i expect to get a http 204 status code