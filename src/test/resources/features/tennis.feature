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

  Scenario: a player reach the Set score of 6 and the other player has a Set score of 4 or lower
    Given Nadal and Federer play together
    And the Set score of each other is (5,4)
    And their game score is (40,15)
    When Nadal wins point
    Then Nadal wins the game and the Set

@one
  Scenario: a player reach the Set score of 6 and the other player has a Set score of 5
    Given Nadal and Federer play together
    And the Set score of each other is (6,5)
    And their game score is (40,15)
    When Nadal wins point
    Then Nadal wins the game and the match


  Scenario: Activation of Tie-Break rule
    Given Nadal and Federer play together
    And the Set score of each other is (5,6)
    And their game score is (40,15)
    When Nadal wins point
    Then the Tie-Break rule is activated

  Scenario: Winnig Tie-Break
    Given Nadal and Federer play together
    And Tie-Break rule is activated
    And the score is (6,5)
    When Nadal wins point
    Then Nadal wins the Set and match