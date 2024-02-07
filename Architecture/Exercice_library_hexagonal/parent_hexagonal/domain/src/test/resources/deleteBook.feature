Feature: Delete book
  Scenario: delete one book
    Given there is one book in the library with id 1L
    When I delete a book with id 1L
    Then List with 0 books should be returned