package com.quanteam.domain;

public class TennisGame {


    private Player playerOne;
    private Player playerTwo;
    private String scoreGame;

    public TennisGame(String arg1, String arg2) {
        playerOne = new Player(arg1);
        playerTwo = new Player(arg2);
    }

    public String getScoreGame() {

        int scorePlayer1;
        int scorePlayer2;
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();

        if (stillInGame()) {
            scorePlayer1 = convertScorePlayer(score_player_one);
            scorePlayer2 = convertScorePlayer(score_player_two);
            scoreGame = playerOne.getName() + ":" + scorePlayer1 + "-" + scorePlayer2 + ":" + playerTwo.getName();
        }

        if (!isTieBreak()) {
            Player playerWithHighestScore = playerWithHighestScore();
            Player playerWithLowestScore = playerWithLowestScore();
            if (WeHaveWinner()) {
                scoreGame = playerWithHighestScore.getName() + " wins the game";
                playerOne.setScore(0);
                playerTwo.setScore(0);
                if (playerWithHighestScore.getSetScore() == 6 && playerWithLowestScore.getSetScore() <= 4) {
                    scoreGame = scoreGame + " and the Set";
                }
                if (playerWithHighestScore.getSetScore() == 7) {
                    scoreGame = scoreGame + " and the match";
                }

            }

            if (playerWithHighestScore.getScore() >= 3 && playerWithHighestScore.getScore() == playerWithLowestScore.getScore() + 1) {
                scoreGame = playerWithHighestScore.getName() + " has advantage";
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

    public Player playerWithHighestScore() {
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (score_player_one > score_player_two) return playerOne;
        else return playerTwo;
    }

    public Player playerWithLowestScore() {
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        if (score_player_one < score_player_two) return playerOne;
        else return playerTwo;
    }

    private boolean WeHaveWinner() {
        return playerWithHighestScore().getScore() >= 3 && playerWithHighestScore().getScore() > playerWithLowestScore().getScore() + 1;
    }

    private boolean stillInGame() {
        int score_player_one = playerOne.getScore();
        int score_player_two = playerTwo.getScore();
        return score_player_one <= 3 && score_player_two <= 3 && score_player_one != score_player_two;
    }

    private int convertScorePlayer(int score_player_one) {
        int scorePlayer;
        switch (score_player_one) {
            case 0:
                scorePlayer = 0;
                break;

            case 1:
                scorePlayer = 15;
                break;
            case 2:
                scorePlayer = 30;
                break;
            default:
                scorePlayer = 40;
                break;
        }
        return scorePlayer;
    }

    public boolean isTieBreak() {
        return (playerOne.getSetScore() == 6 && playerTwo.getSetScore() == 6);
    }

    public void playerOneWinsPoint() {

        if (isTieBreak()) {
            int actualTieBreak = playerOne.getTieBreakScore();
            actualTieBreak++;
            playerOne.setTieBreakScore(actualTieBreak);
        } else {
            if (WeHaveWinner()) {
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

        if (isTieBreak()) {
            int actualTieBreak = playerTwo.getTieBreakScore();
            actualTieBreak++;
            playerTwo.setTieBreakScore(actualTieBreak);
        } else {
            if (WeHaveWinner()) {

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

    public Player getPlayerOne() {
        return playerOne;
    }


    public Player getPlayerTwo() {
        return playerTwo;
    }

}