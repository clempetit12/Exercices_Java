Feature: Expense Listing
  Scenario: User views a list of expenses
    Given there are two expenses, one with id 1
    And second with id 2
    When the user requests to view the list of expenses
    Then the user should see a summary of all expenses
