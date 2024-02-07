Feature: Find All Books
  Scenario: get All Books
    Given there are some books in the library
    When I search for books with title started with "toto"
    Then List with 1 book should be returned

