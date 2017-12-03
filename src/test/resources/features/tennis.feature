Feature: Tennis game

  Scenario: player Nadal win the game
    Given Nadal and Federer win 40 point
    When Nadal wins point
    Then Nadal wins the game
