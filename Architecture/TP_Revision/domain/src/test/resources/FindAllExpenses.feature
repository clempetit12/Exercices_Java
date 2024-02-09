Feature: Expense Listing
  Scenario: User views a list of expenses
    Given there are expenses
    When I search for all expenses
    Then List with 1 expense should be returned
