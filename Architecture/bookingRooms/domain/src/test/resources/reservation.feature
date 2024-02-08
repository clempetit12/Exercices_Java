Feature: Search available meeting rooms

  Scenario: Search available meeting rooms for a given date and time
    Given there are some meeting rooms
    When I search available meeting rooms for the given date and time
    Then one meeting room is returned
