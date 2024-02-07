Feature: Delete book
  Scenario: delete one book
    Given there are  books in the library
    When I delete a book with id 1L
    Then List with 0 books should be returned