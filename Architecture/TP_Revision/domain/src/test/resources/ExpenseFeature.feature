Feature: Add an expense
  Scenario: User adds a new expense
    Given I add an expense
    When I search for expense with id equals to 1
    Then  1 expense should be returned
