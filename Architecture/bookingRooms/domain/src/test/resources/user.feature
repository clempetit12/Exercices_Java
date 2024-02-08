Feature: Create users
  Scenario: create a user Administator and a user user
    Given there are two users
    When I search for user administrator with usersEnum equals to "ADMINISTRATOR" and id equals to 2
    Then One user returned with id 2

