Feature: Checkout
  Scenario Outline: Checkout books
    Given the book "<name>" cost <price>
    When I buy <qty> of the book "<name>"
    Then the total of "<name>" checkout is <total>

    Examples:

    |name|price|qty|total|
    | b1 | 10  | 1 | 10  |
    | b2 | 10  | 2 | 20  |
    | b3 | 20  | 3 | 60  |