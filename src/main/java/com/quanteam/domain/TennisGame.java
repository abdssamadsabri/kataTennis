package com.quanteam.domain;

public class TennisGame {


    private Player playerOne;
    private Player playerTwo;
    private String scoreGame;

    public TennisGame(String arg1, String arg2) {
        playerOne = new Player(arg1);
        playerTwo = new Player(arg2);
    }


    public Player getPlayerOne() {
        return playerOne;
    }


    public Player getPlayerTwo() {
        return playerTwo;
    }


    public String getScoreGame() {

        int scorePlayer1;
        int scorePlayer2;
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (score_player_one <= 3 && score_player_two <= 3 && score_player_one != score_player_two) {
            switch (score_player_one) {
                case 0:
                    scorePlayer1 = 0;
                    break;

                case 1:
                    scorePlayer1 = 15;
                    break;
                case 2:
                    scorePlayer1 = 30;
                    break;
                default:
                    scorePlayer1 = 40;
                    break;
            }
            switch (score_player_two) {
                case 0:
                    scorePlayer2 = 0;
                    break;
                case 1:
                    scorePlayer2 = 15;
                    break;
                case 2:
                    scorePlayer2 = 30;
                    break;
                default:
                    scorePlayer2 = 40;
                    break;
            }
            scoreGame = playerOne.getName() + ":" + scorePlayer1 + "-" + scorePlayer2 + ":" + playerTwo.getName();

        }

        if (!isTieBreak()) {
            if (score_player_one >= 3 && score_player_one > score_player_two + 1) {
                scoreGame = playerOne.getName() + " wins the game";
                playerOne.setScore(0);
                playerTwo.setScore(0);
                if (playerOne.getSetScore() == 6 && playerTwo.getSetScore() <= 4) {
                    scoreGame = scoreGame + " and the Set";
                }
                if (playerOne.getSetScore() == 7) {
                    scoreGame = scoreGame + " and the match";
                }

            }
            if (score_player_two >= 3 && score_player_two > score_player_one + 1) {
                scoreGame = playerTwo.getName() + " wins the game";
                playerOne.setScore(0);
                playerTwo.setScore(0);
                if (playerTwo.getSetScore() == 6 && playerOne.getSetScore() <= 4) {
                    scoreGame = scoreGame + " and the Set";
                }
                if (playerTwo.getSetScore() == 7) {
                    scoreGame = scoreGame + " and the match";
                }
            }

            if (score_player_one >= 3 && score_player_one == score_player_two + 1) {
                scoreGame = playerOne.getName() + " has advantage";
            }

            if (score_player_one >= 3 && score_player_two == score_player_one + 1) {
                scoreGame = playerOne.getName() + " has advantage";
            }

            if (score_player_one >= 3 && score_player_one == score_player_two) {
                scoreGame = "DEUCE";
            }
        } else if (isTieBreak()) {
            int tieBreakPlayerOne = playerOne.getTieBreakScore();
            int tieBreakPlayerTwo = playerTwo.getTieBreakScore();
            if (tieBreakPlayerOne >= 7 && tieBreakPlayerOne - tieBreakPlayerTwo >= 2) {
                scoreGame = playerOne.getName() + "wins the Set and the match";
            } else if (tieBreakPlayerTwo >= 7 && tieBreakPlayerTwo - tieBreakPlayerOne >= 2) {
                scoreGame = playerTwo.getName() + "wins the Set and the match";
            } else
                scoreGame = "Tie-Break score = " + playerOne.getName() + ":" + tieBreakPlayerOne + "-" + tieBreakPlayerTwo + ":" + playerTwo.getName();

        }
        return scoreGame;
    }

    public boolean isTieBreak() {
        return (playerOne.getSetScore() == 6 && playerTwo.getSetScore() == 6);
    }

    public void playerOneWinsPoint() {
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (isTieBreak()) {
            int actualTieBreak = playerOne.getTieBreakScore();
            actualTieBreak++;
            playerOne.setTieBreakScore(actualTieBreak);
        } else {
            if (score_player_one >= 3 && score_player_one > score_player_two + 1) {
                int setScore = playerOne.getSetScore();
                setScore++;
                playerOne.setSetScore(setScore);

            } else {
                int actualScore = playerOne.getScore();
                actualScore++;
                playerOne.setScore(actualScore);
            }
        }

    }

    public void playerTwoWinsPoint() {
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (isTieBreak()) {
            int actualTieBreak = playerTwo.getTieBreakScore();
            actualTieBreak++;
            playerTwo.setTieBreakScore(actualTieBreak);
        } else {
            if (score_player_two >= 3 && score_player_two > score_player_one + 1) {

                int setScore = playerTwo.getSetScore();
                setScore++;
                playerTwo.setSetScore(setScore);
            } else {
                int actualScore = playerTwo.getScore();
                actualScore++;
                playerTwo.setScore(actualScore);
            }

        }
    }
}