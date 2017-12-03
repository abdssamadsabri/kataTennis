Feature: Tennis game


  Scenario: two players reach 40 point
    Given Nadal and Federer play together
    When They reach 40 point
    Then the DEUCE rule is activated

  Scenario: Advantage rule activated
    Given Nadal and Federer play together
    And DEUCE rule is activated
    When Nadal wins point
    Then Nadal takes advantage

  Scenario: winner after advantage
    Given Nadal and Federer play together
    And Nadal has advantage
    When Nadal wins point
    Then Nadal wins the game

  Scenario: loose after advantage
    Given Nadal and Federer play together
    And Nadal has advantage
    When Federer wins point
    Then the DEUCE rule is activated